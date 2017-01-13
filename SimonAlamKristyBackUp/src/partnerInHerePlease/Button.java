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

//public class Button extends Component implements ButtonInterfaceAlam {
//	
//	private Color color;
//	private Color displayColor;
//	private boolean highlight;
//	private Action action;
//	private static final int W = 10;
//	private static final int H = 10;
//	private static int button = 1;
//	
//	public Button() {
//		super(10 * button, 0, W, H);
//	button ++;
//	}
//
//	@Override
//	public void act() {
//		action.act();
//
//	}
//
//	@Override
//	public boolean isHovered(int x, int y) {
//		double distance = Math.sqrt(Math.pow(x-(getX()+W/2), 2)+Math.pow(y-(getY()+H/2), 2));	
//		return distance < W/2;
//	}
//
//	
//	@Override
//	public void update(Graphics2D g) {
//		if(displayColor != null){
//			g.setColor(displayColor);
//		}else{
//			g.setColor(Color.gray);
//		}
//		g.fillOval(0, 0, W, H);
//		g.setColor(Color.black);
//		g.drawOval(0, 0, W-1, H-1);
//		if(highlight){
//			g.setColor(Color.red);
//			Polygon p = new Polygon();
//			
//			int s = (int)(5/8.0 * W);
//			int t = (int)(1.0/5*H)+4;
//			p.addPoint(s-4, t-4);
//			p.addPoint(s+7, t-2);
//			p.addPoint(s+10, t);
//			p.addPoint(s+14, t+10);
//			p.addPoint(s+12, t+14);
//			p.addPoint(s+8, t+3);
//			g.fill(p);
//		}
//	}
//	@Override
//	public void setColor(Color c) {
//		this.color = c;
//		displayColor = color;
//		update();
//	}
//
//	@Override
//	public void setAction(Action action) {
//		this.action = action;
//	}
//
//	@Override
//	public void highlight() {
//		if(color != null){
//			displayColor = color;
//		}
//		highlight = true;
//		update();
//	}
//
//	
//
//	@Override
//	public void dim() {
//		displayColor = Color.black;
//		highlight = false;
//		update();
//	}
//	
//	
//	@Override
//	public void setX(int i) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void setY(int i) {
//		// TODO Auto-generated method stub
//
//	}
//	private String name;
//	public void setName(String s){
//		this.name = s;
//	}
//	
//	public String toString(){
//		return name;
//	}
//	
//	@Override
//	public int getHeight() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public BufferedImage getImage() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int getWidth() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int getX() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int getY() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public boolean isAnimated() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//}
