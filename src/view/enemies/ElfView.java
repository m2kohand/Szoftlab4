package view.enemies;

import java.awt.Graphics;

import model.enemies.Elf;

import common.Common;

/**
 * 
 * Elf ellens�ges egys�g megjelen�t�s��rt felel�s objektum, lesz�rmazik az
 * EnemyUnitView oszt�lyb�l
 * 
 */
public class ElfView extends EnemyUnitView {
	/**
	 * Konstruktor
	 * 
	 * @param e
	 *            Elf
	 */
	public ElfView(Elf e) {
		super(e);
	}
	
	/**
	 * Az egys�g kirajzol�sa
	 * 
	 * @param g
	 *            Graphics
	 * @param x
	 * 			  int - x koordin�ta
	 * @param y
	 * 			  int - y koordin�ta
	 *            
	 */
	@Override
	protected void drawUnit(Graphics g, int x, int y) {
		g.drawImage(elf, x, y, null);
	}

	/**
	 * Visszaadja az Elf egys�g sebz�s n�lk�li �let�t.
	 * 
	 * @return life int - a maximum �let ami lehets�ges az Elf egys�gekn�l
	 */
	@Override
	protected int getMaxLife() {
		return Common.lifeElf;
	}
}
