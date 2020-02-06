import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { tap, map, filter, distinctUntilChanged, debounceTime, switchMap } from 'rxjs/operators';


@Component({
  selector: 'app-buscar-curso',
  templateUrl: './buscar-curso.component.html',
  styleUrls: ['./buscar-curso.component.css']
})
export class BuscarCursoComponent implements OnInit {

  queryField = new FormControl();
  readonly SEARCH_URL = 'http://localhost:8080/curso';
  results$: Observable<any>;
  total: number;
  readonly FIELDS = 'nome,descricao,duracao,preco';

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.results$ = this.queryField.valueChanges
    .pipe(
      map(value => value.trim()),
      filter(value => value.length > 1),
      debounceTime(200),
      distinctUntilChanged(),
      switchMap(value => this.http.get(this.SEARCH_URL, {
        params: {
          search: value,
          fields: this.FIELDS
        }
      })),
      tap((res: any) => this.total = res.total),
      map((res: any) => res.results)
    );
  }

  onSearch() {
    const fields = 'nome,descricao,duracao,preco';
    let value = this.queryField.value;
    if (value && (value = value.trim()) !== '') {

      // const params_ = {
      //   search: value,
      //   fields: fields
      // };

      let params = new HttpParams();
      params = params.set('search', value);
      params = params.set('fields', fields);

      this.results$ = this.http
        .get(this.SEARCH_URL, { params })
        .pipe(
          tap((res: any) => (this.total = res.total)),
          map((res: any) => res.results)
        );
    }
  }
}
