package pizza;

public class Square {
	// The square if represented using the upper left point and lower right point.
	public Point p1; // Upper left
	public Point p2; // Lower right
	
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

}
