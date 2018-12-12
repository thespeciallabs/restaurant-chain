package org.table.booking.domain;

import java.sql.ResultSet;
import java.util.LinkedList;

import org.table.booking.persistence.DBBroker;

public class TableDAO {
	public LinkedList<Table> _tableList = new LinkedList<Table>();
	public Table _table;

	public int update(Table aT) {
		try {
			return DBBroker.getAgente()
					.update("UPDATE restaurantTables SET state='" + aT.state() + "' WHERE tableID='" + aT.ID() + "';");
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
					.read("SELECT * FROM restaurantTables WHERE tableID='" + aT.ID() + "';");
			while (resultado.next()) {
				aT.set_maxdiners(resultado.getInt("sites"));
				aT.setState(resultado.getString("state"));
				this._tableList.add(aT);
			}
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	public LinkedList<Table> read() {
		LinkedList<Table> aux = new LinkedList<>();
		try {
			ResultSet resultado = DBBroker.getAgente().read("SELECT * FROM restaurantTables" + " ;");
			while (resultado.next()) {
				Table t = new Table(resultado.getString("tableID"), resultado.getInt("sites"),
						resultado.getString("state"));
				aux.add(t);
			}
		} catch (Exception e) {
			return null;
		}
		return aux;
	}

	public LinkedList<Table> readFree(Reservation r) {
		LinkedList<Table> aux = new LinkedList<>();
		try {
			ResultSet resultado = DBBroker.getAgente()
					.read("SELECT * FROM restaurantTables WHERE state= 'free' AND sites>= " + r.get_diners() + " ;");
			while (resultado.next()) {
				Table t = new Table(resultado.getString("tableID"), resultado.getInt("sites"),
						resultado.getString("state"));
				aux.add(t);
			}
		} catch (Exception e) {
			return null;
		}
		return aux;
	}
}