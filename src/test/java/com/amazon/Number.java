package com.amazon;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Number {
	public static void main(String[] args) {

		int[] ar = { 0, 1, 2, 3, 4, 1, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 };

		Set<Integer> uniqueNum = new HashSet<Integer>();
		Set<Integer> duplicateNum = new HashSet<Integer>();

		for (int num : ar) {
			if (!uniqueNum.add(num)) {
				duplicateNum.add(num);

			}

		}
		System.out.println("unquie number:");

		for (int num : uniqueNum) {
			System.out.println(num + " ");

		}
		System.out.println("duplicate number:");
		for (int num : duplicateNum) {
			System.out.println(num + " ");
		}

	}

}
