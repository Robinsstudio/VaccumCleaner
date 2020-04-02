package fr.robinsstudio.vacuumcleaner;

import java.util.Map;

public enum Command implements Labelled {
	RIGHT("D"), LEFT("G"), FORWARD("A");

	public static final Map<String, Command> COMMANDS_BY_LABEL = LabelledUtils.toMap(values());

	public static Command getCommand(String label) {
		return COMMANDS_BY_LABEL.get(label);
	}

	private String label;

	private Command(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
