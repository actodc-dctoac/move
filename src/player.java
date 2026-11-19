import java.util.HashSet;
public class player extends entity {
    private int score;

    public player(int xPosition, int yPosition) {
        super(xPosition, yPosition);
        this.score = 0;
    }

    public int getScore() {
        return score;
    }
    public void incrementScore() {
        this.score++;
    }
    public boolean swap(int[] nextPos, HashSet<int[]> invalidPositions) {
        if (invalidPositions.contains(nextPos) || nextPos[0] < 0 || nextPos[1] < 0 || nextPos[0] >= 4 || nextPos[1] >= 4) {
            return false; // Invalid move
        }
        this.xPosition = nextPos[0];
        this.yPosition = nextPos[1];
        return true; // Valid move
    }
}

