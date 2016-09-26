/**
 * Assignment 1
 * To implement SOAP Web Service
 * Web Service Client Side
 * @author Arpit Pittie
 */
package DefaultNamespace;

import java.util.Scanner;

public class InputTemperature {

	public static void main(String[] args) {
		//Getting object f service locator
		TemperatureConvertorServiceLocator temperatureConvertorServiceLocator = 
				new TemperatureConvertorServiceLocator();
		
		temperatureConvertorServiceLocator.setTemperatureConvertorEndpointAddress(
				"http://localhost:8080/WebServiceAssignment1/services/TemperatureConvertor");
		
		Scanner scan = new Scanner(System.in);
		double fahrenheit;
		try {
			//Getting input of temperature
			System.out.println("Enter temperature in Fahrenheit : ");
			fahrenheit = scan.nextDouble();
			
			//Getting the server side class object
			TemperatureConvertor convertor = temperatureConvertorServiceLocator.getTemperatureConvertor();
			
			//Coonverting the temperature to celsius and displaying it
			System.out.println("Temperature in Celsius is : "+convertor.fahrenheitToCelsius(fahrenheit));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}

}
