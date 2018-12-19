package org.table.booking.domain;

public class Reservation {
	private int _reservationID;
	private String _tableID;
	private int _turn;
	private int _diners;
	private String _reservation_hour;

	private ReservationDAO _reservationDAO = new ReservationDAO();

	public Reservation(int _reservationID, String _tableID,
			String _reservation_hour, int _diners,
			int _turn) {
		super();
		this._reservationID = _reservationID;
		this._tableID = _tableID;
		this._turn = _turn;
		this._diners = _diners;
		this._reservation_hour = _reservation_hour;
	}

	public Reservation() {

	}

	public ReservationDAO get_reservationDAO() {
		return _reservationDAO;
	}

	public void set_reservationDAO(
			ReservationDAO _reservationDAO) {
		this._reservationDAO = _reservationDAO;
	}

	public int get_reservationID() {
		return _reservationID;
	}

	public void set_reservationID(int _reservationID) {
		this._reservationID = _reservationID;
	}

	public String get_tableID() {
		return _tableID;
	}

	public void set_tableID(String _tableID) {
		this._tableID = _tableID;
	}

	public int get_turn() {
		return _turn;
	}

	public void set_turn(int _turn) {
		this._turn = _turn;
	}

	public int get_diners() {
		return _diners;
	}

	public void set_diners(int _diners) {
		this._diners = _diners;
	}

	public String get_reservation_hour() {
		return _reservation_hour;
	}

	public void set_reservation_hour(
			String _reservation_hour) {
		this._reservation_hour = _reservation_hour;
	}

}
