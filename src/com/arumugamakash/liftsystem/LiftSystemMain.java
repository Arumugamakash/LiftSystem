package com.arumugamakash.liftsystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LiftSystemMain {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the count of lift");
		int length = sc.nextInt();
		sc.nextLine();
		int lift[] = new int[length];
		String[] liftName = new String[lift.length];
		usecases(lift, liftName);

	}

	private static void usecases(int lift[], String liftName[]) {
		try {
			while (true) {
				System.out.println(
						"\n1.Enter the Lift position\n2.Display the Lift position\n3.assignListTouser\n4.Assign_Nearest_Lift\n5.userRequest\n6.RestictTheLift\n7.Exit");
				System.out.println("Enter your choice");
				int choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {
				case 1:
					enterPosition(lift, liftName);
					break;
				case 2:
					displayLiftPosition(lift, liftName);
					break;
				case 3:
					assignListTouser(lift, liftName);
					break;
				case 4:
					nearestLift(lift);
					break;
				case 5:
					userRequest(lift);
					break;
				case 6:
					restictTheLift(lift);
					break;
				case 7:
					System.out.println("Thank You");
					return;
				default:
					return;
				}
			}
		} catch (Exception e) {
			System.out.println("InputMissMatch..tryAgain");
			usecases(lift, liftName);
		}
	}

	private static void restictTheLift(int[] lift) {
		System.out.println("Enter the current floor");
		int cur_floor = sc.nextInt();// 2
		System.out.println("Enter the Designation floor");
		int desc_floor = sc.nextInt();// 5

		if (cur_floor <= 5 && desc_floor<=5) {
			for (int i = 0; i < 3; i++) {
				lift[i] = desc_floor;
				break;
			}

		} else if (cur_floor > 5 && desc_floor>5) {
			for (int i = 2; i < 4; i++) {
				lift[i] = desc_floor;
				break;
			}
		} else if((cur_floor >= 0 && cur_floor <=10) && (desc_floor >= 0 && desc_floor <= 10)) {
			lift[5]=desc_floor;
		}
		System.out.println(Arrays.toString(lift));
	}


	private static void userRequest(int[] lift) {
		System.out.println("Enter the current floor");
		int cur_floor = sc.nextInt();// 2
		System.out.println("Enter the Designation floor");
		int desc_floor = sc.nextInt();// 5
		int diff = 0;// 0
		int pos = 0;
		int minDiff = lift[0];// 5
		for (int i = 0; i < lift.length; i++) {
			diff = Math.abs(lift[i] - cur_floor);// 1
			if (minDiff > diff) {// 5>1 1>2
				minDiff = diff;// 1
				pos = i;
			}
		}
		for (int i = 0; i < lift.length; i++) {
			if (pos == i) {
				lift[i] = desc_floor;
				break;
			}
		}
	}

	private static void displayLiftPosition(int[] lift, String[] liftName) {
		System.out.print("Lift :");
		for (int i = 0; i < liftName.length; i++) {
			System.out.println();
			System.out.printf("%-3s", liftName[i] + " -> ");
			System.out.printf("%-1s", lift[i]);
		}
	}

	private static void enterPosition(int lift[], String liftName[]) {
		for (int i = 0; i < lift.length; i++) {
			System.out.println("Enter the LiftName");
			liftName[i] = sc.nextLine();
			System.out.println("Enter the " + liftName[i] + " lift position");
			lift[i] = sc.nextInt();
			sc.nextLine();
		}
		System.out.println(Arrays.toString(lift));
	}

	private static void assignListTouser(int lift[], String liftName[]) {

		System.out.println("Enter the current floor");
		int cur_floor = sc.nextInt();// 2
		System.out.println("Enter the Designation floor");
		int desc_floor = sc.nextInt();// 5
		int available_lift = searchLift(lift, cur_floor, desc_floor);// 0

		for (int i = 0; i < liftName.length; i++) {
			if (i == available_lift) {
				System.out.println(liftName[i] + " is Assigned");
				System.out.println(Arrays.toString(lift));
				break;
			}
		}

	}

	private static int searchLift(int[] lift, int cur_floor, int desc_floor) {
		for (int i = 0; i < lift.length; i++) {
			if (lift[i] == cur_floor) {
				lift[i] = desc_floor;// 5
				return i;
			}
		}
		lift[0] = desc_floor;
		return 0;
	}

	private static void nearestLift(int[] lift) {
		System.out.println("Enter the current floor");
		int cur_floor = sc.nextInt();// 2
		System.out.println("Enter the Designation floor");
		int desc_floor = sc.nextInt();// 5
		int diff = 0;// 0
		int pos = 0;
		int minDiff = lift[0];// 5
		for (int i = 0; i < lift.length; i++) {
			diff = Math.abs(lift[i] - cur_floor);// 1
			if (minDiff > diff) {// 5>1 1>2
				minDiff = diff;// 1
				pos = i;
			}
		}
		for (int i = 0; i < lift.length; i++) {
			if (pos == i) {
				lift[i] = desc_floor;
				break;
			}
		}

	}

}
