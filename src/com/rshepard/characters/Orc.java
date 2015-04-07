/**
 * @author Richard Shepard
 * @version Mar 27, 2015
 */
package com.rshepard.characters;

public class Orc extends Creature {
	
	private int numberOfArms;
	private boolean canHunt;
	
	public Orc(int x, int y) {
		super(200, 10, 250, 1, false, Weapon.AXE, x, y);
		this.numberOfArms = 2;
		this.canHunt = false;
		setName("Orc");
	}

	/**
	 * @param hitPoints
	 * @param meleeHP
	 * @param armorHP
	 * @param weaponHP
	 * @param weight
	 * @param speed
	 * @param hasArmor
	 * @param weapon
	 */
	public Orc(int hitPoints, int meleeHP, int armorHP, int weaponHP,
			int weight, int speed, boolean hasArmor, Weapon weapon, int numberOfArms, boolean canHunt, int x, int y) {
		super(hitPoints, meleeHP, weight, speed, hasArmor, weapon, x, y);
		this.numberOfArms = numberOfArms;
		this.canHunt = canHunt;
	}

	/**
	 * @return the numberOfArms
	 */
	public int getNumberOfArms() {
		return numberOfArms;
	}

	/**
	 * @return the canHunt
	 */
	public boolean isCanHunt() {
		return canHunt;
	}
	
	public String toString() {
		String stats = "Orc";
		stats += "\n===================";
		stats += "\nHP:			" + getHitPoints();
		stats += "\nSpeed:			" + getSpeed();
		stats += "\nMelee:			" + getMeleeHP();
		stats += "\nWeight:			" + getWeight();
		if(hasWeapon()) {
			stats += "\nWeapon: 		" + getWeapon();
			stats += "\nWeaponHP:		" + getWeaponHP();
		}
		if(hasArmor()) {
			stats += "\nArmorHP:		" + getArmorHP();		
		}
		stats += "\nNum Arms:		" + numberOfArms;
		stats += "\nHunt:			" + canHunt;
		return stats;
	}

}
