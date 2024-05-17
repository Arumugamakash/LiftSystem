package com.arumugamakash.liftsystem;

import java.util.List;
import java.util.Scanner;

import com.arumugamakash.liftsystem.model.Lift;
import com.arumugamakash.liftsystem.services.LiftServiceView;

public class LiftSystemMain {
	Scanner sc = new Scanner(System.in);
	private String appName = "LiftSystem";
	private String appVersion = "0.01";
	private static LiftSystemMain liftSystemMain;
	private LiftServiceView liftServiceView;

	public String getAppName() {
		return appName;
	}

	public String getAppVersion() {
		return appVersion; 
	}

	public static LiftSystemMain getInstance() {
		if (liftSystemMain == null) {
			liftSystemMain = new LiftSystemMain();
		}
		return liftSystemMain;
	}

	private void init() {
		System.out.println("\n\tWelcome to Lift Management System\n");
//		Lift lift = new Lift();
		List<Lift> lifts = Lift.start();
//		for (Lift lift : lifts) {
//			System.out.print(lift.liftName);
//			System.out.print(lift.position);
//			System.out.println();
//		}
		new LiftServiceView().init(lifts);

	}

	public static void main(String[] args) {
		liftSystemMain.getInstance().init();
	}

}
