package br.com.showmilhao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.JOptionPane;

import br.com.showmilhao.connection.ConnectionFactory;
import br.com.showmilhao.model.Pergunta;
import br.com.showmilhao.util.LogUtil;

public class PerguntaDao {
	private Connection connection;
	private static final String QUERY_INSERIR = "INSERT INTO pergunta(id,nivel,enunciado,alternativa1,alternativa2,alternativa3,resposta) VALUES($next_id,?,?,?,?,?,?)";
	private static final String QUERY_UPDATE = "UPDATE pergunta set nivel=?,enunciado=?,alternativa1=?,alternativa2=?,alternativa3=?,resposta=? where id=?";
	private static final String QUERY_DELETAR = "DELETE FROM pergunta WHERE ID=	?";
	private static final String ok = "processo concluido!";
	private static int message_Type = JOptionPane.INFORMATION_MESSAGE;
	
	public PerguntaDao() {
		connection = ConnectionFactory.getConexao();
	}
	
	public void adicionar(Pergunta pergunta) {
		try {
		
			try(PreparedStatement statement = connection.prepareStatement(QUERY_INSERIR)){
				statement.setString(2, pergunta.getNivel());
				statement.setString(3, pergunta.getEnunciado());
				statement.setString(4,pergunta.getAlternativa1());
				statement.setString(5,pergunta.getAlternativa2());
				statement.setString(6,pergunta.getAlternativa3());
				statement.setString(7,pergunta.getResposta());
				statement.executeUpdate();
				connection.commit();	
			}
			JOptionPane.showMessageDialog(null,"Pergunta Adicionada com Sucesso!!!!",ok,message_Type);
			
		} catch (Exception e) {
			LogUtil.getLogger(PerguntaDao.class).error(e.getCause().toString());
		}
		
	}
	
	public void atualizar(Pergunta pergunta) {
		try {
		
			try(PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE)){
				statement.setString(1, pergunta.getNivel());
				statement.setString(2, pergunta.getEnunciado());
				statement.setString(3,pergunta.getAlternativa1());
				statement.setString(4,pergunta.getAlternativa2());
				statement.setString(5,pergunta.getAlternativa3());
				statement.setString(6,pergunta.getResposta());
				statement.setInt(7,pergunta.getId());
				statement.executeUpdate();
				connection.commit();	
			}
			JOptionPane.showMessageDialog(null,"Alterações realizadas com sucesso!",ok,message_Type);
			
		} catch (Exception e) {
			LogUtil.getLogger(PerguntaDao.class).error(e.getCause().toString());
		}
		
	}
	
	public void deletar(Integer id) {
		try {
			
			try(PreparedStatement statement = connection.prepareStatement(QUERY_DELETAR)){
				statement.setInt(1, id);
				statement.executeUpdate();
				connection.commit();
				
			}
			JOptionPane.showMessageDialog(null,"Pergunta apagada com sucesso!",ok,message_Type);
			
		}catch (Exception e) {
			LogUtil.getLogger(PerguntaDao.class).error(e.getCause().toString());
		}
	}
	
	private List<Pergunta> buscar(String sql,String nivel){
		List<Pergunta> perguntas = new ArrayList<Pergunta>();
		
		try{
			try(PreparedStatement statement = connection.prepareStatement(sql)){
				if(Objects.nonNull(nivel)) {
					statement.setString(1, nivel);
				}
				try (ResultSet resultado = statement.executeQuery()){
					while(resultado.next()) {
						Pergunta pergunta = new Pergunta();
						pergunta.setId(resultado.getInt("id"));
						pergunta.setNivel(resultado.getString("nivel"));
						pergunta.setEnunciado(resultado.getString("enunciado"));
						pergunta.setAlternativa1(resultado.getString("alternativa1"));
						pergunta.setAlternativa2(resultado.getString("alternativa2"));
						pergunta.setAlternativa3(resultado.getString("alternativa3"));
						pergunta.setResposta(resultado.getString("resposta"));
						
						perguntas.add(pergunta);
					}
					
				}
			}
			
		}catch (Exception e) {
			LogUtil.getLogger(PerguntaDao.class).error(e.getCause().toString());
		}
		return perguntas;
	}

}
