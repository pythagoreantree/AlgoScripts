package com.maria.yandex30;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BeautifulStringTest {

    @ParameterizedTest
    @MethodSource("provideData")
    void countLongest(String s, int k, int res) {
        int ans = BeautifulString.countLongest(s, k);
        Assertions.assertEquals(res, ans);
    }


    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("aaaaa", 0, 5),
                Arguments.of("abcds", 0, 1),
                Arguments.of("abc", 1, 2),
                Arguments.of("aba", 1, 3),
                Arguments.of("", 1, 0),
                Arguments.of("baaabc", 2, 5),
                Arguments.of("baaabc", 4, 5),
                Arguments.of("bbbcbbb", 4, 7),
                Arguments.of("bbbbbbc", 1, 7),
                Arguments.of("bbbbbbc", 4, 7),
                Arguments.of("a", 4, 1),
                Arguments.of("a", 0, 1),
                Arguments.of("a", 1, 1),
                Arguments.of("ab", 1, 2),
                Arguments.of("ab", 2, 2),
                Arguments.of("helto", 2, 3),
                Arguments.of("abcaz", 2, 4),
                Arguments.of("abdaabdddettd", 6, 11)
        );
    }
}