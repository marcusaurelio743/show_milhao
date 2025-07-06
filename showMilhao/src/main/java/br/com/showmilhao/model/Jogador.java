package br.com.showmilhao.model;

import java.util.Objects;

public class Jogador {
	private Integer id;
	private String nome;
	private Integer pontuacao;

	private Integer linha;

	public Jogador() {
		nome = "";
		linha = 0;
		pontuacao = 0;
	}
	
	

	public Jogador(String nome, Integer pontuacao) {
		this.nome = nome;
		this.pontuacao = pontuacao;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Integer getLinha() {
		return linha;
	}

	public void setLinha(Integer linha) {
		this.linha = linha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
