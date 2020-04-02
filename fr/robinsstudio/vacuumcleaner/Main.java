package fr.robinsstudio.vacuumcleaner;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int readInt(String text, Scanner scanner) {
		int integer = -1;

		while (integer == -1) {
			try {
				System.out.print(text);
				integer = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid integer. Please try again.");
				integer = -1;
			}
		}

		return integer;
	}

	public static Orientation readOrientation(Scanner scanner) {
		Orientation orientation = null;

		while (orientation == null) {
			System.out.print("orientation : ");
			orientation = Orientation.getOrientation(scanner.nextLine());

			if (orientation == null) {
				System.out.println("Invalid orientation. Please try again.");
			}
		}

		return orientation;
	}

	public static String[] readInstructions(Scanner scanner) {
		String[] instructions = null;

		while (instructions == null) {
			System.out.print("instructions : ");
			instructions = scanner.nextLine().split("");
			if (Arrays.asList(instructions).stream().anyMatch(instruction -> Command.getCommand(instruction) == null)) {
				System.out.println("Invalid instructions. Please try again.");
				instructions = null;
			}
		}

		return instructions;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Dimension de la grille");

		final int GRID_X = readInt("x : ", scanner);

		final int GRID_Y = readInt("y : ", scanner);

		System.out.println("Position initiale de l'aspirateur");

		final int vacuumCleanerX = readInt("x : ", scanner);

		final int vacuumCleanerY = readInt("y : ", scanner);

		Orientation vacuumCleanerOrientation = readOrientation(scanner);

		VacuumCleaner vacuumCleaner = new VacuumCleaner(new Point(vacuumCleanerX, vacuumCleanerY), vacuumCleanerOrientation);

		for (String instruction : readInstructions(scanner)) {
			Command command = Command.getCommand(instruction);
			vacuumCleaner.move(command);

			if (
				vacuumCleaner.getX() < 0 || vacuumCleaner.getX() >= GRID_X ||
				vacuumCleaner.getY() < 0 || vacuumCleaner.getY() >= GRID_Y
			) {
				System.out.println("Warning: The vacuum cleaner has reached the boundaries of the grid.");
			}
		}

		vacuumCleaner.printLocation();

		scanner.close();
	}
}
