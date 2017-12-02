package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import chess.Chess;
import omok.Omok;

public class MiniGames extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JButton btnChess;
	private JButton btnOmok;
	
	public MiniGames() throws IOException {
		setLocation(400, 100);
		setSize(720, 720);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("미니게임 오락실");
		ImageIcon logo = new ImageIcon("resources/logo.png");
		setIconImage(logo.getImage());
		
		Image chessImg = ImageIO.read(new File("resources/chess.png"));
		btnChess = new JButton(new ImageIcon(chessImg));
		btnChess.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Chess();
				dispose();
			}
		});
		btnChess.setBounds(450, 350, 250, 100);
		
		Image omokImg = ImageIO.read(new File("resources/omok.png"));
		btnOmok = new JButton(new ImageIcon(omokImg));
		btnOmok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Omok();
				dispose();
			}
		});
		btnOmok.setBounds(450,500, 250, 100);
		
		ImageIcon backImage = new ImageIcon("resources/background.png");
		JPanel background = new JPanel() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
                g.drawImage(backImage.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        background.setLayout(null);
		setContentPane(background);
		background.add(btnChess);
		background.add(btnOmok);
		
		setVisible(true);
	}
	public static void main(String[] args) throws IOException {
		new MiniGames();
	}

}
