package pizza;

import java.util.ArrayList;

public class PizzaCuts {
	private ArrayList<Square> cuts;
	
	public PizzaCuts() {
		this.cuts = new ArrayList<Square>();
	}
	
	public void addCut(Square cut) {
		this.cuts.add(cut);
	}
	
	public int getScore(){
		// The score equals to the total number of cells in all slices.
		int score = 0;
		for(Square cut : cuts) {
			score += cut.getWidth() * cut.getHeight();
		}
		return score;
	}
	

}
