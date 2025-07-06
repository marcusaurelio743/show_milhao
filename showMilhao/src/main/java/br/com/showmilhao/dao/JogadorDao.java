package br.com.showmilhao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.showmilhao.connection.ConnectionFactory;
import br.com.showmilhao.model.Jogador;
import br.com.showmilhao.util.LogUtil;

public class JogadorDao {
	private Connection conexao;
	
	public JogadorDao() {
		conexao = ConnectionFactory.getConexao();
		
	}
	
	public boolean adicionar(Jogador jogador) {
		try {
			String sql = "INSERT INTO JOGADOR(id,nome,pontuacao) VALUES($next_id,?,?);";
			try (PreparedStatement statement = conexao.prepareStatement(sql)){
				statement.setString(2, jogador.getNome());
				statement.setInt(3, jogador.getPontuacao());
				statement.executeUpdate();
				conexao.commit();
				return true;
			}
			
		}catch (Exception e) {
			LogUtil.getLogger(JogadorDao.class).error(e.getCause().toString());
			return false;
		}
		
		
	}
	
	public void atualizar(Jogador jogador) {
		try {
			String sql = "UPDATE jogador SET nome = ?,pontuacao = ? WHERE id = ?";
			try (PreparedStatement statement = conexao.prepareStatement(sql)){
				statement.setString(1,jogador.getNome());
				statement.setInt(2, jogador.getPontuacao());
				statement.setInt(3, jogador.getId());
				statement.executeUpdate();
				conexao.commit();
				
			}
			
		}catch (Exception e) {
			LogUtil.getLogger(JogadorDao.class).error(e.getCause().toString());
			
		}
		
		
	}

}
