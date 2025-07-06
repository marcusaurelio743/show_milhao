package br.com.showmilhao.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import br.com.showmilhao.util.LogUtil;

public class ConnectionFactory {
	private static final String URL_CONNECTION = "jdbc:sqlite:src/main/resources/data/show_milhao.sqlite";
	private static Connection conexao;
	
	private ConnectionFactory() {
	}
	static {
		conectar();
	}
	private static void conectar() {
		try {
			if(conexao == null) {
				conexao = DriverManager.getConnection(URL_CONNECTION);
				conexao.setAutoCommit(false);
			}
			
		}catch (Exception e) {
			LogUtil.getLogger(ConnectionFactory.class).error(e.getCause().toString());
		}
	}
	
	public static Connection getConexao() {
		return conexao;
	}
	
	

}
