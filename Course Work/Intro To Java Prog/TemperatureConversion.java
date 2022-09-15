import java.util.Scanner;

public class TemperatureConversion {

	public static void main(String[] args) {
		
		Scanner input = new Scanner( System.in); //Used to read input form the user.
		int tempCelsius; // Temperature in degrees Celsius to be converted to Fahrenheit.
		int tempFahrenheit; //Temperature in Fahrenheit.
		
		System.out.println("Please enter the temperature in degrees Celsius then it will be converted to Fahrenheit. ");
		tempCelsius = input.nextInt(); //Get the degrees Celsius from the user.
		tempFahrenheit = convertTemp(tempCelsius); //Convert the temperature to Fahrenheit.
		System.out.println(tempCelsius + " Degrees Celsius is equal to " + tempFahrenheit + " degrees Fahrenheit.");
		

	}
	
	/**
	 * Converts a temperature measured in degrees Celsius to
	 * Fahrenheit then returns the answer.
	 * @param n The temperature in degrees Celsius to be converted.
	 * @return The converted temperature in degrees Fahrenheit.
	 */
	public static int convertTemp(int n) {
		
		int convertedTemp; // The variable to hold the converted temperature.
		
		convertedTemp = n * 9 / 5 + 32; //Conversion to Fahrenheit.
		return convertedTemp;
	}

}
