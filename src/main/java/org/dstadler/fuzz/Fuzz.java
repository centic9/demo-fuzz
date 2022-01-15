package org.dstadler.fuzz;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;

/**
 * This class provides a simple target for fuzzing Apache Commons CSV with Jazzer.
 *
 * It uses the fuzzed input data to try to parse CSV files.
 *
 * It catches all exceptions that are currently expected.
 */
public class Fuzz {
	public static void fuzzerTestOneInput(FuzzedDataProvider data) {
		int i = data.consumeInt(0, 10);
		if (i < 0 || i >= 10) {
			throw new IllegalStateException("Requested int between 0 and 10, but had: " + i);
		}
	}
}
