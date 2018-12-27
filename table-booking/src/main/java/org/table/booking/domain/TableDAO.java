package org.table.booking.domain;

import java.sql.ResultSet;
import java.util.LinkedList;

import org.table.booking.persistence.DBBroker;

/*********************************************************************
 *
 * Class Name: TableDAO Author/s name:
 * 
 * @author Sergio Herrera Piqueras
 * @author Juan Mena Patón
 * @author Pablo Rodríguez Solera
 * @author Daniel Martínez Santiago. Release/Creation date:
 *         25/12/2018 Class version:
 * @version 1.0 Class description: This class implements all
 *          the operations related to "Table.java", that is
 *          our table object, and the database. We have the
 *          CRUD operations, with some "Read" operations
 *          modification.
 *
 **********************************************************************
 */
public class TableDAO {
	private LinkedList<Table> _tableList = new LinkedList<Table>();
	private Table _table;

	/**
	 * @return - The list of Tables.
	 */
	public final LinkedList<Table> get_tableList() {
		return _tableList;
	}

	/**
	 * @param _tableList - the list of Tables.
	 */
	public final void set_tableList(
			final LinkedList<Table> _tableList) {
		this._tableList = _tableList;
	}

	/**
	 * @return - A Table object.
	 */
	public final Table get_table() {
		return _table;
	}

	/**
	 * @param _table - A Table object.
	 */
	public final void set_table(final Table _table) {
		this._table = _table;
	}

	/**
	 * @param aT -
	 * @return -
	 */
	/*********************************************************************
	 *
	 * Method name: update
	 *
	 * Name of the original author (if the module author is
	 * different than the author of the file): The authors
	 * do not change.
	 *
	 * Description of the Method: The method creates a
	 * Reservation object with the information provided by
	 * the user.
	 *
	 * Calling arguments:
	 * 
	 * @param aT - The reservation object that the user
	 *           wants to create.
	 *
	 *           Return value:
	 *
	 * @return -1 - If the update operation failed and did
	 *         not complete.
	 *
	 *         Required Files:
	 * 
	 *         None.
	 *
	 *         List of Checked Exceptions and an indication
	 *         of when each exception is thrown.
	 *
	 * @throws Exception e - If there is any kind of failure
	 *                   with the information that we need
	 *                   to update.
	 *********************************************************************/
	public final int update(final Table aT) {
		final String sql = String.format(
				"UPDATE restaurantTables SET state='%s' WHERE tableID='%s';",
				aT.state(), aT.ID());
		try {
			return DBBroker.getAgente().update(sql);
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * @param aT - A Table object.
	 * @return
	 * @throws UnsupportedOperationException - This
	 *                                       operation is
	 *                                       not supported.
	 */
	public final int delete(final Table aT) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @param aT - A Table object.
	 * @return
	 * @throws UnsupportedOperationException - This
	 *                                       operation is
	 *                                       not supported.
	 */
	public final int insert(final Table aT) {
		throw new UnsupportedOperationException();
	}

	/*********************************************************************
	 *
	 * Method name: read
	 *
	 * Name of the original author (if the module author is
	 * different than the author of the file): The authors
	 * do not change.
	 *
	 * Description of the Method: The method checks the
	 * information of a particular Table object.
	 *
	 * Calling arguments:
	 * 
	 * @param aT - The Table object.
	 *
	 *           Return value:
	 *
	 * @return -1 - If the read operation failed and did not
	 *         complete.
	 * @return 0 - If the operation was correct.
	 *
	 *         Required Files:
	 * 
	 *         None.
	 *
	 *         List of Checked Exceptions and an indication
	 *         of when each exception is thrown.
	 *
	 * @throws Exception e - If there is any kind of failure
	 *                   with the information that we need
	 *                   to read.
	 *********************************************************************/
	public final int read(final Table aT) {
		final String sql = String.format(
				"SELECT * FROM restaurantTables WHERE tableID='%s';",
				aT.ID());
		try {
			ResultSet resultado = DBBroker.getAgente()
					.read(sql);
			while (resultado.next()) {
				aT.set_maxdiners(resultado.getInt("sites"));
				aT.setState(resultado.getString("state"));
				this._tableList.add(aT);
			}
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	/*********************************************************************
	 *
	 * Method name: readTable
	 *
	 * Name of the original author (if the module author is
	 * different than the author of the file): The authors
	 * do not change.
	 *
	 * Description of the Method: The method returns the
	 * complete list of tables that is on the Database.
	 *
	 * Calling arguments:
	 * 
	 * None.
	 *
	 * Return value:
	 *
	 * @return aux - The list of Tables that is in the
	 *         Database.
	 * @return null - If there was an error retrieving the
	 *         list of tables from the Database.
	 *
	 *         Required Files:
	 * 
	 *         None.
	 *
	 *         List of Checked Exceptions and an indication
	 *         of when each exception is thrown.
	 *
	 * @throws Exception e - If there is any kind of failure
	 *                   with the information on the
	 *                   Database.
	 *********************************************************************/
	public final LinkedList<Table> read() {
		LinkedList<Table> aux = new LinkedList<>();
		final String sql = String
				.format("SELECT * FROM restaurantTables ;");
		try {
			ResultSet resultado = DBBroker.getAgente()
					.read(sql);
			while (resultado.next()) {
				Table t = new Table(
						resultado.getString("tableID"),
						resultado.getInt("sites"),
						resultado.getString("state"));
				aux.add(t);
			}
		} catch (Exception e) {
			return null;
		}
		return aux;
	}

	/*********************************************************************
	 *
	 * Method name: readFree
	 *
	 * Name of the original author (if the module author is
	 * different than the author of the file): The authors
	 * do not change.
	 *
	 * Description of the Method: The method returns the
	 * Tables that are available to the user to book.
	 *
	 * Calling arguments:
	 * 
	 * @param r - The reservation that the user wants to
	 *          make (including the time, to check it's
	 *          availability).
	 *
	 *          Return value:
	 *
	 * @return aux - If the operation was correct.
	 * @return null - If the read operation failed and did
	 *         not complete.
	 *
	 *         Required Files:
	 * 
	 *         None.
	 *
	 *         List of Checked Exceptions and an indication
	 *         of when each exception is thrown.
	 *
	 * @throws Exception e - If there is any kind of failure
	 *                   with the information that we need
	 *                   to read.
	 *********************************************************************/
	public final LinkedList<Table> readFree(
			final Reservation r) {
		LinkedList<Table> aux = new LinkedList<>();
		final String sql = String.format(
				"SELECT * FROM restaurantTables WHERE state= 'free' AND sites>= %d ;",
				r.get_diners());
		try {
			ResultSet resultado = DBBroker.getAgente()
					.read(sql);
			while (resultado.next()) {
				Table t = new Table(
						resultado.getString("tableID"),
						resultado.getInt("sites"),
						resultado.getString("state"));
				aux.add(t);
			}
		} catch (Exception e) {
			return null;
		}
		return aux;
	}
}
