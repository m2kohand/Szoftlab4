package model;

import java.util.ArrayList;
import java.util.List;

import model.enemies.EnemyUnit;
import model.enemies.Man;
import model.friendly.Swamp;
import model.friendly.Tower;
import model.mapitem.Map;
import model.runes.Rune;
import control.SkeletonUI;

public class Game {

	private Map map;

	private Ticker ticker;

	public void Skeleton_MapSetter(Map m) {
		map = m;
	}

	public void tick() {
		// SkeletonUI.enterFunction(this, "tick");
		//
		// Ticker t = new Ticker();
		// SkeletonUI.addObject(t, "ticker", true);
		//
		// List<EnemyUnit> l = new ArrayList<EnemyUnit>();
		// SkeletonUI.addObject(l, "enemylist", false);
		//
		// if(SkeletonUI.stringQuestion("Hogy dugnád (Orálisan, Análisan, Vaginálisan)?",
		// "O", "a", "v").equals("V"))
		// t.remove(l);
		//
		// SkeletonUI.leaveFunction();
	}

	public void notifyIfDead(EnemyUnit e) {
		SkeletonUI.enterFunction(this, "notifyIfDead", e);

		ticker.remove(e);

		SkeletonUI.leaveFunction();
	}

	public void Skeleton_MouseOnTile_Rune() {
		boolean available = map.checkRune(0, 0);

		if (available) {

			Rune rune = new Rune();
			SkeletonUI.addObject(rune, "rune", true);

			map.putRune(0, 0, rune);
		}
	}

	public void Skeleton_MouseOnTile_Swamp() {
		boolean available = map.checkSwamp(0, 0);
		if (available) {
			Rune r = new Rune();
			SkeletonUI.addObject(r, "r", true);

			Swamp s = new Swamp();
			SkeletonUI.addObject(s, "s", true);

			map.putSwamp(0, 0, s);
			map.putRune(0, 0, r);

		}

	}

	public void Skeleton_MouseOnTile_Tower() {
		boolean available = map.checkTower(0, 0);
		if (available) {
			Rune r = new Rune();
			SkeletonUI.addObject(r, "r", true);

			Tower t = new Tower();
			SkeletonUI.addObject(t, "t", true);

			map.putTower(0, 0, t);
			map.putRune(0, 0, r);

		}

	}

	public void Skeleton_addTicker(Ticker t) {
		ticker = t;
	}
}
