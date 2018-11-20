package org.table.booking.persistence;

import java.sql.*;
import java.util.LinkedList;

import org.table.booking.domain.Login;

public class DBBroker {
	protected static DBBroker mInstancia = null;
	protected static Connection mBD;
	private static String url = "---";
	private static String driver = "com.mysql.jdbc.Driver";

	private DBBroker() throws Exception {
		connect();
	}

	public static DBBroker getAgente() throws Exception {
		if (mInstancia == null) {
			mInstancia = new DBBroker();
		}
		return mInstancia;
	}

	private void connect() throws Exception {
		Class.forName(driver);
		mBD = DriverManager.getConnection(url);
	}

	public void disconnect() throws Exception {
		mBD.close();
	}

	public int create(String SQL) throws SQLException, Exception {
		connect();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		disconnect();
		return res;
	}

	public int delete(String SQL) throws SQLException, Exception {
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		disconnect();
		return res;
	}

	public int update(String SQL) throws SQLException, Exception {
		connect();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		disconnect();
		return res;
	}

	public LinkedList<Login> readLogin(String SQL) throws SQLException, Exception {
		connect();
		Statement select = mBD.createStatement();

		LinkedList<Login> s = new LinkedList<>();
		ResultSet resultado = select.executeQuery(SQL);
		while (resultado.next()) {
			String usr = resultado.getString("user");
			String pass = resultado.getString("password");

			Login l = new Login(usr, pass);
			s.add(l);
		}

		select.close();
		disconnect();

		return s;
	}

	public ResultSet read(String SQL) throws SQLException, Exception {
		connect();
		Statement select = mBD.createStatement();

		LinkedList<String> s = new LinkedList<>();
		ResultSet resultado = select.executeQuery(SQL);

		select.close();
		disconnect();

		return resultado;
	}

}