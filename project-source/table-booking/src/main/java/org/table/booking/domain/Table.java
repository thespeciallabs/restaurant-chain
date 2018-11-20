package org.table.booking.domain;

import java.util.Date;

public class Table {
	private int _ID;
	private int _turn;
	private int _diners;
	private String _state;
	private Date _reserved_hour;
	private String _reservationID;
	public TableDAO _tableDAO;

	public Table() {

	}

	public Table(int i) {
		this._ID = i;
	}

	public Table(int _ID, int _turn, int _diners, String _state, Date _reserved_hour, String _reservationID) {
		super();
		this._ID = _ID;
		this._turn = _turn;
		this._diners = _diners;
		this._state = _state;
		this._reserved_hour = _reserved_hour;
		this._reservationID = _reservationID;
	}

	public String reservationID() {
		return _reservationID;
	}

	public void setReservationID(String reservationID) {
		this._reservationID = reservationID;
	}

	public int ID() {
		return _ID;
	}

	public void setID(int iD) {
		_ID = iD;
	}

	public int turn() {
		return this._turn;
	}

	public int diners() {
		return this._diners;
	}

	public String state() {
		return this._state;
	}

	public Date reserved_hour() {
		return this._reserved_hour;
	}

	public void setTurn(int aTurn) {
		this._turn = aTurn;
	}

	public void setState(String aState) {
		this._state = aState;
	}

	public void setReserved_hour(Object aReserved_hour) {
		throw new UnsupportedOperationException();
	}

	public void setDiners(int _diners) {
		this._diners = _diners;
	}

	@Override
	public String toString() {
		return "Table [_ID=" + _ID + ", _turn=" + _turn + ", _diners=" + _diners + ", _state=" + _state
				+ ", _reserved_hour=" + _reserved_hour + ", _reservationID=" + _reservationID + ", _tableDAO="
				+ _tableDAO + "]";
	}

}