package com.programese.spiProgramese.service;

import java.util.ArrayList;
import java.util.List;

import com.programese.apiProgramese.model.Curso;

public class CursoService {

	static List<Curso> cursos = new ArrayList<Curso>();
	
	private static int incr = 0;
	
	
	public Curso insert (Curso curso) {
		incr++;
		curso.setId(incr);
		this.cursos.add(curso);
		return curso;
	}
	
	public Curso update (Curso curso) {
		Curso aux = getById(curso.getId());
		
		if(aux != null) {
			aux.setNome(curso.getNome());
			aux.setImagem(curso.getImagem());
			aux.setDescricao(curso.getDescricao());
			aux.setValor(curso.getValor());
			aux.setDuracao(curso.getDuracao());
		}
		return aux;
	}
	public void delete(Curso curso) {
		delete(curso.getId());
	}
	
	public void delete(int id) {
		int posicao = -1;
		for (int i = 0; i < this.cursos.size(); i++) {
			if(this.cursos.get(i).getId() == id) {
				posicao = i;
				break;
			}
		}
		if (posicao >= 0)
			this.cursos.remove(posicao);
	}
	public Curso getById(int id) {
		for (Curso curso : cursos) {
			if(curso.getId() == id) {
				return curso;
			}
		}
		return null;
	}
	public List<Curso> getAll(){
		return cursos;
	}
}
