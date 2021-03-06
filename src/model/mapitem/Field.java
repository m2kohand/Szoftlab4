package model.mapitem;

import model.friendly.Tower;
import model.runes.Rune;
import view.View;

public class Field extends Tile {
	private Tower tower;
	private View view;

	public void setView(View tw) {
		view = tw;
	}

	public boolean checkTower() {
		if (tower == null)
			return true;
		return false;
	}

	public void putRune(Rune r) {
		tower.putRune(r);
		addTower(r.getDistance(), tower);
		view.notifyView();
	}

	public void putTower(Tower t) {
		tower = t;
		addTower(t.getRune().getDistance(), t);
		view.notifyView();
	}

	public boolean checkRune(Rune r) {
		if (tower != null)
			return tower.checkRune(r);
		return false;
	}

	public void addFog(Fog f) {
		if (tower != null) {
			tower.clearEnemies();
			removeTower(tower.getRune().getDistance(), tower);
			addTower(tower.getRune().getDistance() - f.getDistanceReduction(),
					tower);
		}

		super.addFog(f);
		view.notifyView();
	}

	public void removeFog(Fog f) {
		if (tower != null) {
			removeTower(tower.getRune().getDistance() - f.getDistanceReduction(),
					tower);
			addTower(tower.getRune().getDistance(), tower);
		}
		super.removeFog(f);
		view.notifyView();
	}

	public boolean hasTower() {
		if (tower != null)
			return true;
		else
			return false;

	}

	public Tower getTower() {
		return tower;
	}
}
