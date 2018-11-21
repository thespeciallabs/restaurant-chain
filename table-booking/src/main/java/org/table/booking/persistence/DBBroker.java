package org.table.booking.persistence;

import java.sql.*;

public class DBBroker {
	protected static DBBroker mInstancia = null;
	protected static Connection mBD;
	private static String url = "jdbc:mysql://192.168.1.39/restaurant-chain?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String driver = "com.mysql.cj.jdbc.Driver";

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
		mBD = DriverManager.getConnection(url, "root", "12345");
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

	public ResultSet read(String SQL) throws SQLException, Exception {
		connect();
		Statement select = mBD.createStatement();
		ResultSet resultado = select.executeQuery(SQL);
		return resultado;
	}

}