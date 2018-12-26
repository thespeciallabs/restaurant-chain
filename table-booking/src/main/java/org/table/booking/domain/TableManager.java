package org.table.booking.domain;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/*********************************************************************
*
* Class Name: TableManager
* Author/s name: 
* 				 @author Sergio Herrera Piqueras
* 				 @author Juan Mena Patón
* 				 @author Pablo Rodríguez Solera 
* 				 @author Daniel Martínez Santiago.
* Release/Creation date: 25/12/2018
* Class version: 
* 				 @version 1.0
* Class description: This class implements all the operations that involve both our Table object and our Reservation object.
*
**********************************************************************
*/
public class TableManager {
	private static final int THREE = 3;
	private static final int FIVE = 5;
	private static final int TEN = 10;
	private static final int TWENTY = 20;

	/*********************************************************************
	*
	* Method name: make_reservation
	*
	* Name of the original author (if the module author is different
	* than the author of the file): The authors do not change.
	*
	* Description of the Method: The method, from the list of free tables, marks one as reserved
	* 							 if a reservation already exists.
	*
	* Calling arguments:
	* @param turn - The specific turn for the reservation.
    * @param hour - The specific time for the reservation.
    * @param diners - The number of diners.
	*
	* Return value:
	*
	* @return free - If the operation was correct, it returns the free tables.
	* @return null  - If the read operation failed and did not complete.
	*
	* Required Files: 
	* 
	* None.
	*
	* List of Checked Exceptions and an indication of when each exception
	* is thrown.
	*
	* @throws NoSuchElementException e - If there specific reservation didn't complete.
	*********************************************************************/
	public static Table make_reservation(final int turn,
			final String hour, final int diners) {
		Reservation r = new Reservation();
		r.set_reservation_hour(hour);
		r.set_diners(diners);
		r.set_turn(turn);
		LinkedList<Table> freetables = show_free_table_state(
				r);
		Table free;
		try {
			free = freetables.removeFirst();
		} catch (NoSuchElementException e) {
			return null;
		}
		free.setState("reserved");

		mark_table_state(free);
		r.set_tableID(free.ID());
		createReservation(r);
		return free;
	}

	/**
	 * @param r - The Reservation object that we need to create.
	 */
	private static void createReservation(
			final Reservation r) {
		r.get_reservationDAO().insert(r);
	}

	/**
	 *  @throws UnsupportedOperationException - This operation is not supported.
	 */
	public final void cancel_reservation() {
		throw new UnsupportedOperationException();
	}

	/*********************************************************************
	*
	* Method name: assing_table
	*
	* Name of the original author (if the module author is different
	* than the author of the file): The authors do not change.
	*
	* Description of the Method: The method assigns a specific already existing reservation to a table.
	*
	* Calling arguments:
	* 
	* @param resID - The Id of the reservation that we want to assign a table to.
	*
	* Return value:
	*
	* @return t - If the operation was correct.
	* @return null  - If the read operation failed and did not complete.
	*
	* Required Files: 
	* 
	* None.
	*
	* List of Checked Exceptions and an indication of when each exception
	* is thrown.
	*
	* @throws NullPointerException - If there is any kind of failure assigning the table.
	*********************************************************************/
	public static Table assing_table(final int resID) {
		Table t = new Table();
		Reservation r = new Reservation();
		r.set_reservationID(resID);
		if (r.get_reservationDAO().read(r) == -1) {
			return null;
		} else {
			t.setID(r.get_tableID());
			t.get_tableDAO().read(t);
			Calendar calendar = new GregorianCalendar();

			int s_hour = calendar.get(Calendar.HOUR_OF_DAY);
			int s_min = calendar.get(Calendar.MINUTE);
			String s_time = "";
			if (s_min < TEN) {
				s_time = "" + s_hour + "0" + s_min;
			} else {
				s_time = "" + s_hour + s_min;
			}
			if (s_hour < TEN) {
				s_time = "0" + s_time;
			}
			String r_time = "";

			try {
				r_time = r.get_reservation_hour()
						.substring(0, 2)
						+ r.get_reservation_hour()
								.substring(THREE, FIVE);
			} catch (NullPointerException e) {
				return null;
			}
			if (Integer.parseInt(r_time) >= Integer
					.parseInt(s_time)
					|| Integer.parseInt(s_time) - Integer
							.parseInt(r_time) < TWENTY) {
				t.setState("busy");
				mark_table_state(t);
				r.get_reservationDAO().delete(r);
			} else {
				t.setState("free");
				r.get_reservationDAO().delete(r);
				mark_table_state(t);
				return null;
			}
		}

		return t;
	}

