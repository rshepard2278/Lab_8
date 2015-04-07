/**
 * @author Richard Shepard
 * @version Mar 25, 2015
 */
package com.rshepard.characters;

public enum Weapon {
	
	DAGGER(10),
	SWORD(20),
	AXE(35),
	BOW(15);
	
	private int damage;
	
	Weapon(int damage) {
		this.damage = damage;
	}

	public int damage() {
		return damage;
	}
}
