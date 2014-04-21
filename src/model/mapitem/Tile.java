package model.mapitem;

import java.util.ArrayList;
import java.util.List;

import model.friendly.Swamp;
import model.friendly.Tower;
import model.runes.Rune;
import control.SkeletonUI;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Tile.java
//  @ Date : 2014.03.19.
//  @ Author : 
//
//

public abstract class Tile {
	
	private List<Tile> neighbours;
	private List<Road> nextRoad = new ArrayList<Road>();
	
	public void addNextRoad(Road next) {
		nextRoad.add(next);
	}
	
	public boolean checkTower() {
		SkeletonUI.enterFunction(this, "checkTower");

		SkeletonUI.leaveFunction(false);
		return false;
	}

	public void putTower(Tower t) {
		return;
	}

	public boolean checkRune() {
		return false;
	}
	
	public void addFog(Fog f){
		return;
	}

	public abstract void putRune(Rune r);

	public boolean checkSwamp() {
		return false;
	}

	public void putSwamp(Swamp s) {
		return;
	}

	public void addTower(int distance, Tower t) {
		if(distance <= 1)
			return;
		for (Tile neighbour : neighbours) {
			neighbour.addTower(distance - 1, t);
		}
	}
	
	public void removeTower(int distance, Tower t) {
		if(distance <= 1)
			return;
		for (Tile neighbour : neighbours) {
			neighbour.removeTower(distance - 1, t);
		}
	}

	public void addNeighbours(List<Tile> neighbourList) {
		neighbours = neighbourList;
	}

	public void setSucceedingRoads(List<Tile> nextRoads) {

	}

	public void removeFog(Fog fog) {
		// TODO: Zsoltiii <3
	}
}
