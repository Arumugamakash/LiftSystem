package com.arumugamakash.liftsystem.services;

import java.util.List;
import java.util.Scanner;

import com.arumugamakash.liftsystem.model.Lift;

public class LiftServiceView {
	static Scanner sc = new Scanner(System.in);
	private LiftServiceModel liftServiceModel;

	public LiftServiceView() {
		liftServiceModel = new LiftServiceModel(this);
	}

	public void init(List<Lift> lifts) {
		while (true) {
			System.out.println(
					"\n1.Display the Lift position\n2.Assign Lift postion\n3.Assign List To_user\n4.Assign_Nearest Lift\n5.User Requeirement\n6.Assign Restrict the Lift\n7.Assign_Least Number of Stops\n8.Asssign_Capacity\n9.Set Capacity\n10.Set Maintenance\n11.Get Available Lift\n12.Exit");
			System.out.println("Enter your choice");
			String choice = sc.nextLine();
			switch (choice) {
			case "1":
				liftServiceModel.displayLifts(lifts);
				break;
			case "2":
				liftServiceModel.assignLiftPosition(lifts);
				break;
			case "3":
				liftServiceModel.assignLiftUser(lifts, getCurrentFloor(), getDestinationFloor());
				break;
			case "4":
				liftServiceModel.assignNearestLift(lifts, getCurrentFloor(), getDestinationFloor());
				break;
			case "5":
				liftServiceModel.userRequirement(lifts, getCurrentFloor(), getDestinationFloor());
				break;
			case "6":
				liftServiceModel.assignLiftRestiction(lifts, getCurrentFloor(), getDestinationFloor());
				break;
			case "7":
				liftServiceModel.leastNumberStops(lifts, getCurrentFloor(), getDestinationFloor());
				break;
			case "8":
				liftServiceModel.assignCapacity(lifts, getCurrentFloor(), getDestinationFloor(), getCapacity());
				break;
			case "9":
				liftServiceModel.setcapacity(lifts);
				break;
			case "10":
				liftServiceModel.setMainenanceLift(lifts);
				break;
			case "11":
				liftServiceModel.getAvaliableLift(lifts, getCurrentFloor(), getDestinationFloor());
				break;
			case "12":
				System.out.println("ThanYou For Using...Lift Management");
				return;
			default:
				System.out.println("Invalid Input");
				break;

			}

		}
	}

	private int getCurrentFloor() {
		System.out.println("Enter the Current Floor");
		int curFloor = sc.nextInt();
		sc.nextLine();
		return curFloor;
	}

	private int getDestinationFloor() {
		System.out.println("Enter the Destination Floor");
		int desFloor = sc.nextInt();
		sc.nextLine();
		return desFloor;
	}

	private int getCapacity() {
		System.out.println("Enter the capacity");
		int capacity = sc.nextInt();
		sc.nextLine();
		return capacity;
	}

	public void getMessage(String liftName) {
		System.out.println(liftName + " is Assigned");
	}
}
