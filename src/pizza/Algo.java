package pizza;

import java.util.ArrayList;

public class Algo {
	public static ArrayList<int[]> getDivisors(int num) 
	{
		ArrayList<int[]> divisors = new ArrayList<int[]>();
		int upperBound = num;
		for(int i = 1; i < upperBound - 1; i++) {
			if(num % i == 0){
				upperBound = num / i;
				int[] d = {i, upperBound};
				divisors.add(d);
			}
		}
		return divisors;
	}
}
