package org.table.booking.domain;

import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;

import org.table.booking.persistence.DBBroker;

public class TableDAO {
	public LinkedList<Table> _tableList;
	public Table _table;

	public int update(Table aT) {
		try {
			return DBBroker.getAgente().update("UPDATE Tables SET State=" + aT.state() + ", Hour="
					+ (Date) aT.reserved_hour() + " WHERE ID=" + aT.ID() + ";");
		} catch (Exception e) {
			return -1;
		}
	}

	public int delete(Table aT) {
		throw new UnsupportedOperationException();
	}

	public int insert(Table aT) {
		throw new UnsupportedOperationException();
	}

	public int read(Table aT) {
		try {
			ResultSet resultado = DBBroker.getAgente()
					.read("SELECT * FROM Tables WHERE ReservationID=" + aT.reservationID() + ";");
			while (resultado.next()) {
				aT.setID(resultado.getInt(0));
				aT.setTurn(resultado.getInt(1));
				aT.setDiners(resultado.getInt(2));
				aT.setState(resultado.getString("State"));
				aT.setReserved_hour(resultado.getString("Reserved hour"));
				aT.setReservationID(resultado.getString("Reservation ID"));
				this._tableList.add(aT);
			}
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	public int read() {
		try {
			ResultSet resultado = DBBroker.getAgente().read("SELECT * FROM Tables" + ";");
			while (resultado.next()) {
				Table t = new Table(resultado.getInt(0), resultado.getInt(1), resultado.getInt(2),
						resultado.getString("State"), resultado.getDate("Reserved hour"),
						resultado.getString("Reservation ID"));
				this._tableList.add(t);
			}
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}
}