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

/*********************************************************************
 *
 * Class Name: DBBroker Author/s name:
 * @author Sergio Herrera Piqueras
 * @author Juan Mena Patón
 * @author Pablo Rodríguez Solera
 * @author Daniel Martínez Santiago. Release/Creation date:
 *         25/12/2018 Class version:
 * @version 1.0 Class description: This class performs the
 *          operations with the database, including the
 *          connection and the CRUD operations.
 *
 **********************************************************************
 */
public final class DBBroker {
    private static DBBroker mInstancia = null;
    private static Connection mBD;
    private String user, pass, url, driver;

    private Properties prop = new Properties();

    /**
     * @throws Exception - If there was an error with the
     *                   connection of the Database.
     */
    private DBBroker() throws Exception {
        connect();
    }

    /**
     * @return - The particular instance of the DBBroker.
     */
    public static DBBroker getmInstancia() {
        return mInstancia;
    }

    /**
     * @param mInstancia - The particular instance of the
     *                   DBBroker.
     */
    public static void setmInstancia(
            final DBBroker mInstancia) {
        DBBroker.mInstancia = mInstancia;
    }

    /**
     * @return - The particular instance of the DBBroker.
     * @throws Exception - If there was an error retrieving
     *                   the instance.
     */
    public static DBBroker getAgente() throws Exception {
        if (mInstancia == null) {
            mInstancia = new DBBroker();
        }
        return mInstancia;
    }

    /**
     * @return - The connection with the Database.
     */
    public static Connection getmBD() {
        return mBD;
    }

    /**
     * @param mBD - The connection with the Database.
     */
    public static void setmBD(final Connection mBD) {
        DBBroker.mBD = mBD;
    }

    /**
     * @return - The properties of the Database.
     */
    public Properties getProp() {
        return prop;
    }

    /**
     * @param prop - The properties of the Database.
     */
    public void setProp(final Properties prop) {
        this.prop = prop;
    }

    /*********************************************************************
     *
     * Method name: connect
     *
     * Name of the original author (if the module author is
     * different than the author of the file): The authors
     * do not change.
     *
     * Description of the Method: The method creates a
     * connection with the Database with all the
     * appropriated parameters.
     *
     * Calling arguments:
     * None.
     *
     * Return value:
     * None.
     *
     * Required Files:
     * None.
     *
     * List of Checked Exceptions and an indication of when
     * each exception is thrown.
     *
     * @throws Exception - If there was an error with the
     *                   Database.
     *********************************************************************/
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
            mBD = (Connection) DriverManager
                    .getConnection(url, user, pass);
        } finally {
            fis.close();
        }

    }

    /*********************************************************************
     *
     * Method name: disconnect
     *
     * Name of the original author (if the module author is
     * different than the author of the file): The authors
     * do not change.
     *
     * Description of the Method: The method closes the
     * connection with the Database.
     *
     * Calling arguments:
     * None.
     *
     * Return value:
     * None.
     *
     * Required Files:
     * None.
     *
     * List of Checked Exceptions and an indication of when
     * each exception is thrown.
     *
     * @throws Exception - If there was an error with the
     *                   Database.
     *********************************************************************/
    public void disconnect() throws Exception {
        mBD.close();
    }

    /*********************************************************************
     *
     * Method name: create
     *
     * Name of the original author (if the module author is
     * different than the author of the file): The authors
     * do not change.
     *
     * Description of the Method: The method introduces
     * information on the Database.
     *
     * Calling arguments:
     * @param SQL - The SQL sentence.
     *
     * Return value:
     * @return - The result of the operation.
     *
     * Required Files:
     * None.
     *
     * List of Checked Exceptions and an indication
     * of when each exception is thrown.
     *
     * @throws SQLException - If there is an error related
     *                      with SQL.
     * @throws Exception    - If there was an error with the
     *                      Database.
     *********************************************************************/
    public int create(final String SQL)
            throws SQLException, Exception {
        connect();
        PreparedStatement stmt = (PreparedStatement) mBD
                .prepareStatement(SQL);
        int res = 0;
        try {
            res = stmt.executeUpdate();
        } finally {
            stmt.close();
            disconnect();
        }
        return res;
    }

    /*********************************************************************
     *
     * Method name: delete
     *
     * Name of the original author (if the module author is
     * different than the author of the file): The authors
     * do not change.
     *
     * Description of the Method: The method removes
     * information from the Database.
     *
     * Calling arguments:
     * @param SQL - The SQL sentence.
     *
     *            Return value:
     *
     * @return - The result of the operation.
     *
     * Required Files:
     * None.
     *
     * List of Checked Exceptions and an indication
     * of when each exception is thrown.
     *
     * @throws SQLException - If there is an error related
     *                      with SQL.
     * @throws Exception    - If there was an error with the
     *                      Database.
     *********************************************************************/
    public int delete(final String SQL)
            throws SQLException, Exception {
        connect();
        PreparedStatement stmt = (PreparedStatement) mBD
                .prepareStatement(SQL);
        int res = 0;
        try {
            res = stmt.executeUpdate();
        } finally {
            stmt.close();
            disconnect();
        }
        return res;
    }

    /*********************************************************************
     *
     * Method name: update
     *
     * Name of the original author (if the module author is
     * different than the author of the file): The authors
     * do not change.
     *
     * Description of the Method: The method updates
     * information already existing on the Database.
     *
     * Calling arguments:
     * @param SQL - The SQL sentence.
     *
     * Return value:
     * @return - The result of the operation.
     *
     * Required Files:
     * None.
     *
     * List of Checked Exceptions and an indication
     * of when each exception is thrown.
     *
     * @throws SQLException - If there is an error related
     *                      with SQL.
     * @throws Exception    - If there was an error with the
     *                      Database.
     *********************************************************************/
    public int update(final String SQL)
            throws SQLException, Exception {
        connect();
        PreparedStatement stmt = (PreparedStatement) mBD
                .prepareStatement(SQL);
        int res = 0;
        try {
            res = stmt.executeUpdate();
        } finally {
            stmt.close();
            disconnect();
        }
        return res;
    }

    /*********************************************************************
     *
     * Method name: read
     *
     * Name of the original author (if the module author is
     * different than the author of the file): The authors
     * do not change.
     *
     * Description of the Method: The method retrieves
     * information already existing on the Database.
     *
     * Calling arguments:
     * @param SQL - The SQL sentence.
     *
     * Return value:
     * @return - The result of the operation.
     *
     * Required Files:
     * None.
     *
     * List of Checked Exceptions and an indication
     * of when each exception is thrown.
     *
     * @throws SQLException - If there is an error related
     *                      with SQL.
     * @throws Exception    - If there was an error with the
     *                      Database.
     *********************************************************************/
    public ResultSet read(final String SQL)
            throws SQLException, Exception {
        connect();
        Statement select = (Statement) mBD
                .createStatement();
        ResultSet resultado = null;
        try {
            resultado = select.executeQuery(SQL);
        } catch (Exception e) {
            select.close();
        }
        return resultado;
    }

}
