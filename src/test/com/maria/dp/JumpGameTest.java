package com.maria.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class JumpGameTest {

    @BeforeEach
    void clearDP() {
        JumpGame.dp.clear();
    }

    @Test
    void canJump1() {
        int[] nums = {2,3,1,1,4};
        boolean result = JumpGame.canJump(nums);
        System.out.println(result);
        Assertions.assertTrue(result);
    }

    @Test
    void canJump2() {
        int[] nums = {3,2,1,0,4};
        boolean result = JumpGame.canJump(nums);
        System.out.println(result);
        Assertions.assertFalse(result);
    }

    @Test
    void canJump3() {
        int[] nums1 = {1};
        boolean result1 = JumpGame.canJump(nums1);
        System.out.println(result1);
        Assertions.assertTrue(result1);

        int[] nums2 = {0};
        boolean result2 = JumpGame.canJump(nums2);
        System.out.println(result2);
        Assertions.assertTrue(result2);
    }

    @Test
    void canJump4() {
        Path path = Paths.get("src", "main", "test", "com", "maria", "dp", "case1.txt");
        String str = "";
        try {
            str = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file from path " + path.toAbsolutePath());
        }
        String[] arr = str.split(",");
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.valueOf(arr[i]);
        }

        boolean result = JumpGame.canJump(nums);
        System.out.println(result);
    }

    @Test
    void canJump5() {
        Path path = Paths.get("src", "main", "test", "com", "maria", "dp", "case1.txt");
        String str = "";
        try {
            str = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file from path " + path.toAbsolutePath());
        }
        String[] arr = str.split(",");
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.valueOf(arr[i]);
        }

        boolean result = JumpGame.canJumpIII(nums);
        System.out.println(result);
    }
}