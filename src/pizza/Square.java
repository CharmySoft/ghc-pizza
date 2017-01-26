package pizza;

public class Square {
	// The square if represented using the upper left point and lower right point.
	public final Point p1; // Upper left
	public final Point p2; // Lower right
	
	public Square(Point p1, Point p2) {
		if(p1.compare(p2) != -1) {
			// p1 must be the upper left and p2 must be lower right
			throw new IllegalArgumentException();
		}
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public int getWidth() {
		return p2.x - p1.x;
	}
	
	public int getHeight() {
		return p2.y - p1.x;
	}

	public boolean overlap(Square c) {
		// If one rectangle is on left side of other
		if (this.p2.x > c.p1.x || c.p2.x > this.p1.x)
		    return false;

		// If one rectangle is above other
		if (this.p2.y < c.p1.y || c.p2.y < this.p1.y)
		    return false;

		return true;
	}
	

}
