package com.programese.apiProgramese.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.programese.apiProgramese.model.Curso;
import com.programese.spiProgramese.service.CursoService;


@RestController
@CrossOrigin("*")
public class CursoController {
	CursoService cursoService = new CursoService();
	
	@GetMapping("/curso")
	public List<Curso> getAll(){
		return cursoService.getAll();
	}
	
	@GetMapping("/curso/{id}")
	public ResponseEntity<Curso> getById(@PathVariable int id){
		Curso curso = cursoService.getById(id);
		if (curso == null)
			ResponseEntity.notFound();
		
		return ResponseEntity.ok(curso);
	}
	
	@PostMapping("/curso")
	public ResponseEntity<Curso> insert(@RequestBody Curso curso){
		if(curso.getId() != 0)
			return ResponseEntity.badRequest().body(curso);
		
		cursoService.insert(curso);
		return ResponseEntity.ok(curso);
	}
	
	@PutMapping("/curso")
	public Curso update(@RequestBody Curso curso) {
		cursoService.update(curso);
		return curso;
	}
	
	@DeleteMapping("/curso/{id}")
	public void delete (@PathVariable int id) {
		cursoService.delete(id);
	}

	
}
