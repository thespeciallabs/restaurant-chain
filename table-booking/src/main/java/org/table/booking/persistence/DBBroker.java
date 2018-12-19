package org.table.booking.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DBBroker {
	static DBBroker mInstancia = null;
	static Connection mBD;
	private String user, pass, url, driver;

	Properties prop = new Properties();

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
		File f = new File("credentials.properties");
		FileInputStream fis = new FileInputStream(f);
		;
		try {
			prop.load(fis);
			user = prop.getProperty("username");
			pass = prop.getProperty("password");
			url = prop.getProperty("url");
			driver = prop.getProperty("driver");

			Class.forName(driver);
			mBD = DriverManager.getConnection(url, user, pass);
		} finally {
			fis.close();
		}

	}

	public void disconnect() throws Exception {
		mBD.close();
	}

	public int create(String SQL) throws SQLException, Exception {
		connect();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = 0;
		try {
			res = stmt.executeUpdate();
		} finally {
			stmt.close();
			disconnect();
		}
		return res;
	}

	public int delete(String SQL) throws SQLException, Exception {
		connect();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = 0;
		try {
			res = stmt.executeUpdate();
		} finally {
			stmt.close();
			disconnect();
		}
		return res;
	}

	public int update(String SQL) throws SQLException, Exception {
		connect();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = 0;
		try {
			res = stmt.executeUpdate();
		} finally {
			stmt.close();
			disconnect();
		}
		return res;
	}

	public ResultSet read(String SQL) throws SQLException, Exception {
		connect();
		Statement select = mBD.createStatement();
		ResultSet resultado = null;
		try {
			resultado = select.executeQuery(SQL);
		} catch (Exception e) {
			select.close();
		}
		return resultado;
	}

}