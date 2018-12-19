package org.table.booking.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public final class DBBroker {
	private static DBBroker mInstancia = null;
	private static Connection mBD;
	private String user, pass, url, driver;

	private Properties prop = new Properties();

	private DBBroker() throws Exception {
		connect();
	}

	public static DBBroker getmInstancia() {
		return mInstancia;
	}

	public static void setmInstancia(DBBroker mInstancia) {
		DBBroker.mInstancia = mInstancia;
	}

	public static DBBroker getAgente() throws Exception {
		if (mInstancia == null) {
			mInstancia = new DBBroker();
		}
		return mInstancia;
	}

	public static Connection getmBD() {
		return mBD;
	}

	public static void setmBD(Connection mBD) {
		DBBroker.mBD = mBD;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	private void connect() throws Exception {
		File f = new File("credentials.properties");
		FileInputStream fis = new FileInputStream(f);

		try {
			prop.load(fis);
			user = prop.getProperty("username");
			pass = prop.getProperty("password");
			url = prop.getProperty("url");
			driver = prop.getProperty("driver");

			Class.forName(driver);
			mBD = (Connection) DriverManager.getConnection(url, user,
					pass);
		} finally {
			fis.close();
		}

	}

	public void disconnect() throws Exception {
		mBD.close();
	}

	public int create(String SQL)
			throws SQLException, Exception {
		connect();
		PreparedStatement stmt = (PreparedStatement) mBD.prepareStatement(SQL);
		int res = 0;
		try {
			res = stmt.executeUpdate();
		} finally {
			stmt.close();
			disconnect();
		}
		return res;
	}

	public int delete(String SQL)
			throws SQLException, Exception {
		connect();
		PreparedStatement stmt = (PreparedStatement) mBD.prepareStatement(SQL);
		int res = 0;
		try {
			res = stmt.executeUpdate();
		} finally {
			stmt.close();
			disconnect();
		}
		return res;
	}

	public int update(String SQL)
			throws SQLException, Exception {
		connect();
		PreparedStatement stmt = (PreparedStatement) mBD.prepareStatement(SQL);
		int res = 0;
		try {
			res = stmt.executeUpdate();
		} finally {
			stmt.close();
			disconnect();
		}
		return res;
	}

	public ResultSet read(String SQL)
			throws SQLException, Exception {
		connect();
		Statement select = (Statement) mBD.createStatement();
		ResultSet resultado = null;
		try {
			resultado = select.executeQuery(SQL);
		} catch (Exception e) {
			select.close();
		}
		return resultado;
	}

}
