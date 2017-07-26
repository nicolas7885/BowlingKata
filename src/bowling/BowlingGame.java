package bowling;

import java.util.ArrayList;
import java.util.Iterator;

public class BowlingGame {
	ArrayList<Frame> frames= new ArrayList<Frame>();
	Iterator<Frame> frameIt;
	Frame currentFrame;
	
	public BowlingGame(){
		currentFrame=new LastFrame();
		frames.add(currentFrame);
		for(int i=1; i<10; i++){
			currentFrame= new Frame(currentFrame);
			frames.add(0, currentFrame);
		}
		frameIt=frames.iterator();
		currentFrame=frameIt.next();
	}

	public void roll(int pins) {
		currentFrame.roll(pins);
		if( currentFrame.finished() && frameIt.hasNext())
			currentFrame=frameIt.next();		
	}

	public int score() {
		if(!finished())
			return -1;
		int score=0;
		for(Frame frame: frames)
			score+=frame.score();
		return score;
	}

	public boolean finished() {
		return frames.get(frames.size()-1).finished();
	}
	
	

}
