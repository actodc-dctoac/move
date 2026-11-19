import java.util.Random;
import java.util.Arrays;
import java.util.HashSet;
void main() {
    //Setting up board, player position, and current player action
    String[] row0 = {"⬛", "⬜", "⬜", "⬜"};
    String[] row1 = {"⬜", "⬜", "⬜", "⬜"};
    String[] row2 = {"⬜", "⬜", "⬜", "⬜"};
    String[] row3 = {"⬜", "⬜", "⬜", "⬜"};
    String[][] board = {row0, row1, row2, row3};
    HashSet<int[]> invalidPositions = new HashSet<>();

    player player = new player(0, 0);
    //TODO: Randomly initiate enemy and coin position, probably without having the player, the enemy, and/or coin
    // position overlap.

    play("", board, player, invalidPositions);
}

public boolean play(String act, String[][] board, player player, HashSet<int[]> invalidPositions) {
    while (true) {
        showBoard(board, player);
        IO.println("WASD to move, X to exit!");
        act = IO.readln().toUpperCase();
        switch (act) {
            board[player.getXPosition()][player.getYPosition()] = "⬜"; // Clear previous position
            case "W" -> player.swap([player.getXPosition() - 1, player.getYPosition()], invalidPositions);
            case "S" -> player.swap([player.getXPosition() + 1, player.getYPosition()], invalidPositions);
            case "A" -> player.swap([player.getXPosition(), player.getYPosition() - 1], invalidPositions);
            case "D" -> player.swap([player.getXPosition(), player.getYPosition() + 1], invalidPositions);
            case "X" -> IO.println("See Ya!"); return false;
            default -> IO.println("Not In Input List...");
        }
        renderBoard(board, player);
    }
}

public void showBoard(String[][] box, player player) {

    for (String[] row : box) {
        for (String block : row) {
            IO.print(block);
        }
        //TODO: Display Score. Might want to make a player object that keeps track of their position and score.
        IO.println("Score: " + player.getScore());
    }
}

public void renderBoard(String [][] board, player player) {
    board[player.getXPosition()][player.getYPosition()] = "⬛";


    //TODO: Check for coin and enemy overlap
    //TODO: Move enemy 1 square randomly if no enemy overlap
    //TODO: Add 1 to score if coin overlap and generate new randomly placed coin in unoccupied position
	
}
