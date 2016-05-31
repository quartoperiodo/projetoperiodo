/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwarecorporativo.monitoriaifpe.servico;

import com.softwarecorporativo.monitoriaifpe.modelo.negocio.EntidadeNegocio;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author Edmilson Santana
 * @param <T>
 */
public abstract class GenericService<T extends EntidadeNegocio> implements Serializable {

    private static final long serialVersionUID = 6861187490716747057L;

    @PersistenceContext(unitName = "monitoriaifpe-unit-dev", type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    public T buscarEntidade(Long chavePrimaria) {
        return entityManager.find(getClasseEntidade(), chavePrimaria);
    }

    public T salvar(T entidadeNegocio) {
        this.entityManager.persist(entidadeNegocio);
        return entidadeNegocio;
    }

    public List<T> listarTodos() {
        StringBuilder jpql = new StringBuilder();
        jpql.append("select entidadeNegocio from ");
        jpql.append(getClasseEntidade().getSimpleName());
        jpql.append(" as entidadeNegocio ");
        Query query = entityManager.createQuery(jpql.toString(), getClasseEntidade());
        return query.getResultList();
    }

    public void remover(T entidadeNegocio) {
        this.entityManager.remove(entidadeNegocio);
    }

    public void atualizar(T entidadeNegocio) {
        this.entityManager.merge(entidadeNegocio);
    }

    public abstract T getEntidadeNegocio();

    public abstract Class<T> getClasseEntidade();
}
