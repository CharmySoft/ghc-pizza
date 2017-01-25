package pizza;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) 
	{		
		System.out.println("Enter the input file name: ");
		Scanner scanner = new Scanner(System.in);
		String filename = scanner.nextLine();
		IO io = new IO();
		try {
			io.read(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace(); 
		}
		scanner.close();
	}
}
