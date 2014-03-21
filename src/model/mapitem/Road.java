package model.mapitem;

import java.util.ArrayList;
import java.util.List;

import model.enemies.EnemyUnit;
import model.friendly.Swamp;
import model.friendly.Tower;
import model.runes.Rune;
import control.SkeletonUI;

public class Road extends Tile {

	private List<EnemyUnit> enemyList = new ArrayList<EnemyUnit>();
	private Swamp swamp;
	private List<Tower> towersToNotify = new ArrayList<Tower>();
	private Road nextRoad;

	public void Skeleton_SwampSetter(Swamp s) {
		swamp = s;
	}

	public void Skeleton_addTower(Tower t) {
		towersToNotify.add(t);
	}

	public boolean checkSwamp() {
		SkeletonUI.enterFunction(this, "checkSwamp");

		SkeletonUI.leaveFunction(true);
		return true;
	}

	public void addTower(int distance, Tower t) {

	}

	public void putRune(Rune r) {
		SkeletonUI.enterFunction(this, "putRune", r);

		swamp.putRune(r);

		SkeletonUI.leaveFunction();
	}

	public void deadNotice(EnemyUnit e) {
		SkeletonUI.enterFunction(this, "deadNotice");

		for (Tower t : towersToNotify)
			t.removeUnit(e);

		if (swamp != null)
			swamp.removeUnit(e);

		SkeletonUI.leaveFunction();
	}

	public boolean checkRune() {
		SkeletonUI.enterFunction(this, "checkRune");

		boolean available = swamp.checkRune();

		SkeletonUI.leaveFunction(available);
		return available;
	}

	public void putSwamp(Swamp s) {
		SkeletonUI.enterFunction(this, "putSwamp", s);
		Skeleton_SwampSetter(s);
		SkeletonUI.leaveFunction();
	}

	public void addUnit(EnemyUnit e) {
		SkeletonUI.enterFunction(this, "addUnit", e);

		enemyList.add(e);

		if (SkeletonUI.booleanQuestion("Are there any towers to notify?"))
			for (Tower t : towersToNotify)
				t.addUnit(e);

		if (swamp != null)
			swamp.addUnit(e);

		e.setRoad(this);

		SkeletonUI.leaveFunction();
	}

	public void stepMe(EnemyUnit enemyUnit) {
		SkeletonUI.enterFunction(this, "stepMe", enemyUnit);

		for (Tower t : towersToNotify)
			t.removeUnit(enemyUnit);
		swamp.removeUnit(enemyUnit);

		nextRoad.addUnit(enemyUnit);

		SkeletonUI.leaveFunction();
	}

	public void Skeleton_addNextRoad(Road next) {
		nextRoad = next;
	}
}
