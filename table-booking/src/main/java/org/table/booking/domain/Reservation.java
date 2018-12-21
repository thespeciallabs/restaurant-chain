package org.table.booking.domain;

public class Reservation {
	private int _reservationID;
	private String _tableID;
	private int _turn;
	private int _diners;
	private String _reservation_hour;

	private ReservationDAO _reservationDAO = new ReservationDAO();

	public Reservation(final int _reservationID,
			final String _tableID,
			final String _reservation_hour,
			final int _diners, final int _turn) {
		super();
		this._reservationID = _reservationID;
		this._tableID = _tableID;
		this._turn = _turn;
		this._diners = _diners;
		this._reservation_hour = _reservation_hour;
	}

	public Reservation() {

	}

	public final ReservationDAO get_reservationDAO() {
		return _reservationDAO;
	}

	public final void set_reservationDAO(
			final ReservationDAO _reservationDAO) {
		this._reservationDAO = _reservationDAO;
	}

	public final int get_reservationID() {
		return _reservationID;
	}

	public final void set_reservationID(
			final int _reservationID) {
		this._reservationID = _reservationID;
	}

	public final String get_tableID() {
		return _tableID;
	}

	public final void set_tableID(final String _tableID) {
		this._tableID = _tableID;
	}

	public final int get_turn() {
		return _turn;
	}

	public final void set_turn(final int _turn) {
		this._turn = _turn;
	}

	public final int get_diners() {
		return _diners;
	}

	public final void set_diners(final int _diners) {
		this._diners = _diners;
	}

	public final String get_reservation_hour() {
		return _reservation_hour;
	}

	public final void set_reservation_hour(
			final String _reservation_hour) {
		this._reservation_hour = _reservation_hour;
	}

}
