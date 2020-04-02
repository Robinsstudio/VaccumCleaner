package fr.robinsstudio.vacuumcleaner;

import java.util.Map;

public enum Orientation implements Labelled {
	NORTH("N", new Point(0, 1)),
	EAST("E", new Point(1, 0)),
	SOUTH("S", new Point(0, -1)),
	WEST("W", new Point(-1, 0));

	public static final Orientation[] ORIENTATIONS = values();
	public static final Map<String, Orientation> ORIENTATIONS_BY_LABEL = LabelledUtils.toMap(values());

	public static Orientation getOrientation(String label) {
		return ORIENTATIONS_BY_LABEL.get(label);
	}

	private String label;
	private Point direction;

	private Orientation(String label, Point direction) {
		this.label = label;
		this.direction = direction;
	}

	@Override
	public String getLabel() {
		return label;
	}

	public Point getDirection() {
		return direction;
	}

	public Orientation move(Command command) {
		if (Command.LEFT.equals(command)) {
			return ORIENTATIONS[(ORIENTATIONS.length + ordinal() - 1) % ORIENTATIONS.length];
		}

		if (Command.RIGHT.equals(command)) {
			return ORIENTATIONS[(ordinal() + 1) % ORIENTATIONS.length];
		}

		throw new IllegalArgumentException("The command argument must be left or right.");
	}
}
