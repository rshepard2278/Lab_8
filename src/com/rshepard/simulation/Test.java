/**
 * @author Richard Shepard
 * @version Mar 27, 2015
 */
package com.rshepard.simulation;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CreatureMap creatureMap = new CreatureMap();
		BattleDisplay display = new BattleDisplay(creatureMap);
		creatureMap.loadTestMap();
		boolean running = true;
		while(running) {
			boolean continueFlag = display.getGameStart();
			sleep(20);
			while (continueFlag) {
				display.updateDisplay();
				creatureMap.move();
				sleep(200);
				continueFlag = display.getGameStart();
			}
		}
	}
	private static void sleep(int milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
