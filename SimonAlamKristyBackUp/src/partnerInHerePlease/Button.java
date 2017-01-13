package partnerInHerePlease;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Font;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;

import gui.components.Action;
import gui.components.Component;
import simonAlam.ButtonInterfaceAlam;

public class Button extends Component implements ButtonInterfaceAlam {

	private Color c;
	private Color displayC;
	private Action acts;
	private final static int W = 100;
	private final static int H = 100;
	private static int bWidth;
	private static int bHeight;
	
	public Button() {
		super(100*bWidth + value(bWidth), 80*bHeight +150 , W, H);
		bWidth++;
		if(bWidth < 3){
			bHeight ++;
		}else if(bWidth > 3){
			bHeight--;
		}
		
	}

	private static int value(int b) {
		if(b >= 3){
			return 100;
		}else{
			return 75;
		}
			
	}
	
	@Override
	public boolean isHovered(int x, int y) {
		double distance = Math.sqrt(Math.pow(x-(getX()+W/2), 2)+Math.pow(y-(getY()+H/2), 2));	
		return distance < W/2;
	}

	@Override
	public void update(Graphics2D g) {
		if(displayC != null){
			g.setColor(displayC);
		}
		else g.setColor(Color.gray);
		g.fillOval(0, 0, W, H);
		g.setColor(Color.black);
		g.drawOval(0, 0, W - 1, H - 1);
	}
	
	@Override
	public void setColor(Color color) {
		this.c = color;
		displayC = c;
		update();
	}
	
	@Override
	public void setAction(Action action) {
		this.acts = action;
		
	}
	
	@Override
	public void act() {
		acts.act();

	}

	@Override
	public void highlight() {
		if(c != null){
			displayC = c;
		}
		update();
	}
	
	@Override
	public void dim() {
		displayC = Color.gray;
		update();
		
	}

	
	
	
	@Override
	public void setX(int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setY(int i) {
		// TODO Auto-generated method stub

	}
}
