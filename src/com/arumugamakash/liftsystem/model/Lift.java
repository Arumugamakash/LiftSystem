package com.arumugamakash.liftsystem.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lift {
	static Scanner sc = new Scanner(System.in);
	public String liftName;
	public int position;
	public int capacity;
	public List<Integer> path;

	int path1[] = { 0, 1, 2, 3, 4, 5 };
	int path3[] = { 0, 6, 7, 8, 9, 10 };
	int path5[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	public Lift(int i) {
		this.liftName = "L" + i;
		this.position = 0;
		this.path = getPath(i);
	}

	public static List<Lift> start() {
		List<Lift> liftList = new ArrayList<Lift>();
		System.out.println("Enter the count of the Lift");
		int count = sc.nextInt();// 5
		for (int i = 1; i <= count; i++) {
			Lift tempLift = new Lift(i);
			liftList.add(tempLift);
		}
		return liftList;
	}

	private List<Integer> getPath(int i) {
		if (i == 1 || i == 2) {
			return Arrays.stream(path1).boxed().collect(Collectors.toList());
		} else if (i == 3 || i == 4) {
			return Arrays.stream(path3).boxed().collect(Collectors.toList());
		} else {
			return Arrays.stream(path5).boxed().collect(Collectors.toList());
		}

	}

	@Override
	public String toString() {
		return "Lift [liftName=" + liftName + ", position=" + position + ", capacity=" + capacity + "]";
	}
	
}
