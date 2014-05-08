package view.mapitem;

import java.awt.Color;
import java.awt.Graphics;

import model.mapitem.Field;
import view.RelativeViewBase;
import view.friendly.TowerView;

public class FieldView extends TileViewBase {

	private Field field;
	
	private RelativeViewBase towerView;
	private RelativeViewBase fogView;

	public FieldView(Field f, int x, int y) {
		super(x, y);

		field = f;
	}

	public void notifyView() {
		if (towerView == null && field.hasTower()) {
			towerView = new TowerView(field.getTower());
		}

		if (fogView == null && field.hasFog()) {
			fogView = new FogView();
		} else if (fogView != null && !field.hasFog()) {
			fogView = null;
		}

		super.notifyView();
	}

	protected void paintMe(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x * 20, y * 20, 20, 20);

		if (towerView != null)
			towerView.draw(g, x * 20, y * 20);

		if (fogView != null)
			fogView.draw(g, x * 20, y * 20);
	}
}
