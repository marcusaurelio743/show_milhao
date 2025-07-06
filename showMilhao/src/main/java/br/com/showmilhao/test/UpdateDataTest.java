package br.com.showmilhao.test;

import br.com.showmilhao.dao.JogadorDao;
import br.com.showmilhao.model.Jogador;

public class UpdateDataTest {
	private static JogadorDao dao = new JogadorDao();

	public static void main(String[] args) {
		Jogador jogador = new Jogador();
		jogador.setId(7);
		jogador.setNome("Andre do Santos Silva");
		jogador.setPontuacao(970);
		dao.atualizar(jogador);

	}

}
