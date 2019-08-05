import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameLogic extends JFrame implements ActionListener {
	private int count;
	private boolean[] found;
	private GameCard[] cards;
	
	public GameLogic() {
		count = 0;
		found = new boolean[21];
		cards = new GameCard[10*10];
		
		setLayout(new GridLayout(10,10));
		for(int i=0; i<10*10; i++) {
			cards[i] = new GameCard();
			cards[i].addActionListener(this);
			add(cards[i]);
		}
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!(e.getSource() instanceof GameCard) || ((GameCard) e.getSource()).getWasClicked()) {
			return;
		}
		GameCard card = (GameCard) e.getSource();
		card.click();
		count++;
		if(found[card.getNum()]==true) {
			JOptionPane.showMessageDialog(this, "You've found a pair after " + count + " tries");
			StartNewGame();
		}
		else {
			found[card.getNum()] = true;
		}
	}

	private void StartNewGame() {
		count = 0;
		for(int i=0; i<found.length; i++)
			found[i] = false;
		for(int i=0; i<cards.length; i++)
			cards[i].restart();
		
	}
	
	
}
