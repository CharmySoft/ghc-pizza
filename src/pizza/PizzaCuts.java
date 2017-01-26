package pizza;

import java.util.ArrayList;

public class PizzaCuts {
	private ArrayList<Square> cuts;
	
	public PizzaCuts() {
		this.cuts = new ArrayList<Square>();
	}
	
	public boolean cuts(Square c, Pizza p) {
		// Check if the cut is outside the pizza
		if(c.p2.x > p.getColumn() || c.p2.y > p.getRow()) {
			// System.out.print(", due to outside the pizza, ");
			return false;
		}
		
		// Check if the cut has the minimum ingredients
		if (!p.hasEnoughIngredients(c)) {
			// System.out.print(", due to not enough ingredients, ");
			return false;
		}
		
		// Check if the cut has overlap
		for (Square cut: this.cuts) {
			if (cut.overlap(c)) {
				// System.out.print(", due to overlap, ");
				return false;
			}
		}
		this.cuts.add(c);
		return true;
	}
	
	public int getScore(){
		// The score equals to the total number of cells in all slices.
		int score = 0;
		for(Square cut : this.cuts) {
			score += cut.getWidth() * cut.getHeight();
		}
		return score;
	}
	
	public void print(){
		System.out.println(this.cuts.size() + " slices.");
		for(Square cut : this.cuts) {
			System.out.println("(" + cut.p1.x + ", " + cut.p1.y + ") "
					+ "(" + cut.p2.x + ", " + cut.p2.y + ")");
		}
		System.out.println("Score: " + this.getScore());
	}
	

}
