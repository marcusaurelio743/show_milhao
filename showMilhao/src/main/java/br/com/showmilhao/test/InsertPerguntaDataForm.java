package br.com.showmilhao.test;

import br.com.showmilhao.dao.PerguntaDao;
import br.com.showmilhao.model.Pergunta;

public class InsertPerguntaDataForm {
	private static PerguntaDao dao = new PerguntaDao();

	public static void main(String[] args) {
		Pergunta pergunta = new Pergunta();
		pergunta.setNivel("FACIL");
		pergunta.setEnunciado("qual a cor do cavalo branco?");
		pergunta.setAlternativa1("azul");
		pergunta.setAlternativa2("preto");
		pergunta.setAlternativa3("branco");
		pergunta.setResposta("brancoR");
		dao.adicionar(pergunta);
		
	}

}
