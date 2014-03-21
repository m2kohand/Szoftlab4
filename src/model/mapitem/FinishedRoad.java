package model.mapitem;

import java.util.ArrayList;
import java.util.List;

import model.enemies.EnemyUnit;
import control.SkeletonUI;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : FinishedRoad.java
//  @ Date : 2014.03.19.
//  @ Author : 
//
//

public class FinishedRoad extends Road {
	
	List<EnemyUnit> unitList = new ArrayList<EnemyUnit>();
	
	public List<EnemyUnit> getFinishedUnits() {
		SkeletonUI.enterFunction(this, "getFinishedUnits");

		if (SkeletonUI
				.booleanQuestion("Is there a group of enemies who made it to the end?")) {
			// dontcare
		}
		
		SkeletonUI.leaveFunction(unitList);
		return unitList;
	}

	public void deleteFinishedUnits() {
		SkeletonUI.enterFunction(this, "deleteFinishedUnits");
		unitList.clear();
		SkeletonUI.leaveFunction();
	}
}
