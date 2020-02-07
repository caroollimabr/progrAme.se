import { Usuario } from '../../model/usuario';
import { CadastroService } from '../../service/cadastro.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-listar-usuario',
  templateUrl: './listar-usuario.component.html',
  styleUrls: ['./listar-usuario.component.css']
})
export class ListarUsuarioComponent implements OnInit {


  cadastrados: Array<Usuario> = new  Array<Usuario>();

  constructor(private cadastroService: CadastroService) { }

  ngOnInit() {
    this.findAll();
  }

  findAll(){
    this.cadastroService.getAll().subscribe((cadastradosOut: Usuario[]) => {
      this.cadastrados = cadastradosOut;
    });
  }

  allUsers(){
    this.cadastroService.getAll().subscribe((cadastradosOut: Usuario[]) => {
      this.cadastrados = new Array<Usuario>();
      this.cadastrados.push(cadastradosOut[0]);
  });

}}

