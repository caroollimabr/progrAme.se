package com.programese.apiProgramese.model;

public class Curso {
	
	private int id;
	private String nome;
	private String imagem;
	private String descricao;
	private double valor;
	private int duracao;
	
	//constructors
	
	public Curso(int id, String nome, String imagem, String descricao, double valor, int duracao) {
		super();
		this.id = id;
		this.nome = nome;
		this.imagem = imagem;
		this.descricao = descricao;
		this.valor = valor;
		this.duracao = duracao;
	}

	public Curso() {
		
	}


	//getters and setters 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	
	

}
