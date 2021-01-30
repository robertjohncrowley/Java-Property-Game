package Controller;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.BoardSquare;

public class StartupController {
	ArrayList<BoardSquare> squares = new ArrayList<BoardSquare>();
	
	public void SetupBoardSquares() {
		boolean lastWasCorner = false, topOrBottom = false;
		JPanel middleBoard = new JPanel();

		JFrame frame = new JFrame("Property Game - Java Edition");
		frame.setSize(800, 800);

		int xCoOrd = 0, yCoOrd = 0;

		for(int i = 0; i < 20; i++) {
			JPanel panelA = new JPanel(), panelB = new JPanel(); 

			if(i == 10 )
				topOrBottom = true;
			else if(i == 0)
				topOrBottom = false;

			if(i % 10 == 0) {
				if(!topOrBottom || i == 0) {
					xCoOrd += 50;
					yCoOrd += 50;
				}
				else {
					yCoOrd += 50;
				}

				squares.add(new BoardSquare(panelA, 80, 80, xCoOrd, yCoOrd));
				squares.add(new BoardSquare(panelB, 80, 80, xCoOrd+530, yCoOrd));
				
				lastWasCorner = true;
			}
			else {
				if(topOrBottom) {
					if(lastWasCorner) {
						xCoOrd += 80;
					}
					else {
						xCoOrd += 50;
					}
					squares.add(new BoardSquare(panelA, 80, 50, xCoOrd, yCoOrd));
					squares.add(new BoardSquare(panelB, 80, 50, xCoOrd, yCoOrd-530));
				}
				else {
					if(lastWasCorner) {
						yCoOrd += 80;
					}
					else {
						yCoOrd += 50;
					}
					squares.add(new BoardSquare(panelA, 50, 80, xCoOrd, yCoOrd));
					squares.add(new BoardSquare(panelB, 50, 80, xCoOrd+530, yCoOrd));
				}

				lastWasCorner = false;
			}
		}
		
		for(int i = 0; i < squares.size(); i++) {
			frame.add(squares.get(i).getPanel());
		}
		
		middleBoard.setBounds(130, 130, 500, 500);
		middleBoard.setBackground(Color.white);
		
		frame.add(middleBoard);
		
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
}
