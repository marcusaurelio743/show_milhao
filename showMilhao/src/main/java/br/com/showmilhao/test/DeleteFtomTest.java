package br.com.showmilhao.test;

import br.com.showmilhao.dao.JogadorDao;
import br.com.showmilhao.util.LogUtil;

public class DeleteFtomTest {
	private static JogadorDao dao = new JogadorDao();

	public static void main(String[] args) {
		dao.zerarRanking();
		LogUtil.getLogger(DeleteFtomTest.class).info("Deletado todos os registros");

	}

}
