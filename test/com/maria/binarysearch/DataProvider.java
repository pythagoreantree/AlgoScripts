package com.maria.binarysearch;

import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.Arrays;
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

	public static Stream<Arguments> findPivotProvider(){
		return Stream.of(
				arguments(new int[]{2, 3, 4, 1}, 2)
		);
	}

	public static Stream<Arguments> findPeakElement(){
		return Stream.of(
				arguments(new int[]{1, 2, 1, 3, 5, 6, 4}, 5)
		);
	}

	public static Stream<Arguments> searchLeftProvider(){
		return Stream.of(
				arguments(new int[]{5, 7, 7, 8, 8, 10}, 8, 3),
				arguments(new int[]{}, 0, -1)
		);
	}

	public static Stream<Arguments> searchRightProvider(){
		return Stream.of(
				arguments(new int[]{5, 7, 7, 8, 8, 10}, 8, 4),
				arguments(new int[]{}, 0, -1)
		);
	}

	public static Stream<Arguments> searchLeftRightProvider(){
		return Stream.of(
				arguments(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}),
				arguments(new int[]{}, 0, new int[]{-1, -1})
		);
	}

	public static Stream<Arguments> searchRangeProvider(){
		return Stream.of(
				arguments(new int[]{5, 7, 7, 8, 8, 10}, 4, new int[]{-1, -1}),
				arguments(new int[]{2, 2}, 2, new int[]{0, 1})
		);
	}

	public static Stream<Arguments> findKClosestElementsProvider(){
		return Stream.of(
				arguments(new int[]{1,2,3,4,5}, 3, 4, new ArrayList(Arrays.asList(1,2,3,4))),
				arguments(new int[]{1, 2}, 1, 1, new ArrayList(Arrays.asList(1))),
				arguments(new int[]{1,1,2,2,2,2,2,3,3}, 3, 3, new ArrayList(Arrays.asList(2,3,3)))
		);
	}

	public static Stream<Arguments> search4Provider(){
		return Stream.of(
				arguments(new int[]{1, 2, 4, 5, 6}, 4, 2)
		);
	}


}
