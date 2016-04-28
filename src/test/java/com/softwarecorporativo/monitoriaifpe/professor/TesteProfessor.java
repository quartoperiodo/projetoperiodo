/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwarecorporativo.monitoriaifpe.professor;

import com.softwarecorporativo.monitoriaifpe.MonitoriaTestCase;
import com.softwarecorporativo.monitoriaifpe.curso.Curso;
import com.softwarecorporativo.monitoriaifpe.disciplina.Disciplina;
import com.softwarecorporativo.monitoriaifpe.util.Util;
import com.softwarecorporativo.monitoriaifpe.util.constantes.Constantes;
import java.util.List;
import javax.persistence.TypedQuery;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author douglas
 */
public class TesteProfessor extends MonitoriaTestCase {

    @Test
    public void testePersistProfessor() {
        // DUVIDA
        Professor professor = montarObjetoProfessor();
        Disciplina disciplina = montarObjetoDisciplina();
        disciplina.setProfessor(professor);
        //professor.addDisciplina(disciplina);
        super.entityManager.persist(professor);
        super.entityManager.flush();
        super.entityManager.refresh(professor);
        assertNotNull(professor.getChavePrimaria());

    }

    @Test
    public void testeUpdateProfessor() {
        Professor professorBuscado = super.entityManager.find(Professor.class, 8L);
        String sobrenomeAntigo = professorBuscado.getSobrenome();
        professorBuscado.setSobrenome("Araujo");
        super.entityManager.merge(professorBuscado);
        super.entityManager.flush();
        super.entityManager.clear();
        professorBuscado = super.entityManager.find(Professor.class, 8L);
        assertEquals("Araujo", professorBuscado.getSobrenome());
    }

    @Test
    public void testeJPQLQuantidadeProfessor() {
        TypedQuery<Long> query = super.entityManager.createQuery(
                "SELECT COUNT(p) FROM Professor p WHERE p.login IS NOT NULL", Long.class);
        Long resultado = query.getSingleResult();
        assertEquals(new Long(5), resultado);

    }

    @Test
    public void testeJPQLQuantidadeProfessorLike() {
        TypedQuery<Long> query = super.entityManager.createQuery(
                "SELECT COUNT(p) FROM Professor p WHERE p.sobrenome LIKE :sobrenome", Long.class);
        query.setParameter("sobrenome", "F%");
        Long resultado = query.getSingleResult();
        assertEquals(new Long(2), resultado);

    }

    @Test
    public void testeJPQLProfessorPeloCurso() {
        TypedQuery<String> query = super.entityManager.createQuery(
                "SELECT u.nome FROM Usuario u WHERE u.chavePrimaria IN (SELECT d.professor FROM Disciplina d WHERE d.curso = :curso)", String.class);
        Curso curso = super.entityManager.find(Curso.class, 1L);
        query.setParameter("curso", curso);
        List<String> resultado = query.getResultList();
        assertEquals(4, resultado.size());
    }

    @Test
    public void testeJPQLProfessorPelaDisciplina() {
        TypedQuery<String> query = super.entityManager.createQuery(
                "SELECT u.nome FROM Usuario u WHERE u.chavePrimaria IN (SELECT d.professor FROM Disciplina d WHERE d.descricao = :nomeDisciplina)", String.class);
        query.setParameter("nomeDisciplina", "Engenharia De Requisitos");
        String resultado = query.getSingleResult();
        assertEquals("Renata", resultado);
    }

    @Test
    public void testeJPQLVerificarCONCATProfessores() {
        TypedQuery<String> query = super.entityManager.createQuery(
                "SELECT CONCAT(u.nome,u.sobrenome) FROM Usuario u WHERE u.chavePrimaria IN (SELECT d.professor FROM Disciplina d WHERE d.descricao = :nomeDisciplina)", String.class);
        query.setParameter("nomeDisciplina", "Teste de Software");
        String resultado = query.getSingleResult();
        assertEquals("RamideDantas", resultado);

    }
    
    private Professor montarObjetoProfessor() {
        Professor professor_criado = new Professor();

        professor_criado.setNome("Paulo");
        professor_criado.setSobrenome("Abadie");
        professor_criado.setEmail("PauloAbadie@gmail.com");
        professor_criado.setLogin("PauloAbadie");
        String password = Util.criptografarSenha("senha", "ssenha", Constantes.CONSTANTE_CRIPTOGRAFIA);
        professor_criado.setSenha(password);

        return professor_criado;
    }

    private Disciplina montarObjetoDisciplina() {
        Disciplina disciplina = new Disciplina();
        Curso curso = super.entityManager.find(Curso.class, 1L);
        disciplina.setCurso(curso);
        disciplina.setDescricao("Sistemas De Tempo Real");
        return disciplina;
    }

}