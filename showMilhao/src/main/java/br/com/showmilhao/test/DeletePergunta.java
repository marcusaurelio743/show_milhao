package br.com.showmilhao.test;

import br.com.showmilhao.dao.PerguntaDao;

public class DeletePergunta {
	private static PerguntaDao dao = new PerguntaDao();

	public static void main(String[] args) {
		dao.deletar(5);

	}

}
