void main() {
    //Setting up board, player position, and current player action
    String[] row0 = {"⬛", "⬜", "⬜", "⬜"};
    String[] row1 = {"⬜", "⬜", "⬜", "⬜"};
    String[] row2 = {"⬜", "⬜", "⬜", "⬜"};
    String[] row3 = {"⬜", "⬜", "⬜", "⬜"};
    String[][] board = {row0, row1, row2, row3};

    int[] playerCord = new int[] {0, 0}; //x, y
    //TODO: Randomly initiate enemy and coin position

    String action = "p";
    play(action, board, playerCord);
}

public void play(String act, String[][] box, int[] pos) {
    while (!act.equals("x") && !act.equals("X")) {
        showBoard(box);
        IO.println("WASD to move, X to exit!");
        act = IO.readln();
        switch (act.toUpperCase()) {
            case "W", "S" -> {
                if (act.equals("w") || act.equals("W")) {
                    posSwap(box, Direction.UP, pos);
                }
                else {
                    posSwap(box, Direction.DOWN, pos);
                }
            }
            case "A", "D" -> {
                if (act.equals("a") || act.equals("A")) {
                    posSwap(box, Direction.LEFT, pos);
                }
                else {
                    posSwap(box, Direction.RIGHT, pos);
                }
            }
            case "X" -> {IO.println("See ya!"); return;}
            default -> {IO.println("Not In Input List...");}

        }
    }
    return;
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
        case Direction.UP -> {
            if (pos[0] == 0) {return;}
            int temp = pos[0];
            pos[0]--;
            arr[pos[0]][pos[1]] = "⬛";
            arr[temp][pos[1]] = "⬜";
        }
        case Direction.DOWN -> {
            if (pos[0] == 3) {return;}
            int temp = pos[0];
            pos[0]++;
            arr[pos[0]][pos[1]] = "⬛";
            arr[temp][pos[1]] = "⬜";
        }
        case Direction.LEFT -> {
            if (pos[1] == 0) {return;}
            int temp = pos[1];
            pos[1]--;
            arr[pos[0]][pos[1]] = "⬛";
            arr[pos[0]][temp] = "⬜";
        }
        case Direction.RIGHT -> {
            if (pos[1] == 3) {return;}
            int temp = pos[1];
            pos[1]++;
            arr[pos[0]][pos[1]] = "⬛";
            arr[pos[0]][temp] = "⬜";
        }
    }
    //TODO: Check for coin and enemy overlap
    //TODO: Move enemy 1 square randomly if no enemy overlap
    //TODO: Add 1 to score if coin overlap and generate new randomly placed coin in unoccupied position
    return;

}
