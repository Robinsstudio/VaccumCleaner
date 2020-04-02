package fr.robinsstudio.vacuumcleaner;

public class VacuumCleaner {
	private Point position;
	private Orientation orientation;

	public VacuumCleaner(Point position, Orientation orientation) {
		this.position = position;
		this.orientation = orientation;
	}

	public void move(Command command) {
		if (Command.FORWARD.equals(command)) {
			position = position.move(orientation);
		} else {
			orientation = orientation.move(command);
		}
	}

	public void printLocation() {
		System.out.println(String.format("x=%d y=%d orientation=%s", position.getX(), position.getY(), orientation.getLabel()));
	}

	public int getX() {
		return position.getX();
	}

	public int getY() {
		return position.getY();
	}
}
