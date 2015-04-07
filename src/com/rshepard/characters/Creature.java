/**
 * @author Richard Shepard
 * @version Mar 25, 2015
 */
package com.rshepard.characters;


public abstract class Creature {

	private int hitPoints;
	private int meleeHP;
	private int armorHP;
	private int weaponHP;
	private int weight;
	private int speed;
	private int x;
	private int y;

	private boolean hasWeapon;
	private boolean hasArmor;

	private String name;

	private Weapon weapon;

	public Creature(int x, int y) {
		this.hitPoints = 0;
		this.meleeHP = 0;
		this.armorHP = 0;
		this.weaponHP = 0;
		this.weight = 0;
		this.speed = 0;
		this.hasWeapon = false;
		this.hasArmor = false;
		this.weapon = null;
		this.name = "";
		if(x > 10) {
			this.x = 10;
		} else {
			this.x = x;
		}
		if(y > 10) {
			this.y = 10;
		} else {
			this.y = y;
		}
	}

	public Creature(int hitPoints, int meleeHP, int weight, int speed,
			boolean hasArmor, Weapon weapon, int x, int y) {

		this.hitPoints = hitPoints;
		this.meleeHP = meleeHP;
		this.weight = weight;
		this.speed = speed;
		this.weapon = weapon;
		this.x = x;
		this.y = y;
		setWeaponStats();
		setArmorStats(hasArmor);

	}

	private void setWeaponStats() {
		if (weapon != null) {
			this.hasWeapon = true;
			weaponHP = weapon.damage();
		} else {
			weaponHP = 0;
		}
	}

	private void setArmorStats(boolean hasArmor) {
		this.hasArmor = hasArmor;
		if (hasArmor) {
			armorHP = 100;
		} else {
			armorHP = 0;
		}
	}

	public String battleStats() {
		String stats = "Name:			" + name;
		stats += "\nHP:			" + hitPoints;
		stats += "\nArmor:			" + armorHP;
		return stats;
	}

	/**
	 * @return the hitPoints
	 */
	public int getHitPoints() {
		return hitPoints;
	}

	/**
	 * @param hitPoints
	 *            the hitPoints to set
	 */
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	/**
	 * @return the meleeHP
	 */
	public int getMeleeHP() {
		return meleeHP;
	}

	/**
	 * @param meleeHP
	 *            the meleeHP to set
	 */
	public void setMeleeHP(int meleeHP) {
		this.meleeHP = meleeHP;
	}

	/**
	 * @return the armorHP
	 */
	public int getArmorHP() {
		return armorHP;
	}

	/**
	 * @param armorHP
	 *            the armorHP to set
	 */
	public void setArmorHP(int armorHP) {
		this.armorHP = armorHP;
	}

	/**
	 * @return the weaponHP
	 */
	public int getWeaponHP() {
		return weaponHP;
	}

	/**
	 * @param weaponHP
	 *            the weaponHP to set
	 */
	public void setWeaponHP(int weaponHP) {
		this.weaponHP = weaponHP;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed
	 *            the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the hasWeapon
	 */
	public boolean hasWeapon() {
		return hasWeapon;
	}

	/**
	 * @param hasWeapon
	 *            the hasWeapon to set
	 */
	public void setWeapon(boolean hasWeapon) {
		this.hasWeapon = hasWeapon;
	}

	/**
	 * @return the hasArmor
	 */
	public boolean hasArmor() {
		return hasArmor;
	}

	/**
	 * @param hasArmor
	 *            the hasArmor to set
	 */
	public void setArmor(boolean hasArmor) {
		this.hasArmor = hasArmor;
	}

	/**
	 * @return the weapon
	 */
	public Weapon getWeapon() {
		return weapon;
	}

	/**
	 * @param weapon
	 *            the weapon to set
	 */
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public String getHealth() {
		String health = "HP =" + hitPoints;
		return health;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		if(x > 10 || x < 0) {
			this.x = 10;
		} else {
			this.x = x;
		}
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		if(y > 10 || y < 0) {
			this.y = 10;
		} else {
			this.y = y;
		}
	}

}