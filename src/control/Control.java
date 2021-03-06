package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import model.Game;

import common.Common;

public class Control implements ActionListener, MouseListener,
		MouseMotionListener {

	private Game game;

	public static enum ClickState {
		tower, swamp, elf, dwarf, hobbit, man, range, reload, none
	};

	private ClickState clickState = ClickState.none;

	private int mouseX;
	private int mouseY;

	public Control(Game g) {
		game = g;
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("tower"))
			clickState = ClickState.tower;
		else if (arg0.getActionCommand().equals("swamp"))
			clickState = ClickState.swamp;
		else if (arg0.getActionCommand().equals("elfrune"))
			clickState = ClickState.elf;
		else if (arg0.getActionCommand().equals("manrune")) {
			clickState = ClickState.man;
		} else if (arg0.getActionCommand().equals("dwarfrune"))
			clickState = ClickState.dwarf;
		else if (arg0.getActionCommand().equals("hobbitrune"))
			clickState = ClickState.hobbit;
		else if (arg0.getActionCommand().equals("reloadrune"))
			clickState = ClickState.reload;
		else if (arg0.getActionCommand().equals("rangerune"))
			clickState = ClickState.range;
	}

	public void mouseClicked(MouseEvent arg0) {
		int x = arg0.getX() / Common.tileWidth;
		int y = arg0.getY() / Common.tileWidth;

		if (clickState == ClickState.tower) {
			if (game.putTower(y, x))
				clickState = ClickState.none;
		} else if (clickState == ClickState.swamp) {
			if (game.putSwamp(y, x))
				clickState = ClickState.none;
		} else if (clickState == ClickState.elf) {
			if (game.putRune(y, x, RuneType.Elf))
				clickState = ClickState.none;
		} else if (clickState == ClickState.dwarf) {
			if (game.putRune(y, x, RuneType.Dwarf))
				clickState = ClickState.none;
		} else if (clickState == ClickState.hobbit) {
			if (game.putRune(y, x, RuneType.Hobbit))
				clickState = ClickState.none;
		} else if (clickState == ClickState.man) {
			if (game.putRune(y, x, RuneType.Man))
				clickState = ClickState.none;
		} else if (clickState == ClickState.range) {
			if (game.putRune(y, x, RuneType.Range))
				clickState = ClickState.none;
		} else if (clickState == ClickState.reload) {
			if (game.putRune(y, x, RuneType.Reload))
				clickState = ClickState.none;
		}
	}

	public void mouseMoved(MouseEvent arg0) {
		mouseY = arg0.getX() / Common.tileWidth;
		mouseX = arg0.getY() / Common.tileWidth;
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public ClickState getState() {
		return clickState;
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	public void mouseDragged(MouseEvent arg0) {
	}
}
