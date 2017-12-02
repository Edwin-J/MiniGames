package omok;
import java.awt.Container;

import javax.swing.*;

public class OmokBoard extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private Container c;
	MapSize size = new MapSize();
	
	public OmokBoard() {
		ImageIcon logo = new ImageIcon("resources/logo.png");
		setIconImage(logo.getImage());
		setTitle("¿À¸ñ");
		setLocation(400, 100);
		c = getContentPane();
		c.setLayout(null);
		Map map = new Map(size);
		DrawBoard db = new DrawBoard(size, map);
		setSize(720, 720);
		setContentPane(db);
		setResizable(false);
		addMouseListener(new MouseEventHandler(map, size, db, this));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
