package br.com.showmilhao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import br.com.showmilhao.connection.ConnectionFactory;
import br.com.showmilhao.model.Pergunta;
import br.com.showmilhao.util.LogUtil;

public class PerguntaDao {
	private Connection connection;
	
	public PerguntaDao() {
		connection = ConnectionFactory.getConexao();
	}
	
	public void adicionar(Pergunta pergunta) {
		try {
			String sql = "INSERT INTO pergunta(id,nivel,enunciado,alternativa1,alternativa2,alternativa3,resposta) VALUES($next_id,?,?,?,?,?,?) ";
			try(PreparedStatement statement = connection.prepareStatement(sql)){
				statement.setString(2, pergunta.getNivel());
				statement.setString(3, pergunta.getEnunciado());
				statement.setString(4,pergunta.getAlternativa1());
				statement.setString(5,pergunta.getAlternativa2());
				statement.setString(6,pergunta.getAlternativa3());
				statement.setString(7,pergunta.getResposta());
				statement.executeUpdate();
				connection.commit();	
			}
			JOptionPane.showMessageDialog(null,"Pergunta Adicionada com Sucesso!!!!","processo concluido!",JOptionPane.INFORMATION_MESSAGE);
			
		} catch (Exception e) {
			LogUtil.getLogger(PerguntaDao.class).error(e.getCause().toString());
		}
		
	}

}
