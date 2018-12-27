package org.table.booking.presentation;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import org.table.booking.domain.Reservation;
import org.table.booking.domain.Table;
import org.table.booking.domain.TableManager;
import org.table.booking.exceptions.WrongMenuException;

/*********************************************************************
 *
 * Class Name: IU_TableBooking Author/s name:
 *
 * @author Sergio Herrera Piqueras
 * @author Juan Mena Patón
 * @author Pablo Rodríguez Solera
 * @author Daniel Martínez Santiago. Release/Creation date:
 *         25/12/2018 Class version:
 * @version 1.0 Class description: This class is the
 *          interface for the Table Booking operations.
 *
 **********************************************************************
 */
public class IU_TableBooking {
    private static final int MIN_MENU = 1;
    private static final int MAX_MENU = 5;
    private static final int FIRST_OPT = 1;
    private static final int SECOND_OPT = 2;
    private static final int THIRD_OPT = 3;
    private static final int FOURTH_OPT = 4;
    private static final int FIVETH_OPT = 5;
    private static final int MIN_TURN = 1;
    private static final int MAX_TURN = 3;
    private static final int TURN1_MIN_HOUR = 9;
    private static final int TURN1_MAX_HOUR = 12;
    private static final int TURN2_MIN_HOUR = 12;
    private static final int TURN2_MAX_HOUR = 16;
    private static final int TURN3_MIN_HOUR = 20;
    private static final int TURN3_MAX_HOUR = 23;
    private static final int MIN_MINUTES = 0;
    private static final int MAX_MINUTES = 59;
    private static final int TURN_1 = 1;
    private static final int TURN_2 = 2;
    private static final int TURN_3 = 3;

    /**
     * @param args - The array of Strings that contains the
     *             arguments of our program.
     */
    public static void main(final String[] args) {
        while (menu() == -1) {
            menu();
        }
    }

