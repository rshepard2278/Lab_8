/**
 * @author Richard Shepard
 * @version Mar 27, 2015
 */
package com.rshepard.characters;

public class Ghoul extends Creature {

	private boolean invisible;
	private boolean canTeleport;

	
	public Ghoul(int x, int y) {
		super(200, 5, 150, 3, true, null, x, y);
		this.invisible = false;
		this.canTeleport = false;
		setName("Ghoul");
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
	public Ghoul(int hitPoints, int meleeHP, int armorHP, int weaponHP,
			int weight, int speed, boolean hasArmor, Weapon weapon,
			boolean invisible, boolean canTeleport, int x, int y) {
		super(hitPoints, meleeHP, weight, speed, hasArmor, weapon, x, y);
		this.invisible = invisible;
		this.canTeleport = canTeleport;
	}

	/**
	 * @return the visible
	 */
	public boolean isInvisible() {
		return invisible;
	}

	/**
	 * @param visible
	 *            the visible to set
	 */
	public void setInvisible(boolean visible) {
		this.invisible = visible;
	}

	/**
	 * @return the canTeleport
	 */
	public boolean isCanTeleport() {
		return canTeleport;
	}
	
	public String toString() {
		String stats = "Ghoul";
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
		stats += "\nTeleport:		" + canTeleport;
		stats += "\nInvisibility:" + invisible;
		return stats;
	}

}
