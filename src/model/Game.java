package model;

import model.enemies.EnemyUnit;
import model.mapitem.Map;
import control.SkeletonUI;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Game.java
//  @ Date : 2014.03.19.
//  @ Author : 
//
//

public class Game {
	
	private Map map;
	
	public void Skeleton_MapSetter(Map m) {
		map = m;
	}
	
	public void tick() {
//		SkeletonUI.enterFunction(this, "tick");
//		
//		Ticker t = new Ticker();
//		SkeletonUI.addObject(t, "ticker", true);
//		
//		List<EnemyUnit> l = new ArrayList<EnemyUnit>();
//		SkeletonUI.addObject(l, "enemylist", false);
//		
//		if(SkeletonUI.stringQuestion("Hogy dugnád (Orálisan, Análisan, Vaginálisan)?", "O", "a", "v").equals("V")) 
//			t.remove(l);
//		
//		SkeletonUI.leaveFunction();
	}

	public void notifyIfDead(EnemyUnit e) {
		SkeletonUI.enterFunction(this, "notifyIfDead", e);

		SkeletonUI.leaveFunction();
	}
	
	public void Skeleton_MouseOnTile_Rune() {
		map.checkRune(0, 0);
	}
	public void Skeleton_MouseOnTile_Swamp() {
		map.checkSwamp(0, 0);
	}
}
