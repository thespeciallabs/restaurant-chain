package org.table.booking.domain;

public class Table {
	private String _ID;
	private int _maxdiners;
	private String _state;
	private TableDAO _tableDAO = new TableDAO();

	public Table() {

	}

	public Table(final String i) {
		this._ID = i;
	}

	public Table(final String _ID, final int maxdiners,
			final String _state) {
		super();
		this._ID = _ID;
		this._maxdiners = maxdiners;
		this._state = _state;
	}

	public final TableDAO get_tableDAO() {
		return _tableDAO;
	}

	public final void set_tableDAO(
			final TableDAO _tableDAO) {
		this._tableDAO = _tableDAO;
	}

	public final String ID() {
		return _ID;
	}

	public final void setID(final String iD) {
		_ID = iD;
	}

	public final String state() {
		return this._state;
	}

	public final void setState(final String aState) {
		this._state = aState;
	}

	public final int get_maxdiners() {
		return _maxdiners;
	}

	public final void set_maxdiners(final int _maxdiners) {
		this._maxdiners = _maxdiners;
	}

	@Override
	public final String toString() {
		return "Table [_ID=" + _ID + ", _maxdiners="
				+ _maxdiners + ", _state=" + _state
				+ ", _tableDAO=" + _tableDAO + "]";
	}

}
