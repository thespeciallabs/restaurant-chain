package org.table.booking;

import org.table.booking.presentation.IU_Login;
import org.table.booking.presentation.IU_TableBooking;

/*********************************************************************
*
* Class Name: App
* Author/s name: 
* 				 @author Sergio Herrera Piqueras
* 				 @author Juan Mena Patón
* 				 @author Pablo Rodríguez Solera 
* 				 @author Daniel Martínez Santiago.
* Release/Creation date: 25/12/2018
* Class version: 
* 				 @version 1.0
* Class description: This is the main class, that starts the our application.
*
**********************************************************************
*/
class App {
	/*********************************************************************
	*
	* Method name: main
	*
	* Name of the original author (if the module author is different
	* than the author of the file): The authors do not change.
	*
	* Description of the Method: The method starts our application, by starting the two interfaces.
	*
	* Calling arguments:
	* 
	* @param args	The array of Strings that contains the arguments of our application.
	*
	* Return value:
	*
	* It's a void method, so it doesn't return anything.
	*
	* Required Files: 
	* 
	* credentials.properties : The file that contains the credentials for our users.
	*
	* List of Checked Exceptions and an indication of when each exception
	* is thrown.
	*
	* This method does not throw any exceptions.
	*********************************************************************/
	public static void main(final String[]args) {
		System.out.println(
				"-----\tRestaurant Chain Manager.\t(v1.0)\t-----\n");
		System.out.println("-----\tTABLE BOOKING\t-----");
		IU_Login.main(args);
		IU_TableBooking.main(args);
	}
}
