/**
 * @author Richard Shepard
 * @version Mar 25, 2015
 */
package com.rshepard.simulation;

import java.util.ArrayList;

import com.rshepard.characters.Creature;
import com.rshepard.characters.Ghoul;
import com.rshepard.characters.Orc;

public class CreatureMap {

	private ArrayList<Creature> creatures;
	private int maxX;
	private int maxY;

	public CreatureMap() {
		creatures = new ArrayList<>();
		maxX = 10; // Map can hold 10 creatures on the x axis
		maxY = 10; // Map can hold 10 creatures on the y axis
	}

	public ArrayList<Creature> getCharacterMap() {
		return creatures;
	}

	public void loadTestMap() {
		for(int x = 0; x <= 10; x++) {
			for(int y = 0; y <= 10; y++) {
				if(x < 2) {
					creatures.add(new Orc(x, y));
				} else if(x > 8) {
					creatures.add(new Ghoul(x, y));
				}
			}
		}		
	}

	public void move() {
		int attackX = 0;
		int attackY = 0;
		int defendX = 0;
		int defendY = 0;
		Creature defender = null;
		for (Creature attacker : creatures) {
			attackX = attacker.getX();
			attackY = attacker.getY();
			for (int i = creatures.indexOf(attacker) + 1; i < creatures.size(); i++) {
				defender = creatures.get(i);
				defendX = defender.getX();
				defendY = defender.getY();
				if(!(attacker.getName().equals(defender.getName()))) {
					if ((attackX == defendX && attackY == defendY - 1)
							|| (attackX == defendX + 1 && attackY == defendY)
							|| (attackX == defendX && attackY == defendY + 1)
							|| (attackX == defendX + 1 && attackY == defendY)) {
						new Battle(attacker, defender);
					}
				}
			}
			moveCharacter(attacker);
		}
	}

	private void moveCharacter(Creature c) {
		int moveNum = (int) (Math.random() * 4 + 1);
		int x = c.getX();
		int y = c.getY();
		switch (moveNum) {
		case 1:
			if (y <= 0) {
				break;
			} else {
				y -= 1;
			}
			break;
		case 2:
			if (x >= maxX) {
				break;
			} else {
				x += 1;
			}
			break;
		case 3:
			if (y >= maxY) {
				break;
			} else {
				y += 1;
			}
			break;
		case 4:
			if (x <= 0) {
				break;
			} else {
				x -= 1;
			}
			break;
		}
		c.setX(x);
		c.setY(y);
	}

	/**
	 * @return the maxX
	 */
	public int getMaxX() {
		return maxX;
	}

	/**
	 * @return the maxY
	 */
	public int getMaxY() {
		return maxY;
	}

	/**
	 * @return the numOrcs
	 */
	public int getNumOrcs() {
		int numOrcs = 0;
		for(Creature c : creatures) {
			if(c instanceof Orc && c.getHitPoints() > 0) {
				numOrcs++;
			}
		}
		return numOrcs;
	}

	/**
	 * @return the numGhouls
	 */
	public int getNumGhouls() {
		int numGhouls = 0;
		for(Creature c : creatures) {
			if(c instanceof Ghoul && c.getHitPoints() > 0) {
				numGhouls++;
			}
		}
		return numGhouls;
	}
}
