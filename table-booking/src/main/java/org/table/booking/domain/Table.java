package org.table.booking.domain;

public class Table {
	private String _ID;
	private int _maxdiners;
	private String _state;
	public TableDAO _tableDAO = new TableDAO();

	public Table() {

	}

	public Table(String i) {
		this._ID = i;
	}

	public Table(String _ID, int maxdiners, String _state) {
		super();
		this._ID = _ID;
		this._maxdiners = maxdiners;
		this._state = _state;
	}

	public String ID() {
		return _ID;
	}

	public void setID(String iD) {
		_ID = iD;
	}

	public String state() {
		return this._state;
	}

	public void setState(String aState) {
		this._state = aState;
	}

	public int get_maxdiners() {
		return _maxdiners;
	}

	public void set_maxdiners(int _maxdiners) {
		this._maxdiners = _maxdiners;
	}

	@Override
	public String toString() {
		return "Table [_ID=" + _ID + ", _maxdiners=" + _maxdiners + ", _state=" + _state + ", _tableDAO=" + _tableDAO
				+ "]";
	}

}