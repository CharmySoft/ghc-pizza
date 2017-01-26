package pizza;

import java.util.ArrayList;

public class Pizza {
	private int r; // Row
	private int c; // Column
	private int l; // Minimum number of ingredients each slice must have
	private int h; // Maximum size allowed of each slice
	private char[][] content; // It's [column][row] or [x][y]
	
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
		for (int i = slice.p1.x; i < slice.p2.x; i++) {
			for (int j = slice.p1.y; j < slice.p2.y; j++) {
				if (this.getCell(i, j) == 'M')
					count++;
			}
		}
		return count;
	}
	
	public int countT(Square slice) {
		int count = 0;
		for (int i = slice.p1.x; i < slice.p2.x; i++) {
			for (int j = slice.p1.y; j < slice.p2.y; j++) {
				if (this.getCell(i, j) == 'T')
					count++;
			}
		}
		return count;
	}
	
	public boolean hasEnoughIngredients(Square slice) {
		int countM = 0;
		int countT = 0;
		for (int i = slice.p1.x; i < slice.p2.x; i++) {
			for (int j = slice.p1.y; j < slice.p2.y; j++) {
				if (this.getCell(i, j) == 'M') {
					countM++;
				} else {
					countT++;
				}
				if (countM >= this.l && countT >= this.l) return true;
			}
		}
		return false;
	}
	
	public void print() {
		for (int i = 0; i < this.r; i++) {
			for (int j = 0; j < this.c; j++) {
				System.out.print(this.getCell(j, i));
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
					// System.out.print("Trying to cut a " + d[0] + " * " + d[1] + " slice on (" + j + ", " + i + ") ");
					boolean r = pc.cuts(new Square(new Point(j, i), new Point(j + d[0], i + d[1])),
							this);
					// System.out.println(r? "Success": "Failed");
				}
			}
		}
		pc.print();
	}

}
