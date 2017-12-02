package omok;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class MouseEventHandler extends MouseAdapter {
	private Map map;
	private MapSize ms;
	private DrawBoard db;
	public MouseEventHandler(Map m, MapSize ms, DrawBoard db, OmokBoard ob) {
		map = m;
		this.ms = ms;
		this.db = db;
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		super.mousePressed(arg0);
		int x = (int) Math.round(arg0.getX() / (double) ms.getCell() - 1);
		int y = (int) Math.round(arg0.getY() / (double) ms.getCell() - 2);
		
		if (x < 0 || x > 19 || y < 0 || y > 19)
			return ;
		
		if (map.getXY(y, x) == map.getBlack()
				|| map.getXY(y, x) == map.getWhite())
			return ;
		
		map.setMap(y, x);
		map.changeCheck();
		db.repaint();
		if (map.winCheck(x, y)) {
			if (map.getCheck() == true)
				JOptionPane.showMessageDialog(null, "¹éµ¹ÀÌ ½Â¸®ÇÏ¿´½À´Ï´Ù", "¹é ½Â", JOptionPane.INFORMATION_MESSAGE);
			else 
				JOptionPane.showMessageDialog(null, "Èæµ¹ÀÌ ½Â¸®ÇÏ¿´½À´Ï´Ù", "Èæ ½Â", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
	
	
}
