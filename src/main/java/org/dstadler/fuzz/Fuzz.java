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
		// we simply expect the byte-array to be some string,
		// Jazzer will find out which actual input values will
		// get more code-coverage
		String value = new String(input, StandardCharsets.UTF_8);

		// Jazzer will quickly find that the string needs to match
		// these values
		if (value.contains("TEST") && value.contains("FOO") && value.contains("BAR") && value.contains("BAZ") &&
				!value.contains("FOOBAR") && !value.contains("BARBAZ")) {
			throw new IllegalStateException("Expected exception if Fuzzing manages to 'detect' the values that enters"
					+ " the exception-throwing branch.");
		}
	}
}
