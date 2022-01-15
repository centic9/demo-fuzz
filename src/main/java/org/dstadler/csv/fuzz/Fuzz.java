package org.dstadler.csv.fuzz;

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
	}
}
