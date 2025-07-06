package br.com.showmilhao.test;

import br.com.showmilhao.dao.JogadorDao;
import br.com.showmilhao.model.Jogador;
import br.com.showmilhao.util.LogUtil;

public class InsertDataForTest {
	private static JogadorDao dao = new JogadorDao();
	
	public static void main(String[] args) {
		Jogador jogador = new Jogador("Ana Maria",800);
		
		
		LogUtil.getLogger(InsertDataForTest.class).info(dao.adicionar(jogador));
		
		
		

	}
}
