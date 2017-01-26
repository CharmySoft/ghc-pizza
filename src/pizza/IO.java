package pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class IO {
	public boolean read(String filename) throws FileNotFoundException
	{
		Scanner in = new Scanner(new File(filename)); 
		Pizza pizza;
		try{
			String[] headInfo = in.nextLine().split(" ");
			int[] head = Arrays.stream(headInfo).mapToInt(Integer::parseInt).toArray();
			pizza = new Pizza(head[0], head[1], head[2], head[3]);
			for (int i = 0; i < pizza.getRow(); i++) {
				String line = in.nextLine();
				for (int j = 0; j < pizza.getColumn(); j++) {
					pizza.setCell(j, i, line.charAt(j));
				}
			}
		} catch (Exception e){
			System.out.println("Invalid Input file.");
			return false;
		} finally {
			in.close();
		}

		pizza.print();
		pizza.cut();
		return true;
	}
}
