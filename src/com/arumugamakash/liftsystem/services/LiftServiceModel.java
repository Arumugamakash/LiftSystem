package com.arumugamakash.liftsystem.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.arumugamakash.liftsystem.model.Lift;

public class LiftServiceModel {
	Scanner sc = new Scanner(System.in);
	private LiftServiceView liftServiceView;

	// constructor
	public LiftServiceModel(LiftServiceView liftServiceView) {
		this.liftServiceView = liftServiceView;
	}

	// 1
	public void displayLifts(List<Lift> lifts) {
		System.out.printf("%-10s %-10s", "Lifts", "Floors");
		System.out.println("\n");
		for (Lift lift : lifts) {
			System.out.printf("%-10s %-10s", lift.liftName, lift.position);
			System.out.println();
		}
	}

	// 2
	public void assignLiftPosition(List<Lift> lifts) {
		for (int i = 0; i < lifts.size(); i++) {
			System.out.println("Enter the LiftName");
			String liftName = sc.nextLine();// l1
			for (Lift lift : lifts) {
				if (lift.liftName.equalsIgnoreCase(liftName)) {
					System.out.println("Enter the Lift Position");
					int pos = sc.nextInt();// 2
					sc.nextLine();
					lift.position = pos;
				}
			}
		}
	}

	// 3
	public void assignLiftUser(List<Lift> lifts, int curFloor, int desFloor) {
		if (curFloor >= 0 && curFloor <= 10 && desFloor >= 0 && desFloor <= 10) {
			boolean flag = true;
			for (Lift lift : lifts) {
				if (curFloor == lift.position) {
					lift.position = desFloor;
					liftServiceView.getMessage(lift.liftName);
					flag = false;
					break;
				}
			}
			if (flag) {
				lifts.get(0).position = desFloor;
				liftServiceView.getMessage(lifts.get(0).liftName);
			}
		} else {
			System.out.println("Invalid Floor.....");
		}
	}

	// 4
	public void assignNearestLift(List<Lift> lifts, int curFloor, int desFloor) {
		if (curFloor >= 0 && curFloor <= 10 && desFloor >= 0 && desFloor <= 10) {
			int diff = 0;
			int minDiff = Integer.MAX_VALUE;// 5
			Lift resLift = null;
			for (Lift lift : lifts) {
				diff = Math.abs(lift.position - curFloor); // 1
				if (minDiff > diff) {// 100>1
					minDiff = diff;// 1
					resLift = lift;// l3
				}
			}
			resLift.position = desFloor;
			liftServiceView.getMessage(resLift.liftName);
		} else {
			System.out.println("Invalid Floor....");
		}
	}

	// 5
	public void userRequirement(List<Lift> lifts, int curFloor, int desFloor) {
		if (curFloor >= 0 && curFloor <= 10 && desFloor >= 0 && desFloor <= 10) {
			int cur_Diff = 0;
			int cur_MinDiff = Integer.MAX_VALUE;// 5
			Lift resLift = null;
			for (Lift lift : lifts) {
				cur_Diff = Math.abs(lift.position - curFloor);// 8 2 1
				if (cur_MinDiff >= cur_Diff) {
					cur_MinDiff = cur_Diff;// 8 2 1
					cur_MinDiff = Math.abs(lift.position - curFloor);
					resLift = lift;// 6 0 3
				}
			}
			resLift.position = desFloor;
			liftServiceView.getMessage(resLift.liftName);
		} else {
			System.out.println("Invalid Floor....");
		}
	}

	// 6
	public void assignLiftRestiction(List<Lift> lifts, int curFloor, int desFloor) {
		if (curFloor >= 0 && curFloor <= 10 && desFloor >= 0 && desFloor <= 10) {
			List<Lift> resLift = new ArrayList<Lift>();
			for (Lift lift : lifts) {
				if (lift.path.contains(curFloor) && lift.path.contains(desFloor)) {
					resLift.add(lift);
				}
			}
			assignNearestLift(resLift, curFloor, desFloor);
		} else {
			System.out.println("Invalid Floor....");
		}
	}

	// 7
	public void leastNumberStops(List<Lift> lifts, int curFloor, int desFloor) {
		if (curFloor >= 0 && curFloor <= 10 && desFloor >= 0 && desFloor <= 10) {
			List<Lift> resLift = new ArrayList<Lift>();
			for (Lift lift : lifts) {
				if (lift.path.contains(curFloor) && lift.path.contains(desFloor)) {
					resLift.add(lift);
				}
			}
			getLeastStops(resLift, curFloor, desFloor);
		} else {
			System.out.println("Invalid Floor....");
		}
	}

	// 7
	private void getLeastStops(List<Lift> resLift, int curFloor, int desFloor) {
		if (curFloor >= 0 && curFloor <= 10 && desFloor >= 0 && desFloor <= 10) {
			int left = 0;
			int right = 0;
			int minStop = Integer.MAX_VALUE;
			List<Lift> l = new ArrayList<Lift>();
			if (curFloor > desFloor) {
				left = desFloor;// 0
				right = curFloor;// 7

			} else {
				left = curFloor;// 7
				right = desFloor;// 0
			}
			for (Lift lift : resLift) {
				int curStop = 0;
				for (int i = left; i <= right; i++) {
					if (lift.path.contains(i)) {
						curStop++;
					}
				}
				if (minStop == curStop) {
					minStop = curStop;
					l.add(lift);// l3 4
				}
				if (curStop < minStop) {
					minStop = curStop;
					l.clear();
					l.add(lift);// l3
				}

			}
			assignNearestLift(l, curFloor, desFloor);
		} else {
			System.out.println("Invalid Floor....");
		}
	}

	// 8
	public void assignCapacity(List<Lift> lifts, int curFloor, int desFloor, int capacity) {
		if (curFloor >= 0 && curFloor <= 10 && desFloor >= 0 && desFloor <= 10) {
			List<Lift> resLift = new ArrayList<Lift>();
			boolean flag = false;
			for (Lift lift : lifts) {
				if (lift.capacity >= capacity) {
					resLift.add(lift);
					flag = true;
				}

			}
			if (flag) {
				leastNumberStops(resLift, curFloor, desFloor);
			} else {
				System.out.println("No Lifts");
			}
		} else {
			System.out.println("Invalid Floor....");
		}
	}

	// 9
	public void setcapacity(List<Lift> lifts) {
		System.out.println("Enter the LiftName");
		String liftName = sc.nextLine();// l1
		for (Lift lift : lifts) {
			if (lift.liftName.equalsIgnoreCase(liftName)) {
				System.out.println("Enter the Lift Capacity");
				int capacity = sc.nextInt();// 2
				sc.nextLine();
				lift.capacity = capacity;
			}
		}
	}

	// 10
	public void setMainenanceLift(List<Lift> lifts) {
		System.out.println("Enter the LiftName");
		String liftName = sc.nextLine();// l1
		for (Lift lift : lifts) {
			if (lift.liftName.equalsIgnoreCase(liftName)) {
				lift.position = -1;
			}
		}
	}

	// 11
	public void getAvaliableLift(List<Lift> liftList, int curFloor, int desFloor) {
		if (curFloor >= 0 && curFloor <= 10 && desFloor >= 0 && desFloor <= 10) {
			List<Lift> resLift = new ArrayList<Lift>();

			for (Lift lift : liftList) {
				if (lift.position != -1) {
					resLift.add(lift);
				}
			}
			System.out.println(resLift + "\n");
			assignLiftRestiction(resLift, curFloor, desFloor);
		} else {
			System.out.println("Invalid Floor....");
		}
	}
}
