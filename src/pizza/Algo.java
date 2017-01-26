package pizza;

import java.util.ArrayList;

public class Algo {
	public static ArrayList<int[]> getDivisors(int num) 
	{
		ArrayList<int[]> divisors = new ArrayList<int[]>();
		for(int i = 1; i <= num; i++) {
			if(num % i == 0){
				int[] d = {i, num / i};
				divisors.add(d);
			}
		}
		return divisors;
	}
}
