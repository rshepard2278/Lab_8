/**
 * @author Richard Shepard
 * @version Mar 25, 2015
 */
package com.rshepard.simulation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicArrowButton;

public class BattleDisplay implements ActionListener{

	private BattleDisplayPanel battleDisplayPanel;
	private BattleStatsPanel battleStatsPanel;
	private JButton start;
	
	private boolean gameStart;
	
	private static final int WIDTH = 765;
	private static final int HEIGHT = 585;

	private static final String TITLE = "Battle Arena";

	public BattleDisplay(CreatureMap arena) {

		gameStart = false;
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLayout(new BorderLayout(5, 5));
		frame.setTitle(TITLE);
		battleDisplayPanel = new BattleDisplayPanel(arena);
		battleDisplayPanel.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		battleStatsPanel = new BattleStatsPanel(arena);
		start = new JButton("Start");
		start.setPreferredSize(new Dimension(70, 20));
		start.setLocation(10, 200);
		start.addActionListener(this);
		battleStatsPanel.add(start);
		frame.add(battleDisplayPanel, BorderLayout.CENTER);
		frame.add(battleStatsPanel, BorderLayout.EAST);
		frame.setBackground(Color.white);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public void updateDisplay() {
		battleDisplayPanel.repaint();
		battleStatsPanel.repaint();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton testButton = (JButton)e.getSource();
		if(testButton == start) {
			gameStart = !gameStart;
			System.out.println(gameStart);
		}
	}
	
	public boolean getGameStart() {
		return gameStart;
	}
}
