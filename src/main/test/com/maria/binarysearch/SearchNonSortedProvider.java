package com.maria.binarysearch;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SearchNonSortedProvider implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
		ArrTarget arrTarget1 = new ArrTarget(new int[]{2, 3, 4, 5, 6, 7, 8, 0, 1}, 8, 6);
		ArrTarget arrTarget2 = new ArrTarget(new int[]{7, 8, 1, 2, 3, 4, 5, 6}, 2, 3);
		ArrTarget arrTarget3 = new ArrTarget(new int[]{5, 1, 3}, 3, 2);
		return Stream.of(
				arguments(arrTarget1.toString(), arrTarget1),
				arguments(arrTarget2.toString(), arrTarget2),
				arguments(arrTarget3.toString(), arrTarget3)
		);
	}
}
