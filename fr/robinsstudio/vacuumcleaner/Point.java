package fr.robinsstudio.vacuumcleaner;

public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Point add(Point point) {
		return new Point(x + point.getX(), y + point.getY());
	}

	public Point move(Orientation orientation) {
		return add(orientation.getDirection());
	}
}
