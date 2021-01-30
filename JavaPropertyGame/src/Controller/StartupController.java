package Controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.BoardSquare;

public class StartupController {
	ArrayList<BoardSquare> squares = new ArrayList<>();

	private BufferedImage image, goImage, freeParkingImage, justVisitingImage, jailImage;

	public void SetupBoardSquares() {
		JPanel middleBoard = new JPanel();

		JFrame frame = new JFrame("Property Game - Java Edition");
		frame.setSize(800, 800);

		int xCoOrd = 580, yCoOrd = 580, width = 0, height = 0;

		try {
			image = ImageIO.read(new File("media/property_game_logo.png"));
			goImage = ImageIO.read(new File("media/go.png"));
			freeParkingImage = ImageIO.read(new File("media/free-parking.png"));
			justVisitingImage = ImageIO.read(new File("media/just-visiting.png"));
			jailImage = ImageIO.read(new File("media/jail.png"));
		} catch (IOException ex) {
			System.out.println(ex);
		}

		for(int i = 0; i < 4; i++) {
			if(i == 0 || i == 2) {
				width = 50;
				height = 80;		
			}
			else {
				width = 80;
				height = 50;
			}

			for(int j = 0; j < 10; j++) {
				if(j == 0) {
					squares.add(new BoardSquare(new JPanel(), 80, 80, xCoOrd, yCoOrd));

					if(i == 0)
						xCoOrd -= 50;
					else if(i == 1)
						yCoOrd -= 50;
					else if(i == 2)
						xCoOrd += 80;
					else
						yCoOrd += 80;
				}
				else {
					squares.add(new BoardSquare(new JPanel(), height, width, xCoOrd, yCoOrd));

					if(i == 0)
						xCoOrd -= 50;
					else if(i == 1)
						yCoOrd -= 50;
					else if(i == 2)
						xCoOrd += 50;
					else {
						yCoOrd += 50;
					}

					if(j == 9) {
						if(i == 0)
							xCoOrd -= 30;
						else if(i == 1)
							yCoOrd -= 30;
					}
				}
			}
		}


		for(int i = 0; i < squares.size(); i++) {
			JPanel panel = squares.get(i).getPanel();
			
			if(i % 10 != 0 ) {
				JLabel jlabel = new JLabel("" + i);
				panel.add(jlabel);
			}
			frame.add(panel);
		}


		middleBoard.setBounds(130, 130, 450, 450);
		middleBoard.setBackground(Color.white);
		image = RotateImage(image, 45.0);

		JLabel picLabel = new JLabel(new ImageIcon(image));
		JLabel goLabel = new JLabel(new ImageIcon(goImage));
		JLabel freeParkingLabel = new JLabel(new ImageIcon(freeParkingImage));
		JLabel justVisitingLabel = new JLabel(new ImageIcon(justVisitingImage));
		JLabel jailLabel = new JLabel(new ImageIcon(jailImage));

		int xCo, yCo;

		xCo = (middleBoard.getWidth()-picLabel.getWidth())/2;
		yCo = (middleBoard.getHeight()-picLabel.getHeight())/2;

		picLabel.setBounds(500, yCo, picLabel.getWidth(), picLabel.getHeight());
		middleBoard.setLayout(new GridBagLayout());

		middleBoard.add(picLabel);
		squares.get(0).getPanel().add(goLabel);
		squares.get(10).getPanel().add(justVisitingLabel);
		squares.get(20).getPanel().add(freeParkingLabel);
		squares.get(30).getPanel().add(jailLabel);

		frame.add(middleBoard);

		frame.setLayout(null);
		frame.setVisible(true);
	}

	public BufferedImage RotateImage(BufferedImage image, Double degrees) {
		double radians = Math.toRadians(degrees);
		double sin = Math.abs(Math.sin(radians));
		double cos = Math.abs(Math.cos(radians));
		int newWidth = (int) Math.round(image.getWidth() * cos + image.getHeight() * sin);
		int newHeight = (int) Math.round(image.getWidth() * sin + image.getHeight() * cos);

		BufferedImage rotate = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = rotate.createGraphics();

		int x = (newWidth - image.getWidth()) / 2;
		int y = (newHeight - image.getHeight()) / 2;

		AffineTransform at = new AffineTransform();
		at.setToRotation(radians, x + (image.getWidth() / 2), y + (image.getHeight() / 2));
		at.translate(x, y);
		g2d.setTransform(at);
		// Paint the originl image
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();
		return rotate;
	}
}