package com.maria.pyramid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PyramidTest {

    @Test
    void getBrickWeight() {
        double ans = Pyramid.getBrickWeight(322, 156);
        System.out.println(ans);
    }

    @Test
    void getBrickWeightOpt() {
        double ans = Pyramid.getBrickWeightOpt(1, 0);
        System.out.println(ans);
        ans = Pyramid.getBrickWeightOpt(1, 1);
        System.out.println(ans);

        ans = Pyramid.getBrickWeightOpt(2, 0);
        System.out.println(ans);
        ans = Pyramid.getBrickWeightOpt(2, 1);
        System.out.println(ans);
        ans = Pyramid.getBrickWeightOpt(2, 2);
        System.out.println(ans);

        ans = Pyramid.getBrickWeightOpt(322, 156);
        System.out.println(ans);
    }

    @Test
    void getBrickWeightRecursive() {
        double ans = Pyramid.getBrickWeightRecursive(1, 0);
        System.out.println(ans);
        ans = Pyramid.getBrickWeightRecursive(1, 1);
        System.out.println(ans);

        ans = Pyramid.getBrickWeightRecursive(2, 0);
        System.out.println(ans);
        ans = Pyramid.getBrickWeightRecursive(2, 1);
        System.out.println(ans);
        ans = Pyramid.getBrickWeightRecursive(2, 2);
        System.out.println(ans);

        ans = Pyramid.getBrickWeightRecursive(322, 156);
        System.out.println(ans);
    }
}