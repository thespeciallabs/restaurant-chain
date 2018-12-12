package org.table.booking.domain;

import java.sql.ResultSet;
import java.util.LinkedList;

import org.table.booking.persistence.DBBroker;

public class ReservationDAO {
	private LinkedList<Reservation> _reservationList = new LinkedList<Reservation>();
	public Reservation _reservation;

	public LinkedList<Reservation> get_reservationList() {
		return _reservationList;
	}

	public void set_reservationList(LinkedList<Reservation> _reservationList) {
		this._reservationList = _reservationList;
	}

	public int delete(Reservation aR) {
		try {
			DBBroker.getAgente()
					.delete("DELETE FROM reservation WHERE reservationID='" + aR.get_reservationID() + "';");

		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	public int insert(Reservation aR) {
		try {
			DBBroker.getAgente().create("INSERT INTO reservation(tableID,reservation_hour,diners,turn) VALUES('"
					+ aR.get_tableID() + "', '" + aR.get_reservation_hour() + "', '" + aR.get_turn() + "';");

		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	public int read(Reservation aR) {
		try {
			ResultSet resultado = DBBroker.getAgente()
					.read("SELECT * FROM reservation WHERE reservationID='" + aR.get_reservationID() + "';");
			while (resultado.next()) {
				aR.set_tableID(resultado.getString("tableID"));
				aR.set_reservation_hour(resultado.getString("reservation_hour"));
				aR.set_diners(resultado.getInt("diners"));
				aR.set_turn(resultado.getInt("turn"));
				this._reservationList.add(aR);
			}
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	public int readTable(Table t) {
		try {
			ResultSet resultado = DBBroker.getAgente()
					.read("SELECT * FROM reservation WHERE tableID='" + t.ID() + "';");
			while (resultado.next()) {
				Reservation r = new Reservation(resultado.getInt("reservationID"), resultado.getString("tableID"),
						resultado.getString("reservation_hour"), resultado.getInt("diners"), resultado.getInt("turn"));
				this._reservationList.add(r);
			}
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	public LinkedList<Reservation> read() {
		LinkedList<Reservation> aux = new LinkedList<>();
		try {
			ResultSet resultado = DBBroker.getAgente().read("SELECT * FROM reservation" + " ;");
			while (resultado.next()) {
				Reservation r = new Reservation(resultado.getInt("reservationID"), resultado.getString("tableID"),
						resultado.getString("reservation_hour"), resultado.getInt("diners"), resultado.getInt("turn"));
				aux.add(r);
			}
		} catch (Exception e) {
			return null;
		}
		return aux;
	}

}
