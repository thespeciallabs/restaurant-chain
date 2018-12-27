package org.table.booking.exceptions;

/*********************************************************************
 *
 * Class Name: WrongMenuException Author/s name:
 *
 * @author Sergio Herrera Piqueras
 * @author Juan Mena Patón
 * @author Pablo Rodríguez Solera
 * @author Daniel Martínez Santiago. Release/Creation date:
 *         25/12/2018 Class version:
 * @version 1.0 Class description: This class implements an
 *          exception for an error with the Menu.
 *
 **********************************************************************
 */
public class WrongMenuException extends Exception {
    /*********************************************************************
     *
     * Method name: WrongMenuException
     *
     * Name of the original author (if the module author is
     * different than the author of the file): The authors
     * do not change.
     *
     * Simple definition of an exception.
     *
     * Calling arguments:
     *
     * @param message - The message that contains our
     *                exception.
     *
     *                Return value:
     *
     *                It's a void method, so it doesn't
     *                return anything.
     *
     *                Required Files:
     *
     *                None.
     *
     *                List of Checked Exceptions and an
     *                indication of when each exception is
     *                thrown.
     *
     *                This method does not throw any
     *                exceptions.
     *********************************************************************/
    public WrongMenuException(final String message) {
        super(message);
    }
}
