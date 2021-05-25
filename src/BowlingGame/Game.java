package BowlingGame;

public class Game {

	private int rolls[] = new int[21];
	private int currentRoll = 0;

	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	public int score() {
		int score = 0;
		int firstInFrame = 0;
		for (int frame = 0; frame < 10; frame++) {
			if (isStrike(rolls[firstInFrame])) {
				score += 10 + nextTwoBallsForStrike(firstInFrame);
				firstInFrame++;
			} else 	if (isSpare(firstInFrame)) {
				score += 10 + nextBallForSpare(firstInFrame);
				firstInFrame += 2;
			} else {
				score += twoBallsInFrame(firstInFrame, firstInFrame + 1);
				firstInFrame += 2;
			}
		}
		return score;
	}

	private int twoBallsInFrame(int firstInFrame, int i) {
		return rolls[firstInFrame] + rolls[i];
	}

	private int nextBallForSpare(int firstInFrame) {
		return rolls[firstInFrame+2];
	}

	private int nextTwoBallsForStrike(int firstInFrame) {
		return rolls[firstInFrame + 1] + rolls[firstInFrame + 2];
	}

	private boolean isStrike(int roll) {
		return roll == 10;
	}

	private boolean isSpare(int firstInFrame) {
		return rolls[firstInFrame] + rolls[firstInFrame + 1] == 10;
	}
}
