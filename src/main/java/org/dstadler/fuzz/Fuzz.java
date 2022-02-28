package org.dstadler.fuzz;

import java.nio.charset.StandardCharsets;

/**
 * This class provides a simple target for fuzzing which
 * shows that Jazzer does not use simple brute-force, but
 * rather uses coverage data to find inputs that are needed
 * to visit branches
 */
public class Fuzz {
	public static void fuzzerTestOneInput(byte[] input) {
		String value = new String(input, StandardCharsets.UTF_8);

		// Jazzer will quickly find that the string needs to match
		// some values
		if (value.contains("TEST") && value.contains("FOO") && value.contains("BAR") && value.contains("BAZ")) {
			throw new IllegalStateException("Expected exception if Fuzzing manages to 'detect' the values that enters"
					+ " the exception-throwing branch.");
		}
	}
}
