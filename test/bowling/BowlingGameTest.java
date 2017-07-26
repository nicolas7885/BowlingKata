package bowling;

import static org.junit.Assert.*;
import bowling.BowlingGame;
import org.junit.Test;

public class BowlingGameTest {

	@Test
	public void rollTwentyFours() {
		BowlingGame game= new BowlingGame();
		while(!game.finished())
			game.roll(4);
		
		assertEquals(20*4,game.score());
	}
	
	@Test
	public void firstSplitThenAll4() {
		BowlingGame game= new BowlingGame();
		game.roll(6);
		game.roll(4);
		while(!game.finished())
			game.roll(4);
		
		assertEquals(10+4 +9*2*4,game.score());
	}

	@Test
	public void firstStrikeThenAll4() {
		BowlingGame game= new BowlingGame();
		game.roll(10);
		while(!game.finished())
			game.roll(4);
		
		assertEquals(10+4+4 +9*2*4,game.score());
	}
	
	@Test
	public void twoStrikesThenAll4() {
		BowlingGame game= new BowlingGame();
		game.roll(10);
		game.roll(10);
		while(!game.finished())
			game.roll(4);
		
		assertEquals(10+10+4 + 10+4+4 +8*2*4,game.score());
	}
	
	@Test
	public void threeStrikesThenAll4() {
		BowlingGame game= new BowlingGame();
		game.roll(10);
		game.roll(10);
		game.roll(10);
		while(!game.finished())
			game.roll(4);
		
		assertEquals(10+10+10+ 10+10+4 + 10+4+4 +7*2*4,game.score());
	}
	
	@Test
	public void all4lastFrameSliptThen4() {
		BowlingGame game= new BowlingGame();
		for(int i=1; i<=(9*2); i++)
			game.roll(4);
		game.roll(4);
		game.roll(6);
		game.roll(4);
		assertEquals(9*2*4+ 4+6+4,game.score());
	}
	
	@Test
	public void perfectGame() {
		BowlingGame game= new BowlingGame();
		while(!game.finished())
			game.roll(10);
		assertEquals(300,game.score());
	}
	
	@Test
	public void perfectZeroGame() {
		BowlingGame game= new BowlingGame();
		while(!game.finished())
			game.roll(0);
		assertEquals(0,game.score());
	}
	
}
