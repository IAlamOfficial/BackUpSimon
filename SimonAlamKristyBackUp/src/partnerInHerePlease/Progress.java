package partnerInHerePlease;

import java.awt.Color;
import java.awt.Graphics2D;

import gui.components.Component;
import simonAlam.ProgressInterfaceAlam;

public class Progress extends Component implements ProgressInterfaceAlam {
	
	private String rnd;
	private String seq;
	private boolean gameOver;
	private static final int W = 150;
	private static final int H = 75;

	
	public Progress() {
		super(25, 25, W, H);
	}

	@Override
	public void setSequence(int x) {
		seq = "Sequence: " + x;
		update();

	}

	@Override
	public void setRoundNumber(int roundNumber) {
		rnd = "Round #" + roundNumber;
		update();

	}

	@Override
	public void update(Graphics2D g) {
		if(gameOver){
			g.setColor(Color.red);
			g.fillRect(0, 0, W, H);
			g.setColor(Color.white);
			g.drawString("Good Game!", (W - 50)/2 , 20);
			g.drawString(seq, (W - 50)/2, 40);
		}
		else{
			g.setColor(Color.CYAN);
			g.fillRect(0, 0, W, H);
			g.setColor(Color.white);
			g.drawRect(0, 0, W - 1, H - 1);
			if(rnd !=null && seq != null){
				g.drawString(rnd, (W - 50)/2, 20);
				g.drawString(seq, (W - 50)/2, 40);
			}

		}

	}

	@Override
	public void gameOver() {
		gameOver = true;
		update();	
	}

}
