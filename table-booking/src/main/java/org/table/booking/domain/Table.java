package org.table.booking.domain;

/*********************************************************************
*
* Class Name: Table
* Author/s name: 
* 				 @author Sergio Herrera Piqueras
* 				 @author Juan Mena Patón
* 				 @author Pablo Rodríguez Solera 
* 				 @author Daniel Martínez Santiago.
* Release/Creation date: 25/12/2018
* Class version: 
* 				 @version 1.0
* Class description: This class holds all the parameters of our "Table" object.
*
**********************************************************************
*/
public class Table {
	private String _ID;
	private int _maxdiners;
	private String _state;
	private TableDAO _tableDAO = new TableDAO();

	/**
	 *  Empty constructor.
	 */
	public Table() {

	}

	/**
	 * @param i
	 */
	public Table(final String i) {
		this._ID = i;
	}

	/**
	 * @param _ID - The ID of the table.
	 * @param maxdiners - The maximum number of diners.
	 * @param _state - The current state of the table.
	 */
	public Table(final String _ID, final int maxdiners,
			final String _state) {
		super();
		this._ID = _ID;
		this._maxdiners = maxdiners;
		this._state = _state;
	}

	/**
	 * @return - The tableDAO object.
	 */
	public final TableDAO get_tableDAO() {
		return _tableDAO;
	}

	/**
	 * @param _tableDAO - The tableDAO object.
	 */
	public final void set_tableDAO(
			final TableDAO _tableDAO) {
		this._tableDAO = _tableDAO;
	}

	/**
	 * @return - The ID of the table.
	 */
	public final String ID() {
		return _ID;
	}

	/**
	 * @param iD - The ID of the table.
	 */
	public final void setID(final String iD) {
		_ID = iD;
	}

	/**
	 * @return - The current state of the table.
	 */
	public final String state() {
		return this._state;
	}

	/**
	 * @param aState - The current state of the table.
	 */
	public final void setState(final String aState) {
		this._state = aState;
	}

	/**
	 * @return - The maximun number of diners.
	 */
	public final int get_maxdiners() {
		return _maxdiners;
	}

	/**
	 * @param _maxdiners - The maximun number of diners.
	 */
	public final void set_maxdiners(final int _maxdiners) {
		this._maxdiners = _maxdiners;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public final String toString() {
		return "Table [_ID=" + _ID + ", _maxdiners="
				+ _maxdiners + ", _state=" + _state
				+ ", _tableDAO=" + _tableDAO + "]";
	}

}
