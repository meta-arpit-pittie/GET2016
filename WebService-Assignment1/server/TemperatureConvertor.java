/**
 * Assignment 1
 * To implement SOAP Web Service
 * Web Service Server Side
 * @author Arpit Pittie
 */
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class TemperatureConvertor {

	/**
	 * To convert temperature from fahrenheit to celsius
	 * @param fahrenheit - temperature in fahrenheit
	 * @return Temperature in celsius
	 */
	@WebMethod
	public double fahrenheitToCelsius(double fahrenheit) {
		return (((fahrenheit-32)*5)/9);
	}
}
