/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwarecorporativo.monitoriaifpe.servico;

import com.softwarecorporativo.monitoriaifpe.modelo.curso.Curso;
import com.softwarecorporativo.monitoriaifpe.modelo.disciplina.Disciplina;
import com.softwarecorporativo.monitoriaifpe.modelo.periodo.Periodo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.TypedQuery;

/**
 *
 * @author Edmilson Santana
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class DisciplinaService extends GenericService<Disciplina> {

    @EJB
    private PeriodoService periodoService;

    @Override
    public Disciplina getEntidadeNegocio() {
        return new Disciplina();
    }

    @Override
    public Class<Disciplina> getClasseEntidade() {
        return Disciplina.class;
    }

    public Disciplina salvarDisciplinaComPeriodoAtual(Disciplina entidadeNegocio) {
        Periodo periodo = periodoService.obterPeriodoAtual();
        entidadeNegocio.setPeriodo(periodo);
        return super.salvar(entidadeNegocio);
    }

    public List<Disciplina> obterDisciplinasDoCursoPorPeriodo(Curso curso, Periodo periodo) {

        StringBuilder jpql = new StringBuilder();
        jpql.append(" select disciplina from ");
        jpql.append(getClasseEntidade().getSimpleName());
        jpql.append(" as disciplina ");
        jpql.append(" join disciplina.componenteCurricular as cc ");
        jpql.append(" where disciplina.periodo = :paramPeriodo ");
        jpql.append(" and cc.curso = :paramCurso ");
        TypedQuery<Disciplina> query = super.entityManager
                .createQuery(jpql.toString(), getClasseEntidade());
        query.setParameter("paramPeriodo", periodo);
        query.setParameter("paramCurso", curso);
        
        return query.getResultList();
    }
    
    public List<Disciplina> obterDisciplinasPorCursoDoPeriodoAtual(Curso curso) {
        Periodo periodo = periodoService.obterPeriodoAtual();
        return this.obterDisciplinasDoCursoPorPeriodo(curso, periodo);
    }
}