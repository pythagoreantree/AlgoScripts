package com.maria;

import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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

	public static Stream<Arguments> findLetterProvider(){
		return Stream.of(
				arguments(new char[]{'c', 'f', 'j'}, 'a', 'c'),
				arguments(new char[]{'c', 'f', 'j'}, 'c', 'f'),
				arguments(new char[]{'c', 'f', 'j'}, 'd', 'f'),
				arguments(new char[]{'a', 'b'}, 'z', 'a'),
				arguments(new char[]{'a', 'b'}, 'b', 'a')
		);
	}

	public static Stream<Arguments> findMin2Provider(){
		return Stream.of(
				arguments(new int[]{3,4,5,1,2}, 1),
				arguments(new int[]{4,5,6,7,0,1,2}, 0),
				arguments(new int[]{11,13,15,17}, 11)
		);
	}

	public static Stream<Arguments> findMinWithDuplicatesProvider(){
		return Stream.of(
				arguments(new int[]{4, 5, 6, 7, 0, 1, 4}, 0),
				arguments(new int[]{4, 5, 6, 7, 0, 1, 3}, 0),
				arguments(new int[]{7, 0, 1, 4, 4, 5, 6}, 0),
				arguments(new int[]{0, 1, 4, 4, 5, 6, 7}, 0),
				arguments(new int[]{4, 4, 4, 4, 4, 4, 4}, 4),
				arguments(new int[]{4, 1, 2, 4, 4, 4, 4}, 1),
				arguments(new int[]{4, 4, 4, 4, 1, 2, 4}, 1),
				arguments(new int[]{4, 4, 4, 4, 5, 6, 4}, 4),
				arguments(new int[]{4, 5, 5, 4, 4, 4, 4}, 4),
				arguments(new int[]{2, 2, 2, 0, 1}, 0)
		);
	}

	public static Stream<Arguments> intersectionOfTwoArraysProvider(){
		return Stream.of(
				arguments(new int[]{1,2,2,1}, new int[]{2,2}, new int[]{2}),
				arguments(new int[]{4,9,5}, new int[]{9,4,9,8,4}, new int[]{4,9}),
				arguments(new int[]{4,7,9,7,6,7}, new int[]{5,0,0,6,1,6,2,2,4}, new int[]{4,6})
		);
	}

	public static Stream<Arguments> intersectionOfTwoArraysIIProvider(){
		return Stream.of(
				arguments(new int[]{1,2,2,1}, new int[]{2,2}, new int[]{2,2}),
				arguments(new int[]{4,9,5}, new int[]{9,4,9,8,4}, new int[]{4,9}),
				arguments(new int[]{4,7,9,7,6,6,7}, new int[]{5,0,0,6,1,6,2,2,4}, new int[]{4,6,6}),
				arguments(new int[]{1000, 1000, 1000}, new int[]{1000, 1000}, new int[]{1000, 1000}),
				arguments(new int[]{3, 1, 2}, new int[]{1, 1}, new int[]{1})
		);
	}

	public static Stream<Arguments> twoSumProvider(){
		return Stream.of(
				arguments(new int[]{2,7,11,15}, 9, new int[]{1,2}),
				arguments(new int[]{2,3,4}, 6, new int[]{1,3}),
				arguments(new int[]{-1,0}, -1, new int[]{1,2})
		);
	}

	public static Stream<Arguments> findDuplicateNumberProvider(){
		return Stream.of(
				arguments(new int[]{1,3,4,2,2}, 2),
				arguments(new int[]{3,1,3,4,2}, 3),
				arguments(new int[]{1,1}, 1)
		);
	}

	public static Stream<Arguments> findMedianTwoSortedProvider(){
		return Stream.of(
				arguments(new int[]{1,3}, new int[]{2}, 2.0),
				arguments(new int[]{1,3}, new int[]{2,4}, 2.5)
		);
	}


}
