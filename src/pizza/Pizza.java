package pizza;

import java.util.ArrayList;

public class Pizza {
	private int r;
	private int c;
	private int l;
	private int h;
	private char[][] content;
	
	public Pizza(int row, int column, int minIngredient, int maxCells) {
		this.r = row;
		this.c = column;
		this.l = minIngredient;
		this.h = maxCells;
		this.content = new char[r][c];
	}
	
	public int getRow() {
		return this.r;
	}
	
	public int getColumn() {
		return this.c;
	}
	
	public char getCell(int row, int column) {
		return this.content[row][column];
	}
	
	public void setCell(int row, int column, char content) {
		this.content[row][column] = content;
	}
	
	public void printContent() {
		for (int i = 0; i < this.r; i++) {
			for (int j = 0; j < this.c; j++) {
				System.out.print(this.getCell(i, j));
			}
			System.out.print("\n");
		}
	}
	
	public void cut() {
		ArrayList<int[]> divisors = Algo.getDivisors(h);
		for(int[] d :divisors) {
			System.out.println(d[0] + " * " + d[1]);
		}
	}

}
