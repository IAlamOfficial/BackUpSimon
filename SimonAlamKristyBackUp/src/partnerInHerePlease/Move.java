package partnerInHerePlease;

import simonAlam.ButtonInterfaceAlam;
import simonAlam.MoveInterfaceAlam;

public class Move implements MoveInterfaceAlam {
	private ButtonInterfaceAlam b; 
	
	public Move(ButtonInterfaceAlam b) {
		this.b = b;
	}

	public ButtonInterfaceAlam getButton() {
		return b;
	}


	
}
