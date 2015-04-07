/**
 * @author Richard Shepard
 * @version Mar 27, 2015
 */
package com.rshepard.simulation;

import java.util.Random;

import com.rshepard.characters.Creature;

public class Battle {
	
	private Creature attacker;
	private Creature defender;
	private Random rgen;

	public Battle(Creature p1, Creature p2) {
		rgen = new Random();
		startFight(p1, p2);
	}
	
	private void startFight(Creature p1, Creature p2) {
		selectAttacker(p1, p2);
		while(continueFight()) {
			fight();
			selectAttacker(p1, p2);
		}
	}

	private boolean continueFight()	{
		boolean continueFight = true;
		if(attacker.getHitPoints() <=0 || defender.getHitPoints() <= 0) {
			continueFight = false;
		}
		return continueFight;
	}
	
	private void selectAttacker(Creature p1, Creature p2) {
		double p1Chance = (p1.getSpeed() * rgen.nextDouble());
		double p2Chance = (p2.getSpeed() * rgen.nextDouble());
		if(p1Chance > p2Chance) {
			attacker = p1;
			defender = p2;
		} else {
			attacker = p2;
			defender = p1;
		}
	}
	
	private void fight() {
		int attackDamage = 0;
		if(attacker.hasWeapon()) {
			attackDamage = attacker.getWeaponHP();
		} else {
			attackDamage = attacker.getMeleeHP();
		}
		attackDamage = (int)(rgen.nextDouble() * attackDamage);
		if(defender.getArmorHP() >= 0) {
			if(defender.getArmorHP() > attackDamage) {
				defender.setArmorHP(defender.getArmorHP() - attackDamage);
			} else {
				int hpDamage = attackDamage - defender.getArmorHP();
				defender.setArmorHP(0);
				defender.setHitPoints(defender.getHitPoints() - hpDamage);
			}
		} else {
			defender.setHitPoints(defender.getHitPoints() - attackDamage);
		}
	}
}
