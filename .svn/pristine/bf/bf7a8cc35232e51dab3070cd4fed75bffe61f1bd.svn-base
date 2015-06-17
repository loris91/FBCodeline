package bingQuery;
import java.sql.*;


public class DBManager {
	
	public DBManager(){
		super();
	}

	public void createTable()
	{
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:Utenti.db");
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			String sql = "CREATE TABLE UTENTI " +
					"(ID INT PRIMARY KEY     NOT NULL," +
					" NOME          TEXT    NOT NULL,"+ "PREDICATO TEXT NOT NULL )"; 
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Table created successfully");
	}

	/*
	 * estae gli utenti "interessati
	 */
	public String userExtractor(int id) throws Exception{
		Class.forName("org.sqlite.JDBC");
		String user ="";
		Connection conn = DriverManager.getConnection("jdbc:sqlite:Utenti.db");
		conn.setAutoCommit(false);

		Statement stat = conn.createStatement();
		String selectSQL = "SELECT NOME FROM utenti3 WHERE ID=?";

		PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
		preparedStatement.setInt(1, id);

		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()){
			user =	rs.getString("NOME");

		}
		stat.close();
		rs.close();
		conn.close();
		return user;
	}


	public String PredicatoExtractor(int id) throws Exception{
		Class.forName("org.sqlite.JDBC");
		String predicato ="";
		Connection conn = DriverManager.getConnection("jdbc:sqlite:Utenti.db");
		conn.setAutoCommit(false);

		Statement stat = conn.createStatement();
		String selectSQL = "SELECT PREDICATO FROM utenti3 WHERE ID=?";

		PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
		preparedStatement.setInt(1, id);

		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()){
			predicato =	rs.getString("PREDICATO");
		}
		stat.close();
		rs.close();
		conn.close();
		return predicato;
	}
	
	/* 
	 * inserisci un utente nella tabella, nella fase di retrieve
	 */
	public void insertUser(int id, String person, String predicato) throws Exception{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:Utenti.db");
		conn.setAutoCommit(false);
		Statement stat = conn.createStatement();
		PreparedStatement prep = conn.prepareStatement("insert into utenti3 values (?, ?,?);");
		prep.setInt(1, id);
		prep.setString(2, person);
		prep.setString(3, predicato);

		prep.addBatch();
		conn.setAutoCommit(false);
		prep.executeBatch();
		conn.setAutoCommit(true);
		System.out.println("inserito");
		conn.close();
	}

	public void deleteUser(String id) throws Exception{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:test2.db");
		conn.setAutoCommit(false);
		Statement stat = conn.createStatement();
		PreparedStatement prep = conn.prepareStatement("DELETE FROM utenti3 WHERE ID=?");
		prep.setString(1, id);
		prep.addBatch();
		conn.setAutoCommit(false);
		prep.executeBatch();
		conn.setAutoCommit(true);
		System.out.println("rimosso");
		conn.close();
	}
}
