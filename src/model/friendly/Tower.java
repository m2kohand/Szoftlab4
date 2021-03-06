package model.friendly;

import java.util.ArrayList;
import java.util.List;

import model.ActiveUnit;
import model.enemies.EnemyUnit;
import model.runes.Projectile;
import model.runes.Rune;

public class Tower implements ActiveUnit, FriendlyUnit {

	private List<EnemyUnit> enemyUnits = new ArrayList<EnemyUnit>();
	private Rune rune;
	private EnemyUnit lastTarget;
	private int tickDivider;
	private int counter;
	private boolean isUpgraded;

	private Object view;

	public void setView(Object v) {
		view = v;
	}

	public Object getView() {
		return view;
	}

	public Tower() {
		tickDivider = 10;
		counter = 0;
		isUpgraded = false;
	}

	@Override
	public void tick() {
		counter++;
		if (counter == tickDivider) {
			counter = 0;

			/* k�vetkez� c�lpont kiv�laszt�sa */
			if (lastTarget == null || !enemyUnits.contains(lastTarget)) {
				if (enemyUnits.size() > 0) {
					lastTarget = enemyUnits.get(0);
				} else {
					lastTarget = null;
				}
			}

			/* ha van v�g�lis lehets�ges c�lpont */
			if (lastTarget != null) {
				Projectile projectile = new Projectile();
				rune.modifyProjectile(projectile);

				lastTarget.gotHit(projectile);
			}
		}
	}

	@Override
	public boolean checkRune(Rune r) {
		return !isUpgraded;
	}

	@Override
	public void putRune(Rune r) {
		rune = r;
		isUpgraded = true;
	}

	public void putFirstRune(Rune r) {
		rune = r;
		isUpgraded = false;
	}

	@Override
	public void addUnit(EnemyUnit enemyUnit) {
		enemyUnits.add(enemyUnit);
	}

	@Override
	public void removeUnit(EnemyUnit e) {
		enemyUnits.remove(e);
	}

	public Rune getRune() {
		return rune;
	}

	public void clearEnemies() {
		enemyUnits.clear();
	}
}
