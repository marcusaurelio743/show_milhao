package br.com.showmilhao.test;

import br.com.showmilhao.dao.PerguntaDao;
import br.com.showmilhao.model.Pergunta;

public class UpdatePergunta {
	private static PerguntaDao dao = new PerguntaDao();
	
	public static void main(String[] args) {
		Pergunta pergunta = new Pergunta();
		pergunta.setNivel("DIFICIL");
		pergunta.setEnunciado("qual a cor do cavalo PRETO?");
		pergunta.setAlternativa1("azul");
		pergunta.setAlternativa2("rosa");
		pergunta.setAlternativa3("preto");
		pergunta.setResposta("pretoR");
		pergunta.setId(2);
		dao.atualizar(pergunta);

	}

}
