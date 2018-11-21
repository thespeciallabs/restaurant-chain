package org.table.booking.domain;

import java.sql.ResultSet;
import java.sql.Time;
import java.util.LinkedList;

import org.table.booking.persistence.DBBroker;

public class TableDAO {
	public LinkedList<Table> _tableList = new LinkedList<Table>();
	public Table _table;

	public int update(Table aT) {
		try {
			return DBBroker.getAgente().update("UPDATE tables SET state='" + aT.state() + "', reserved_hour='"
					+ "'00:00:00'" + "' WHERE tableID='" + aT.ID() + "';");
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
					.read("SELECT * FROM tables WHERE reservationID='" + aT.reservationID() + "';");
			while (resultado.next()) {
				aT.setID(resultado.getInt(1));
				aT.setTurn(resultado.getInt(2));
				aT.setDiners(resultado.getInt(3));
				aT.setState(resultado.getString("state"));
				aT.setReserved_hour(resultado.getString("reserved_hour"));
				aT.setReservationID(resultado.getString("reservationID"));
				this._tableList.add(aT);
			}
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	public int readOne(Table aT) {
		try {
			ResultSet resultado = DBBroker.getAgente().read("SELECT * FROM tables WHERE tableID='" + aT.ID() + "';");
			while (resultado.next()) {
				aT.setTurn(resultado.getInt(2));
				aT.setDiners(resultado.getInt(3));
				aT.setState(resultado.getString("state"));
				aT.setReserved_hour(resultado.getString("reserved_hour"));
				aT.setReservationID(resultado.getString("reservationID"));
			}
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	public LinkedList<Table> read() {
		LinkedList<Table> aux = new LinkedList<>();
		try {
			ResultSet resultado = DBBroker.getAgente().read("SELECT * FROM tables" + " ;");
			while (resultado.next()) {
				Table t = new Table(resultado.getInt(1), resultado.getInt(2), resultado.getInt(3),
						resultado.getString("state"), resultado.getDate("reserved_hour"),
						resultado.getString("reservationID"));
				aux.add(t);
			}
		} catch (Exception e) {
			return null;
		}
		return aux;
	}
}