package com.maria.binarysearch;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class DataProvider {

	public static Stream<Arguments> searchDataProvider() {
		return Stream.of(
				arguments(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4),
				arguments(new int[]{-1, 0, 3, 5, 9, 12}, 2, -1)
		);
	}

	public static Stream<Arguments> findMinInRotatedArrayProvider() {
		return Stream.of(
				arguments(new int[]{5, 0, 1, 2, 3, 4}, 0),
				arguments(new int[]{1, 2}, 1)
		);
	}

}
