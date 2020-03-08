import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.BorderLayout;

import java.util.Random;
import java.util.ArrayList;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

class LetterTile extends JPanel implements MouseListener {
    private int colorR;
    private int colorG;
    private int colorB;
    private int colorR2;
    private int colorG2;
    private int colorB2;
    private String letterChosen;
    private int shapeSelection;
    private String shapeString;

    LetterTile() {
        super();
        RandomProperties();
        addMouseListener(this);
    }

    private static int GetNumberBetween(int min, int max) { //Utils.java
        Random myRandom = new Random();
        return min + myRandom.nextInt(max-min+1);
    }   

    public void RandomProperties() {
        Random gen = new Random();

        colorR = gen.nextInt(255);
        colorG = gen.nextInt(255);
        colorB = gen.nextInt(255);

        colorR2 = ((colorR+128)%256);
        colorG2 = ((colorG+128)%256);
        colorB2 = ((colorB+128)%256);

        shapeSelection = gen.nextInt(2);
        for (int i = 0; i < 1; i++) {
            String letterOption = "abcdefghijklmnopqrstuvwxyz";
            letterChosen = Character.toString(letterOption.charAt(GetNumberBetween(0,25)));
        }

		if (shapeSelection == 1) {
            shapeString = "Square tile";
        }
		if (shapeSelection != 1) {
			shapeString = "Circle tile";
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(colorR,colorG,colorB));

        int windowWidth = getWidth();
        int windowHeight = getHeight();
        
        if (shapeSelection == 1) {
            g.fillOval(10, 10, windowWidth-10, windowHeight-10);
        }
        if (shapeSelection != 1) {
            g.fillRect(10, 10, windowWidth-10, windowHeight-10);
        }
        
        int fontSize=50;
        g.setFont(new Font("Monospaced", Font.PLAIN, fontSize));

        g.setColor(new Color(colorR2,colorG2,colorB2));
        g.drawString(letterChosen,windowWidth/2-10,windowHeight/2+20);
    }

    public String toStringShape() {
        return String.format("Drawn tile shape = %s", shapeString);
    }

    public String toStringLetter() {
        return String.format("\nDrawn letter = %s", letterChosen);
    }

    public String toStringColor() {
        return String.format("\nFilled Colors (RGB) = %d , %d , %d", colorR, colorG, colorB);
    }

    public String toStringColorContrast() {
        return String.format("\nContrasting Color (RGB2)= %d , %d , %d\n", colorR2, colorG2, colorB2);
    }

    public void mouseReleased(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseClicked(MouseEvent e) {
        RandomProperties();
        repaint();
    }
    public void mousePressed(MouseEvent e) {
    }
}