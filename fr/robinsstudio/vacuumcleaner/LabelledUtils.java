package fr.robinsstudio.vacuumcleaner;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LabelledUtils {
	public static <T extends Labelled> Map<String, T> toMap(T[] objects) {
		return Arrays.asList(objects).stream().collect(Collectors.toMap(Labelled::getLabel, o -> o));
	}
}
