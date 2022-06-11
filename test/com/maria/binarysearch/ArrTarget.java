package com.maria.binarysearch;

import com.sun.tools.javac.util.List;
import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;

public class ArrTarget {

	int[] nums;
	int target;
	int result;

	public ArrTarget(int[] arr, int target, int result){
		this.nums = arr;
		this.target = target;
		this.result = result;
	}

	public int[] getNums() {
		return nums;
	}

	public void setNums(int[] nums) {
		this.nums = nums;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}


	@Override
	public String toString(){
		return new StringBuilder("nums: ").append(Arrays.toString(nums)).append(", target: ").append(this.target).toString();
	}
}
