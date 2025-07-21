package br.com.showmilhao.test;

import java.util.List;

import br.com.showmilhao.dao.JogadorDao;
import br.com.showmilhao.model.Jogador;
import br.com.showmilhao.util.LogUtil;

public class ListarDataForTest {
	private static JogadorDao dao = new JogadorDao();

	public static void main(String[] args) {
		List<Jogador> jogadores = dao.listarRanking();
		List<Jogador> lista = dao.listar();
		
		for (Jogador jogador : jogadores) {
			LogUtil.getLogger(ListarDataForTest.class).info(jogador);
		}
		System.out.println(); 
		//lista.forEach(System.out::println);
		lista.forEach(x-> LogUtil.getLogger(ListarDataForTest.class).info(x));

	}

}
