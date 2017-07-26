package bowling;

public class Frame {
	int firstRoll=0;
	int secondRoll=0;
	int rollNumber=1;
	boolean strike=false;
	Frame next;
	
	public Frame(Frame nextFrame) {
		next=nextFrame;
	}

	public void roll(int pins) {
		if(pins >10 || pins <0)
			throw new IllegalArgumentException("Invalid pin numbers!");
		
		if(this.finished())
			return;
		
		switch(rollNumber){
		case 1:
			firstRoll=pins;
			if(pins==10)
				strike=true;
			break;
		case 2:
			if(firstRoll+pins >10)
				throw new IllegalArgumentException("Invalid pin numbers!");
			secondRoll=pins;
			break;
		default:
		}
		rollNumber++;
	}

	public int score() {
		if(firstRoll==10)//strike
			return firstRoll+next.firstRoll+next.getSecond();
		if((firstRoll+secondRoll)==10)//split
			return 10+next.firstRoll;
		
		return firstRoll+secondRoll;
	}

	protected int getSecond() {
		if(firstRoll==10)
			return next.firstRoll;
		else
			return this.secondRoll;
	}

	public boolean finished() {
		return (rollNumber > 2) || strike;
	}

}


