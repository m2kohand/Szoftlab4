package view.friendly;

import java.awt.Color;
import java.awt.Graphics;

import model.friendly.Tower;
import view.ViewBase;
import view.runes.RuneView;

public class TowerView extends ViewBase {

	private Tower tower;
	private RuneView runeView;

	public TowerView(Tower t, int x, int y) {
		super(x, y);

		tower = t;

		runeView = new RuneView();
	}

	public void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillOval(x * 20 + 2, y * 20 + 2, 16, 16);
		runeView.draw(g, x * 20, y * 20);
	}
}
