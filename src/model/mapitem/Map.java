package model.mapitem;

import java.util.List;

import model.enemies.EnemyUnit;
import model.friendly.Swamp;
import model.friendly.Tower;
import model.runes.Rune;
import control.SkeletonUI;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Map.java
//  @ Date : 2014.03.19.
//  @ Author : 
//
//

public class Map {

	private Field field;
	private Road road;
	private String Skeleton_answer;
	private FinishedRoad finishedRoad;

	public void Skeleton_FieldSetter(Field f) {
		field = f;
	}

	public void Skeleton_RoadSetter(Road r) {
		road = r;
	}

	public void Skeleton_FinishedRoadSetter(FinishedRoad f) {
		finishedRoad = f;
	}

	public boolean checkTower(int x, int y) {
		SkeletonUI.enterFunction(this, "checkTower", x, y);

		boolean available = false;

		Skeleton_answer = SkeletonUI
				.stringQuestion(
						"Is that tile a Field or a Road? you want to put a Tower on it",
						"F", "R");

		if (Skeleton_answer.equals("F"))
			available = field.checkTower();
		else
			available = road.checkTower();

		SkeletonUI.leaveFunction(available);
		return available;

	}

	public void putTower(int x, int y, Tower t) {
		SkeletonUI.enterFunction(this, "putTower", x, y, t);
		field.putTower(t);
		SkeletonUI.leaveFunction();
	}

	public boolean checkRune(int x, int y) {
		SkeletonUI.enterFunction(this, "checkRune", x, y);

		Skeleton_answer = SkeletonUI.stringQuestion(
				"Is that tile a Field or a Road?", "F", "R");
		boolean available = false;

		if (Skeleton_answer.equals("F"))
			available = field.checkRune();
		else
			available = road.checkRune();

		SkeletonUI.leaveFunction(available);
		return available;

	}

	public void putRune(int x, int y, Rune r) {
		SkeletonUI.enterFunction(this, "putRune", x, y, r);

		if (Skeleton_answer.equals("F"))
			field.putRune(r);
		else
			road.putRune(r);

		SkeletonUI.leaveFunction();
	}

	public boolean checkSwamp(int x, int y) {
		SkeletonUI.enterFunction(this, "checkSwamp", x, y);

		boolean available = false;

		Skeleton_answer = SkeletonUI
				.stringQuestion(
						"Is that tile a Field or a Road? you want to put a Swamp on it",
						"F", "R");

		if (Skeleton_answer.equals("F"))
			available = field.checkSwamp();
		else
			available = road.checkSwamp();

		SkeletonUI.leaveFunction(available);
		return available;
	}

	public void putSwamp(int x, int y, Swamp s) {
		SkeletonUI.enterFunction(this, "putSwamp", x, y, s);
		road.putSwamp(s);
		SkeletonUI.leaveFunction();
	}

	public void setConnections() {

	}

	public List<EnemyUnit> getFinishedUnits() {
		SkeletonUI.enterFunction(this, "getFinishedUnits");

		List<EnemyUnit> unitList = finishedRoad.getFinishedUnits();

		SkeletonUI.leaveFunction(unitList);
		return unitList;
	}

	public void deleteFinishedUnits() {
		SkeletonUI.enterFunction(this, "deleteFinishedUnits");
		finishedRoad.deleteFinishedUnits();
		SkeletonUI.leaveFunction();
	}

	public void addUnit(EnemyUnit e) {
		SkeletonUI.enterFunction(this, "addUnit", e);
		road.addUnit(e);
		SkeletonUI.leaveFunction();
	}
}
