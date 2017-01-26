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
		this.content = new char[column][row];
	}
	
	public int getRow() {
		return this.r;
	}
	
	public int getColumn() {
		return this.c;
	}
	
	public int getL() {
		return this.l;
	}
	
	public int getH() {
		return this.h;
	}
	
	public char getCell(int x, int y) {
		return this.content[x][y];
	}
	
	public char getCell(Point p) {
		return this.content[p.x][p.y];
	}
	
	public void setCell(int x, int y, char content) {
		this.content[x][y] = content;
	}
	
	public void setCell(Point p, char content) {
		this.content[p.x][p.y] = content;
	}
	
	public int countM(Square slice) {
		int count = 0;
		for (int i = slice.p1.x; i < slice.getWidth(); i++) {
			for (int j = slice.p1.y; j < slice.getHeight(); j++) {
				if (this.getCell(i, j) == 'M')
					count++;
			}
		}
		return count;
	}
	
	public int countT(Square slice) {
		int count = 0;
		for (int i = slice.p1.x; i < slice.getWidth(); i++) {
			for (int j = slice.p1.y; j < slice.getHeight(); j++) {
				if (this.getCell(i, j) == 'T')
					count++;
			}
		}
		return count;
	}
	
	public void print() {
		for (int i = 0; i < this.r; i++) {
			for (int j = 0; j < this.c; j++) {
				System.out.print(this.getCell(i, j));
			}
			System.out.print("\n");
		}
	}
	
	public void cut() {
		ArrayList<int[]> divisors = Algo.getDivisors(h);
		PizzaCuts pc = new PizzaCuts();
		for (int i = 0; i < this.r; i++) {
			for (int j = 0; j < this.c; j++) {
				for(int[] d :divisors) {
					boolean r = pc.cuts(new Square(new Point(i, j), new Point(i + d[0], j + d[1])),
							this);
					System.out.println("Trying to cut a " + d[0] + " * " + d[1] + 
							" slice on (" + i + ", " + j + ") " + (r? "Success": "Failed"));
				}
			}
		}
		pc.print();
	}

}
