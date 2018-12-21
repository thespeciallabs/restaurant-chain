package org.table.booking.domain;

import java.sql.ResultSet;
import java.util.LinkedList;

import org.table.booking.persistence.DBBroker;

public class TableDAO {
	private LinkedList<Table> _tableList = new LinkedList<Table>();
	private Table _table;

	public final LinkedList<Table> get_tableList() {
		return _tableList;
	}

	public final void set_tableList(
			final LinkedList<Table> _tableList) {
		this._tableList = _tableList;
	}

	public final Table get_table() {
		return _table;
	}

	public final void set_table(final Table _table) {
		this._table = _table;
	}

	public final int update(final Table aT) {
		final String sql = String.format(
				"UPDATE restaurantTables SET state='%s' WHERE tableID='%s';",
				aT.state(), aT.ID());
		try {
			return DBBroker.getAgente().update(sql);
		} catch (Exception e) {
			return -1;
		}
	}

	public final int delete(final Table aT) {
		throw new UnsupportedOperationException();
	}

	public final int insert(final Table aT) {
		throw new UnsupportedOperationException();
	}

	public final int read(final Table aT) {
		final String sql = String.format(
				"SELECT * FROM restaurantTables WHERE tableID='%s';",
				aT.ID());
		try {
			ResultSet resultado = DBBroker.getAgente()
					.read(sql);
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

	public final LinkedList<Table> read() {
		LinkedList<Table> aux = new LinkedList<>();
		final String sql = String
				.format("SELECT * FROM restaurantTables ;");
		try {
			ResultSet resultado = DBBroker.getAgente()
					.read(sql);
			while (resultado.next()) {
				Table t = new Table(
						resultado.getString("tableID"),
						resultado.getInt("sites"),
						resultado.getString("state"));
				aux.add(t);
			}
		} catch (Exception e) {
			return null;
		}
		return aux;
	}

	public final LinkedList<Table> readFree(
			final Reservation r) {
		LinkedList<Table> aux = new LinkedList<>();
		final String sql = String.format(
				"SELECT * FROM restaurantTables WHERE state= 'free' AND sites>= %d ;",
				r.get_diners());
		try {
			ResultSet resultado = DBBroker.getAgente()
					.read(sql);
			while (resultado.next()) {
				Table t = new Table(
						resultado.getString("tableID"),
						resultado.getInt("sites"),
						resultado.getString("state"));
				aux.add(t);
			}
		} catch (Exception e) {
			return null;
		}
		return aux;
	}
}
