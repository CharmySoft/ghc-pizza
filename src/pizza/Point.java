package pizza;

public class Point {
	public int x;
	public int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int compare(Point p) {
		if(this.x < p.x && this.y < p.y) {
			return -1;
		}

		if(this.x > p.x && this.y > p.y) {
			return 1;
		}
		
		return 0;
	}
}
