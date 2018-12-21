package org.table.booking.domain;

import java.sql.ResultSet;
import java.util.LinkedList;

import org.table.booking.persistence.DBBroker;

public class ReservationDAO {
	private LinkedList<Reservation> _reservationList = new LinkedList<Reservation>();
	private Reservation _reservation;

	public final Reservation get_reservation() {
		return _reservation;
	}

	public final void set_reservation(
			final Reservation _reservation) {
		this._reservation = _reservation;
	}

	public final LinkedList<Reservation> get_reservationList() {
		return _reservationList;
	}

	public final void set_reservationList(
			final LinkedList<Reservation> _reservationList) {
		this._reservationList = _reservationList;
	}

	public final int delete(final Reservation aR) {
		final String sql = String.format(
				"DELETE FROM reservation WHERE reservationID= %d;",
				aR.get_reservationID());
		try {
			DBBroker.getAgente().delete(sql);

		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	public final int insert(final Reservation aR) {
		final String sql = String.format(
				"INSERT INTO reservation(tableID,reservation_hour,diners,turn) VALUES('%s','%s',%d,%d);",
				aR.get_tableID(), aR.get_reservation_hour(),
				aR.get_diners(), aR.get_turn());
		try {
			DBBroker.getAgente().create(sql);

		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	public final int read(final Reservation aR) {
		final String sql = String.format(
				"SELECT * FROM reservation WHERE reservationID='%s';",
				aR.get_reservationID());
		try {
			ResultSet resultado = DBBroker.getAgente()
					.read(sql);
			while (resultado.next()) {
				aR.set_tableID(
						resultado.getString("tableID"));
				aR.set_reservation_hour(resultado
						.getString("reservation_hour"));
				aR.set_diners(resultado.getInt("diners"));
				aR.set_turn(resultado.getInt("turn"));
				this._reservationList.add(aR);
			}
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	public final int readTable(final String tableID) {
		final String sql = String.format(
				"SELECT * FROM reservation WHERE tableID='%s';",
				tableID);
		try {
			ResultSet resultado = DBBroker.getAgente()
					.read(sql);
			while (resultado.next()) {
				Reservation r = new Reservation(
						resultado.getInt("reservationID"),
						resultado.getString("tableID"),
						resultado.getString(
								"reservation_hour"),
						resultado.getInt("diners"),
						resultado.getInt("turn"));
				this._reservationList.add(r);
			}
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	public final LinkedList<Reservation> read() {
		LinkedList<Reservation> aux = new LinkedList<>();
		final String sql = String
				.format("SELECT * FROM reservation ;");
		try {
			ResultSet resultado = DBBroker.getAgente()
					.read(sql);
			while (resultado.next()) {
				Reservation r = new Reservation(
						resultado.getInt("reservationID"),
						resultado.getString("tableID"),
						resultado.getString(
								"reservation_hour"),
						resultado.getInt("diners"),
						resultado.getInt("turn"));
				aux.add(r);
			}
		} catch (Exception e) {
			return null;
		}
		return aux;
	}

}
