/**
 * @author Richard Shepard
 * @version Mar 25, 2015
 */
package com.rshepard.simulation;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.rshepard.characters.Creature;

public class BattleDisplayPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private ArrayList<Creature> creatureMap;
	
	private BufferedImage orc;
	private BufferedImage ghoul;
	private BufferedImage creatureToDraw;

	private int width;
	private int height;

	private static final int SIZE = 50;
	
	public BattleDisplayPanel(CreatureMap arena) {
		creatureMap = arena.getCharacterMap();
		width = arena.getMaxX() * SIZE ; 				// SIZE is the width in pixels of the creature image
		height = arena.getMaxY() * SIZE;				// SIZE is the height in pixels of the creature image
		setPreferredSize(new Dimension(width, height));
		initImages();
	}
	
	private void initImages() {
		try {
			orc = ImageIO.read(new File("Images/orc.png"));
		} catch (IOException e1) {
			orc = null;
			e1.printStackTrace();
		}
		try {
			ghoul = ImageIO.read(new File("Images/ghoul.png"));
		} catch (IOException e) {
			ghoul = null;
			e.printStackTrace();
		}
		creatureToDraw = null;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(4));
		g2.setColor(Color.black);
		for (Creature c : creatureMap) {
			int x = c.getX();
			int y = c.getY();
			if(c.getHitPoints() > 0) {
				if ((c.getName().toLowerCase().equals("orc"))) {
					creatureToDraw = orc;
				} else {
					creatureToDraw = ghoul;
				}
				g2.setFont(new Font("Seriff", Font.BOLD, 10));
				g2.drawImage(creatureToDraw, x * SIZE, y * SIZE, this);
				g2.drawString(c.getHealth(), x * SIZE + 10, y * SIZE + 15);
			}
		}
	}
}
