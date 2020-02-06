import { Component, OnInit } from '@angular/core';
import { Curso } from 'src/app/model/Curso';
import { CursoService } from 'src/app/service/curso.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-curso',
  templateUrl: './curso.component.html',
  styleUrls: ['./curso.component.css']
})
export class CursoComponent implements OnInit {

  novo: boolean = false;
  curso: Curso = new Curso(null, null, null, null, null, null);
  cursos: Array<Curso> = new Array<Curso>();

  constructor(private route: ActivatedRoute, private router: Router, private cursoService: CursoService) { }

  ngOnInit() {

    let id: number = this.route.snapshot.params["id"];
    this.findAllCursos();

    if (id === undefined) {
      this.novo = true;
    } else {
      this.findById(id);
      this.novo = false;
    }

  }

  findById(id: number) {
    this.cursoService.getById(id).subscribe((curso: Curso) => {
      this.curso = curso;
    });
  }

  findAllCursos(){
    this.cursoService.getAll().subscribe((cursoOut: Curso[])=>{
      this.cursos = cursoOut;
    });
  }

  allCursos(){
    this.cursoService.getAll().subscribe((cursoOut: Curso[])=>{
      this.cursos = new Array<Curso>();
      this.cursos.push(cursoOut[0]);
    },err => {

    });
  }

}
