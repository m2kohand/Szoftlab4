package view.enemies;

import java.awt.Color;
import java.awt.Graphics;

import model.Common;
import model.enemies.Man;
import view.ViewBase;

public class ManView extends ViewBase {

	private Man man;

	public void draw(Graphics g) {
		int health = man.getParameters();

		g.setColor(Color.PINK);
		g.fillOval(x, y, 10, 10);
		g.setColor(Color.RED);
		g.fillRect(x, y - 5, (int) (10 * (double) health / Common.lifeMan), 3);
		g.setColor(Color.BLACK);
		g.drawRect(x, y - 5, 10, 3);
	}
}
