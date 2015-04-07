/**
 * @author Richard Shepard
 * @version Apr 3, 2015
 */
package com.rshepard.simulation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

public class BattleStatsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private CreatureMap arena;
	
	private Font styledBlack;
	
	private int width;
	private int height;
	
	private static final int SIZE = 50;
	
	
	public BattleStatsPanel(CreatureMap arena) {
		this.arena = arena;
		width = 200; 				
		height = arena.getMaxY() * SIZE;			
		setPreferredSize(new Dimension(width, height));
		setBackground(Color.white);
		installFont();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.black);
		g2.setFont(styledBlack);
		String numOrcs = "Orc Count: ";
		String orcCount = " " + arena.getNumOrcs();
		String ghoulCount = " " + arena.getNumGhouls();
		String numGhouls = "Ghoul Count: ";
		g2.drawString(numOrcs, 10, 250);
		g2.setColor(Color.red);
		g2.drawString(orcCount, 160, 250);
		g2.setColor(Color.black);
		g2.drawString(numGhouls, 10, 420);		
		g2.setColor(Color.red);
		g2.drawString(ghoulCount, 160, 420);
	}
	
	private void installFont() {
		try {
		     GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Creator_Campotype_smcp.otf")));
		} catch (IOException|FontFormatException e) {
		     //Handle exception
		}
		styledBlack = new Font("CrEAtoR cAmpoTYPe SmcP", Font.PLAIN, 30);
	}
}
