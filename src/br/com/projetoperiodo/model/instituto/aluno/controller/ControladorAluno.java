
package br.com.projetoperiodo.model.instituto.aluno.controller;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio;
import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.util.exception.NegocioException;

public interface ControladorAluno extends ControladorNegocio
{

	Aluno cadastrarAluno(Aluno aluno) throws NegocioException;
	
	Aluno buscarAluno(String matricula);
	
	Aluno buscarUsuarioAluno(Usuario usuario);

	boolean verificarPapelDeAlunoDoUsuario(Usuario usuario);
}