package bowling;

public class LastFrame extends Frame {

	int thirdRoll;

	public LastFrame(){
		super(null);
	}

	@Override
	public void roll(int pins) {
		if( (firstRoll+secondRoll < 10) && (rollNumber < 3) ){
			super.roll(pins);
			return;
		}
		
		if(!this.finished()){
			switch(rollNumber){
			case 2:
				secondRoll=pins;
				break;
			case 3:
				thirdRoll=pins;
				break;
			default:
			}
			
			rollNumber++;
		}

	}

	@Override	
	public int score() {
		return firstRoll+secondRoll+thirdRoll;
	}

	@Override
	protected int getSecond() {
		return this.secondRoll;
	}

	@Override
	public boolean finished() {
		if(firstRoll+secondRoll >= 10){
			return rollNumber > 3;
		}else{
			return super.finished();
		}
	}

}
