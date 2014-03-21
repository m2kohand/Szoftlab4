package model.enemies;

import model.Game;
import model.runes.Projectile;
import model.runes.Slime;
import control.SkeletonUI;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Man.java
//  @ Date : 2014.03.19.
//  @ Author : 
//
//

public class Man extends EnemyUnit {

	public Man(Game g) {
		gameToNotice = g;
	}

	public Man() {
	}

	public void gotHit(Projectile p) {
		SkeletonUI.enterFunction(this, "gotHit", p);

		p.damageMe(this);

		if (SkeletonUI.booleanQuestion("Is the enemy unit dead?")) {
			roadToNotice.deadNotice(this);
			gameToNotice.notifyIfDead(this);
		}

		SkeletonUI.leaveFunction();
	}

	public void gotSlowed(Slime s) {
		SkeletonUI.enterFunction(this, "gotSlowed", s);

		SkeletonUI.leaveFunction();
	}
}