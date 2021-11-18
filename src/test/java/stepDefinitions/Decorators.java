package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Decorators {
	
	public static void prerequisiteStart() throws FileNotFoundException {
		@SuppressWarnings("resource")
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt", true));
		log.println("          ********Prerequisite Start*******          ");
	}
	
	public static void prerequisiteEnd() throws FileNotFoundException {
		@SuppressWarnings("resource")
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt", true));
		log.println("          *********Prerequisite End********          ");
		log.println();
	}

}
