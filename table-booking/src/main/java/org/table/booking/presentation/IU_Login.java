package org.table.booking.presentation;

import java.util.Scanner;

import org.table.booking.domain.Login;

/*********************************************************************
 *
 * Class Name: IU_Login Author/s name:
 *
 * @author Sergio Herrera Piqueras
 * @author Juan Mena Patón
 * @author Pablo Rodríguez Solera
 * @author Daniel Martínez Santiago. Release/Creation date:
 *         25/12/2018 Class version:
 * @version 1.0 Class description: This class is the
 *          interface for the Login operations.
 *
 **********************************************************************
 */
public class IU_Login {
    /**
     * @param args - The array of Strings that contains the
     *             arguments of our program.
     */
    public static void main(final String[] args) {
        while (start() == -1) {
            start();
        }
    }

    /*********************************************************************
     *
     * Method name: start
     *
     * Name of the original author (if the module author is
     * different than the author of the file): The authors
     * do not change.
     *
     * Description of the Method: The method checks if the
     * credentials are correct, and makes the login. It also
     * reports the result both to the user and to the
     * system.
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
     *         This method does not throw any exceptions.
     *********************************************************************/
    public static int start() {
        Scanner read = new Scanner(System.in, "UTF-8");
        String name, pass;
        Login login;

        System.out.println("\n-- LOGIN --");
        System.out.print("-- Write your Name/ID: ");
        name = read.next();
        System.out.print("-- Now your pass: ");
        pass = read.next();
        System.out.println(
                "\n-- \tChecking credentials...\t --");
        login = new Login(name, pass);
        if (login.check_credentials()) {
            System.out.println("\n-- Welcome "
                    + login.user() + "! --");
            return 0;
        } else {
            System.out.println(
                    "\n-- ERROR: Incorrect "
                    + "credentials, try again. --");
            return -1;
        }
    }
}
