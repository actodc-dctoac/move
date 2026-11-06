void main() {
    //Setting up board, player position, and current player action
    String[] row0 = {"⬛", "⬜", "⬜", "⬜"};
    String[] row1 = {"⬜", "⬜", "⬜", "⬜"};
    String[] row2 = {"⬜", "⬜", "⬜", "⬜"};
    String[] row3 = {"⬜", "⬜", "⬜", "⬜"};
    String[][] board = {row0, row1, row2, row3};

    int[] playerCord = new int[] {0, 0}; //x, y
    //TODO: Randomly initiate enemy and coin position

    play("", board, playerCord);
}

public void play(String act, String[][] box, int[] pos) {
    while (!act.equals("x") && !act.equals("X")) {
        showBoard(box);
        IO.println("WASD to move, X to exit!");
        act = IO.readln().toUpperCase();
        switch (act) {
            case "W" -> posSwap(box, Direction.UP, pos);
            case "S" -> posSwap(box, Direction.DOWN, pos);
            case "A" -> posSwap(box, Direction.LEFT, pos);
            case "D" -> posSwap(box, Direction.RIGHT, pos);
            case "X" -> IO.println("See ya!");
            default -> IO.println("Not In Input List...");
        }
    }
}

public enum Direction {
    LEFT, RIGHT, UP, DOWN
}

public void showBoard(String[][] box) {

    for (String[] row : box) {
        for (String block : row) {
            IO.print(block);
        }
        //TODO: Display Score
        IO.println("");
    }
}

public void posSwap(String[][] arr, Direction direct, int[] pos) {
    switch (direct) {
        case UP -> {
            if (pos[0] == 0) {return;}
            pos[0]--;
            arr[pos[0] + 1][pos[1]] = "⬜";
        }
        case DOWN -> {
            if (pos[0] == arr.length - 1) {return;}
            pos[0]++;
            arr[pos[0] - 1][pos[1]] = "⬜";
        }
        case LEFT -> {
            if (pos[1] == 0) {return;}
            pos[1]--;
            arr[pos[0]][pos[1] + 1] = "⬜";
        }
        case RIGHT -> {
            if (pos[1] == arr.length - 1) {return;}
            pos[1]++;
            arr[pos[0]][pos[1] - 1] = "⬜";
        }
    }
    arr[pos[0]][pos[1]] = "⬛";
    //TODO: Check for coin and enemy overlap
    //TODO: Move enemy 1 square randomly if no enemy overlap
    //TODO: Add 1 to score if coin overlap and generate new randomly placed coin in unoccupied position
	
}
