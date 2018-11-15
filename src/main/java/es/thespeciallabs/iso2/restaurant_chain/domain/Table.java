package es.thespeciallabs.iso2.restaurant_chain.domain;

public class Table {
	private int _turn;
	private int _diners;
	private String _state;
	private String _reserved_hour;
	public TableDAO _tableDAO;

	public int turn() {
		return this._turn;
	}

	public int diners() {
		return this._diners;
	}

	public String state() {
		return this._state;
	}

	public String reserved_hour() {
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
}