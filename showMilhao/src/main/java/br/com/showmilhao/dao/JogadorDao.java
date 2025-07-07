package br.com.showmilhao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.showmilhao.connection.ConnectionFactory;
import br.com.showmilhao.model.Jogador;
import br.com.showmilhao.util.LogUtil;

public class JogadorDao {
	private Connection conexao;
	private static final String QUERY_CONSULTAR_TODOS = "SELECT * FROM jogador";
	private static final String QUERY_INSERIR_JOGADOR = "INSERT INTO JOGADOR(id,nome,pontuacao) VALUES($next_id,?,?);";
	private static final String QUERY_ATUALIZAR_JOGADOR = "UPDATE jogador SET nome = ?,pontuacao = ? WHERE id = ?";
	private static final String QUERY_LISTAR_RANKING_ORDER_10 = "SELECT * FROM jogador ORDER BY pontuacao desc LIMIT 10";
	private static final String ZERAR_JOGADORES = "delete from jogador;";
	public JogadorDao() {
		conexao = ConnectionFactory.getConexao();
		
	}
	
	public boolean adicionar(Jogador jogador) {
		try {
			
			try (PreparedStatement statement = conexao.prepareStatement(QUERY_INSERIR_JOGADOR)){
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
			
			try (PreparedStatement statement = conexao.prepareStatement(QUERY_ATUALIZAR_JOGADOR)){
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
	
	private List<Jogador> buscar(String sql){
		List<Jogador> lista = new ArrayList<Jogador>();
		
		try {
			try(PreparedStatement statement = conexao.prepareStatement(sql)) {
				try(ResultSet rs = statement.executeQuery()){
					
					while(rs.next()) {
						Jogador jogador = new Jogador();
						jogador.setId(rs.getInt("id"));
						jogador.setNome(rs.getString("nome"));
						jogador.setLinha(rs.getRow());
						jogador.setPontuacao(rs.getInt("pontuacao"));
						lista.add(jogador);
					}
					
				}
			}
			
		} catch (Exception e) {
			LogUtil.getLogger(JogadorDao.class).error(e.getCause().toString());
		}
		
		return lista;
	}
	
	public List<Jogador> listar(){
		return buscar(QUERY_CONSULTAR_TODOS);
	}
	public List<Jogador> listarRanking(){
		return buscar(QUERY_LISTAR_RANKING_ORDER_10);
	}
	
	public void zerarRanking() {
		try {
			try(PreparedStatement statement = conexao.prepareStatement(ZERAR_JOGADORES)){
				statement.executeUpdate();
				conexao.commit();
				
			}
			
			
		} catch (Exception e) {
			LogUtil.getLogger(JogadorDao.class).error(e.getCause().toString());
		}
	}

}