	/**
	 * @return - The list of the state of the tables.
	 */
	public static LinkedList<Table> show_turns() {
		return show_table_state();
	}

	/**
	 * @param t - The specific Table object.
	 * @return - The updated Table state.
	 */
	public static int mark_table_state(final Table t) {
		return t.get_tableDAO().update(t);
	}

	/*********************************************************************
	*
	* Method name: readFree
	*
	* Name of the original author (if the module author is different
	* than the author of the file): The authors do not change.
	*
	* Description of the Method: The method shows all the existing reservations.
	*
	* Calling arguments:
	* 
	* @param tableID - The ID of the table that we want to retrieve the reservations.
	* 
	* Return value:
	*
	* @return aux - If the operation was correct.
	* @return null  - If the read operation failed and did not complete.
	*
	* Required Files: 
	* 
	* None.
	*
	* List of Checked Exceptions and an indication of when each exception
	* is thrown.
	*
	* This method does not throw any exceptions.
	*********************************************************************/
	public static LinkedList<Reservation> show_reservations(
			final String tableID) {
		Reservation r = new Reservation();
		LinkedList<Reservation> aux;
		r.get_reservationDAO().readTable(tableID);
		aux = r.get_reservationDAO().get_reservationList();
		if (aux != null) {
			return aux;
		} else {
			return null;
		}
	}

	/**
	 * @return
	 */
	/*********************************************************************
	*
	* Method name: show_table_state
	*
	* Name of the original author (if the module author is different
	* than the author of the file): The authors do not change.
	*
	* Description of the Method: The method returns the Tables current state.
	*
	* Calling arguments:
	* 
	* None.
	*
	* Return value:
	*
	* @return aux - If the operation was correct.
	* @return null  - If the read operation failed and did not complete.
	*
	* Required Files: 
	* 
	* None.
	*
	* List of Checked Exceptions and an indication of when each exception
	* is thrown.
	*
	* This method does not throw any exceptions.
	*********************************************************************/
	public static LinkedList<Table> show_table_state() {
		Table t = new Table();
		LinkedList<Table> aux;
		aux = t.get_tableDAO().read();
		if (aux != null) {
			return aux;
		} else {
			return null;
		}
	}

	/*********************************************************************
	*
	* Method name: show_free_table_state
	*
	* Name of the original author (if the module author is different
	* than the author of the file): The authors do not change.
	*
	* Description of the Method: The method returns the free Tables current state.
	*
	* Calling arguments:
	* 
	* @param r - The specific reservation that we want to know about.
	*
	* Return value:
	*
	* @return aux - If the operation was correct.
	* @return null  - If the read operation failed and did not complete.
	*
	* Required Files: 
	* 
	* None.
	*
	* List of Checked Exceptions and an indication of when each exception
	* is thrown.
	*
	* This method does not throw any exceptions.
	*********************************************************************/
	public static LinkedList<Table> show_free_table_state(
			final Reservation r) {
		Table t = new Table();
		LinkedList<Table> aux;
		aux = t.get_tableDAO().readFree(r);
		if (aux != null) {
			return aux;
		} else {
			return null;
		}
	}
}
