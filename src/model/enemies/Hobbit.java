package model.enemies;

import model.Game;
import model.runes.Projectile;
import model.runes.Slime;
import view.ViewFactory;

import common.Common;

public class Hobbit extends EnemyUnit {

	public Hobbit(Game g) {
		gameToNotice = g;
		health = Common.lifeHobbit;
		tickDivider = Common.tickHobbit;
		counter = 0;
	}

	public Hobbit(Hobbit h) {
		this(h.gameToNotice);
		h.health /= 2;
		this.health = h.health;
	}

	public void gotHit(Projectile p) {
		if (p.isSplitter() && health > 1) {
			Hobbit newHalf = new Hobbit(this);
			newHalf.setView(ViewFactory.createView(newHalf));

			roadToNotice.addUnit(newHalf);

			gameToNotice.addUnit(newHalf);
		} else {
			health -= p.damageMe(this);

			if (health <= 0) {
				roadToNotice.deadNotice(this);
				gameToNotice.notifyIfDead(this);
			}
		}
	}

	public void gotSlowed(Slime s) {
		counter -= s.slowMe(this);
	}
}