    /*********************************************************************
     *
     * Method name: menu
     *
     * Name of the original author (if the module author is
     * different than the author of the file): The authors
     * do not change.
     *
     * Description of the Method: The method prints the
     * available menu options, and waits for an input. It
     * sends the input to the start() method. It also check
     * if the chosen option is valid.
     *
     * Calling arguments:
     *
     * None
     *
     * Return value:
     *
     * @return 0 - If the credentials are correct.
     *         -1 - If the credentials are not correct.
     *
     *         Required Files:
     *
     *         None.
     *
     *         List of Checked Exceptions and an indication
     *         of when each exception is thrown.
     *
     * @throws Exception e - If the user chooses an invalid
     *                   option, or enters a non integer
     *                   character. It corresponds with our
     *                   WrongMenuException class.
     *********************************************************************/
    public static int menu() {
        Scanner menu = new Scanner(System.in, "UTF-8");
        byte opt = 0;
        System.out.println("-- CHOOSE AN OPTION --\n");
        System.out.println("-- 1. Assign a table --");
        System.out.println(
                "-- 2. Attend a booking petition --");
        System.out.println("-- 3. Mark table state --");
        System.out.println("-- 4. Show tables state --");
        System.out.println("-- 5. Show turns --");
        try {
            System.out.print("Your option: ");
            opt = menu.nextByte();
            if (opt > MAX_MENU || opt < MIN_MENU) {
                throw new WrongMenuException(
                        "Please, choose a valid option.");
            } else {
                start(opt);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    /*********************************************************************
     *
     * Method name: start
     *
     * Name of the original author (if the module author is
     * different than the author of the file): The authors
     * do not change.
     *
     * Description of the Method: A basic switch that
     * executes the method corresponding to the user
     * operation.
     *
     * Calling arguments:
     *
     * None
     *
     * Return value:
     *
     * @return 0 - If the switch has been executed.
     *
     *         Required Files:
     *
     *         None.
     *
     *         List of Checked Exceptions and an indication
     *         of when each exception is thrown.
     *
     *         This method does not throw any exceptions.
     *********************************************************************/
    public static int start(final byte opt) {

        switch (opt) {
        case FIRST_OPT:
            opt_1();
            break;
        case SECOND_OPT:
            while (opt_2() == -1) {
                menu();
            }
            break;
        case THIRD_OPT:
            opt_3();
            break;
        case FOURTH_OPT:
            opt_4();
            break;
        case FIVETH_OPT:
            opt_5();
            break;
        default:
            break;
        }
        return 0;
    }

    /*********************************************************************
     *
     * Method name: opt_1
     *
     * Name of the original author (if the module author is
     * different than the author of the file): The authors
     * do not change.
     *
     * Description of the Method: The method checks if there
     * is a reservation on a particular table, and if so,
     * marks the table as ready.
     *
     * Calling arguments:
     *
     * None
     *
     * Return value:
     *
     * None.
     *
     * Required Files:
     *
     * None.
     *
     * List of Checked Exceptions and an indication of when
     * each exception is thrown.
     *
     * @thows InputMismatchException e - If the user inputs
     *        something but a number.
     *********************************************************************/
    private static void opt_1() {
        Scanner read = new Scanner(System.in, "UTF-8");
        System.out.print(
                "\n-- Tell me the reservation ID "
                + "of the table: ");
        Table t;
        int resID = 0;
        try {
            resID = read.nextInt();
        } catch (InputMismatchException e) {
            System.out
                    .println("-- Please, insert a number.");
            menu();
        }

        t = TableManager.assing_table(resID);
        if (t == null) {
            System.out.println(
                    "-- There was an error with your"
                    + " reservation or it was cancelled.");
            menu();
        } else {
            System.out.println("-- Your table [" + t.ID()
                    + "] is ready.");
            menu();
        }
    }

    /*********************************************************************
     *
     * Method name: opt_2
     *
     * Name of the original author (if the module author is
     * different than the author of the file): The authors
     * do not change.
     *
     * Description of the Method: The method creates a
     * reservation of a particular table with some
     * properties, like time and number of diners.
     *
     * Calling arguments:
     *
     * None
     *
     * Return value:
     *
     * @return -1 - If there was an error, an the operation
     *         did not execute.
     *         0 - If everything was correct, and the
     *         operation did complete.
     *
     *         Required Files:
     *
     *         None.
     *
     *         List of Checked Exceptions and an indication
     *         of when each exception is thrown.
     *
     * @throws InputMismatchException e - If the user
     *                                introduces the wrong
     *                                input.
     *********************************************************************/
    static int opt_2() {
        Scanner read = new Scanner(System.in, "UTF-8");
        int turn = 0, diners = 0;
        String hour, min = "-1";
        Table t;
        System.out.print(
                "\n-- Tell me the turn ((1), (2) or (3)): ");
        turn = read.nextInt();
        while (turn > MAX_TURN || turn < MIN_TURN) {
            System.out.print(
                    "\n-- Please type a valid "
                    + "turn ((1), (2) or (3)): ");
            turn = read.nextByte();
        }
        System.out.print(
                "\n-- Tell me your desired hour (from 9h to "
                + "12h for breakfast, from 12h to 15h "
                + "for lunch and from 20h to 23h for dinner): ");
        hour = read.next();
        if (turn == TURN_1) {
            while (Integer.parseInt(hour) < TURN1_MIN_HOUR
                    || Integer.parseInt(
                            hour) > TURN1_MAX_HOUR) {
                System.out.print(
                        "\n-- Tell me a valid hour "
                        + "(from 9h to 12h for breakfast,"
                        + " only o'clock hours): ");
                hour = read.next();
            }
            while (Integer.parseInt(min) < MIN_MINUTES
                    || Integer
                            .parseInt(min) > MAX_MINUTES) {
                System.out.print(
                        "\n-- Tell me a valid minute (from 0 to 59): ");
                min = read.next();
            }
        } else if (turn == TURN_2) {
            while (Integer.parseInt(hour) < TURN2_MIN_HOUR
                    || Integer.parseInt(
                            hour) > TURN2_MAX_HOUR) {
                System.out.print(
                        "\n-- Tell me a valid hour "
                        + "(from 12h to 15h for lunch,"
                        + " only o'clock hours): ");
                hour = read.next();

            }
            while (Integer.parseInt(min) < MIN_MINUTES
                    || Integer
                            .parseInt(min) > MAX_MINUTES) {
                System.out.print(
                        "\n-- Tell me a valid minute "
                        + "(from 0 to 59): ");
                min = read.next();
            }
        } else if (turn == TURN_3) {
            while (Integer.parseInt(hour) < TURN3_MIN_HOUR
                    || Integer.parseInt(
                            hour) > TURN3_MAX_HOUR) {
                System.out.print(
                        "\n-- Tell me a valid hour "
                        + "(from 20h to 23h for dinner,"
                        + " only o'clock hours): ");
                hour = read.next();
            }
            while (Integer.parseInt(min) < MIN_MINUTES
                    || Integer
                            .parseInt(min) > MAX_MINUTES) {
                System.out.print(
                        "\n-- Tell me a valid minute"
                        + " (from 0 to 59): ");
                min = read.next();
            }
        }

        System.out.print(
                "\n-- Tell me the number of diners: ");
        try {
            diners = read.nextInt();
        } catch (InputMismatchException e) {
            System.out
                    .println("-- Please, insert a number.");
            return -1;
        }

        t = TableManager.make_reservation(turn,
                hour + ":" + min, diners);
        if (t == null) {
            System.out.println(
                    "\n-- There is no tables "
                    + "available for this turn.");
            return -1;
        } else {
            System.out.println(
                    "\n-- OK. You reserved a "
                    + "table for this turn.");
            return 0;
        }

    }

    /*********************************************************************
     *
     * Method name: opt_3
     *
     * Name of the original author (if the module author is
     * different than the author of the file): The authors
     * do not change.
     *
     * Description of the Method: The method shows the state
     * of a particular table and allows a waiter to change
     * it.
     *
     * Calling arguments:
     *
     * None
     *
     * Return value:
     *
     * None.
     *
     * Required Files:
     *
     * None.
     *
     * List of Checked Exceptions and an indication of when
     * each exception is thrown.
     *
     * This method does not throw any exceptions.
     *********************************************************************/
    private static void opt_3() {
        Scanner read = new Scanner(System.in, "UTF-8");
        System.out.print(
                "\n-- Showing the state of the tables... ");
        LinkedList<Table> aux = TableManager
                .show_table_state();
        if (aux != null) {
            for (int i = 0; i < aux.size(); i++) {
                System.out.println(aux.get(i).toString());
            }
            System.out.print(
                    "\n-- Select the ID of "
                    + "the table to change the state: ");

            String id = read.next();
            Table t = new Table(id);
            t.get_tableDAO().read(t);
            System.out.print(
                    "\n-- Tell me the state to mark: ");
            t.setState(read.next());
            if (TableManager.mark_table_state(t) == -1) {
                System.out.println(
                        "\n-- There was a problem changing the state.");
            } else {
                System.out.println("\n-- State changed!");
            }

        } else {
            System.out.println(
                    "\n-- There is no tables in the list.");
            menu();
        }
    }

    /*********************************************************************
     *
     * Method name: opt_4
     *
     * Name of the original author (if the module author is
     * different than the author of the file): The authors
     * do not change.
     *
     * Description of the Method: The method shows the list
     * of tables.
     *
     * Calling arguments:
     *
     * None
     *
     * Return value:
     *
     * None.
     *
     * Required Files:
     *
     * None.
     *
     * List of Checked Exceptions and an indication of when
     * each exception is thrown.
     *
     * This method does not throw any exceptions.
     *********************************************************************/
    private static void opt_4() {
        System.out.print(
                "\n-- Showing the state of the tables... ");
        LinkedList<Table> aux = TableManager
                .show_table_state();
        if (aux != null) {
            for (int i = 0; i < aux.size(); i++) {
                System.out.println(aux.get(i).toString());
            }
        } else {
            System.out.println(
                    "\n-- There is no tables in the list.");
            menu();
        }

    }

    /*********************************************************************
     *
     * Method name: opt_5
     *
     * Name of the original author (if the module author is
     * different than the author of the file): The authors
     * do not change.
     *
     * Description of the Method: The method shows the turns
     * of the tables.
     *
     * Calling arguments:
     *
     * None
     *
     * Return value:
     *
     * None.
     *
     * Required Files:
     *
     * None.
     *
     * List of Checked Exceptions and an indication of when
     * each exception is thrown.
     *
     * This method does not throw any exceptions.
     *********************************************************************/
    private static void opt_5() {
        System.out.print(
                "\n-- Showing the turns of the tables... ");
        LinkedList<Table> aux = TableManager
                .show_table_state();
        if (aux != null) {
            for (int i = 0; i < aux.size(); i++) {
                System.out.println(aux.get(i).toString());
                for (Table j : aux) {
                    for (Reservation k : TableManager
                            .show_reservations(j.ID())) {
                        System.out.println(k.toString());
                    }
                }
            }
        } else {
            System.out.println(
                    "\n-- There is no tables in the list.");
            menu();
        }

    }

}
