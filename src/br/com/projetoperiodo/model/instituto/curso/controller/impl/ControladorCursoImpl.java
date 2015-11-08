package br.com.projetoperiodo.model.instituto.curso.controller.impl;

import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.model.instituto.curso.controller.ControladorCurso;
import br.com.projetoperiodo.model.instituto.curso.dao.CursoDao;
import br.com.projetoperiodo.model.instituto.curso.impl.CursoImpl;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequenciaImpl;

public class ControladorCursoImpl extends ControladorNegocioImpl implements ControladorCurso
{
	private CursoDao dao;
	
	public ControladorCursoImpl() {
		dao = fabrica.criarCursoDAO();
	}

	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.curso.controller.ControladorCurso#criarEntidadeNegocio()
	 */
	@Override
	public EntidadeNegocio criarEntidadeNegocio() {

		return new CursoImpl();
	}

	@Override
	public Curso buscarCursoPadrao() {

		return dao.buscar(1l);
	}
	@Override
	public String getNomeClasseEntidade() {
		
		return CursoImpl.class.getSimpleName();
	}

}