package org.dstadler.fuzz;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;

/**
 * This class provides a simple target for fuzzing which
 * shows that Jazzer does not use simple brute-force, but
 * rather uses coverage data to find inputs that are needed
 * to visit branches
 */
public class FuzzWithProvider {
	public static void fuzzerTestOneInput(FuzzedDataProvider data) {
		// here we ask Jazzer to give us a few integers in the given
		// range as input
		int i = data.consumeInt(0, 10000000);
		int j = data.consumeInt(0, 10000000);
		int k = data.consumeInt(0, 10000000);

		// Jazzer will quickly find that this special number
		// is necessary to enter this branch and so fuzzing
		// this method quickly throws the exception
		if (i == 9999999 && j == 9999998 && k == 9999998) {
			throw new IllegalStateException("Expected exception if Fuzzing manages to 'detect' the values that enters"
					+ " the exception-throwing branch.");
		}
	}
}
