package view.runes;

import java.awt.Color;
import java.awt.Graphics;

import model.runes.Rune;

import view.RelativeViewBase;

public class RuneView implements RelativeViewBase {
	
	private Rune rune;
	
	public RuneView(Rune r) {
		rune = r;
	}
	
	public Rune getRune() {
		return rune;
	}

	protected void setColor(Graphics g) {
		g.setColor(Color.YELLOW);
	}

	public void draw(Graphics g, int x, int y) {
		setColor(g);
		g.fillPolygon(new int[] { x + 5, x + 10, x + 15, x + 10 }, new int[] {
				y + 10, y + 15, y + 10, y + 5 }, 4);
	}
}
