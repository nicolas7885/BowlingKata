package bowling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FrameTest {
	LastFrame next= new LastFrame();

	@Test
	public void roll4Gets4OfScore() {
		Frame frame=new Frame(next);
		frame.roll(4);
		assertEquals(frame.score(),4);
	}
	
	@Test
	public void cantRollAfterFinished() {
		Frame frame=new Frame(next);
		frame.roll(4);
		frame.roll(4);
		frame.roll(4);
		assertEquals(frame.score(),8);
	}
	
	@Test
	public void roll0Gets0OfScore() {
		Frame frame=new Frame(next);
		frame.roll(0);
		assertEquals(frame.score(),0);
	}
	
	@Test
	public void roll10Gets10OfScore() {
		Frame frame=new Frame(next);
		frame.roll(10);
		assertEquals(frame.score(),10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cantRollMoreThan10() {
		Frame frame=new Frame(next);
		frame.roll(11);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cantRollLessThan0() {
		Frame frame=new Frame(next);
		frame.roll(-1);
	}
	
	@Test
	public void roll2FoursGets8OfScore() {
		Frame frame=new Frame(next);
		frame.roll(4);
		frame.roll(4);
		assertEquals(frame.score(),8);
	}
	
	@Test
	public void afterTwoRollsFrameIsFinished() {
		Frame frame=new Frame(next);
		frame.roll(4);
		frame.roll(4);
		assertTrue(frame.finished());
	}
	
	@Test
	public void afterStrikeIsFinished() {
		Frame frame=new Frame(next);
		frame.roll(10);
		assertTrue(frame.finished());
	}
	
	@Test
	public void afterOneRollFrameIsNotFinished() {
		Frame frame=new Frame(next);
		assertFalse(frame.finished());
		frame.roll(1);
		assertFalse(frame.finished());
	}

	@Test
	public void splitDependsOnNextFrame() {
		LastFrame nextFrame= new LastFrame();
		Frame frame=new Frame(nextFrame);
		frame.roll(1);
		frame.roll(9);
		nextFrame.roll(8);
		assertEquals(frame.score(),18);
	}
	
	@Test
	public void strikeDependsOnNextTwoShotsNonStrike() {
		LastFrame lastFrame= new LastFrame();
		Frame frame=new Frame(lastFrame);
		frame.roll(10);
		lastFrame.roll(8);
		lastFrame.roll(1);
		assertEquals(frame.score(),19);
	}
	
	@Test
	public void strikeDependsOnNextTwoShotsWithAStrike() {
		LastFrame lastFrame= new LastFrame();
		Frame secondFrame=new Frame(lastFrame);
		Frame frame=new Frame(secondFrame);
		frame.roll(10);
		secondFrame.roll(10);
		lastFrame.roll(8);
		assertEquals(frame.score(),28);
	}
	
	@Test
	public void strikeDependsOnNextTwoShotsWithtwoStrike() {
		LastFrame lastFrame= new LastFrame();
		Frame secondFrame=new Frame(lastFrame);
		Frame frame=new Frame(secondFrame);
		frame.roll(10);
		secondFrame.roll(10);
		lastFrame.roll(10);
		assertEquals(frame.score(),30);
	}
}
