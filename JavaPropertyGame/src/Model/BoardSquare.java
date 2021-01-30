package Model;

import java.awt.Color;

import javax.swing.*;


public class BoardSquare {
	
	private JPanel panel;
	private int height, width, xCoOrd, yCoOrd;

	public BoardSquare(JPanel panel, int height, int width, int xCoOrd, int yCoOrd) {
		super();
		this.panel = panel;
		this.height = height;
		this.width = width;
		this.xCoOrd = xCoOrd;
		this.yCoOrd = yCoOrd;
		
		panel.setBounds(xCoOrd, yCoOrd, width, height);
		panel.setBackground(Color.decode("#cde6d0"));
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}




	public JPanel getPanel() {
		return panel;
	}


	public void setPanel(JPanel panel) {
		this.panel = panel;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getxCoOrd() {
		return xCoOrd;
	}


	public void setxCoOrd(int xCoOrd) {
		this.xCoOrd = xCoOrd;
	}


	public int getyCoOrd() {
		return yCoOrd;
	}


	public void setyCoOrd(int yCoOrd) {
		this.yCoOrd = yCoOrd;
	}
}
