void main() {
    //Setting up board, player position, and current player action
    String[] row1 = {"⬛", "⬜", "⬜", "⬜"};
    String[] row2 = {"⬜", "⬜", "⬜", "⬜"};
    String[] row3 = {"⬜", "⬜", "⬜", "⬜"};
    String[] row4 = {"⬜", "⬜", "⬜", "⬜"};
    String[][] board = {row1, row2, row3, row4};
    int[] playerCord = new int[] {0, 0};
    int nextRow = 0;
    int nextCol = 0;

    String action = "p";
    play(action, board, playerCord, nextRow, nextCol);
}

public void play(String act, String[][] box, int[] pos, int nextRow, int nextCol) {
    while (!act.equals("x") && !act.equals("X")) {
        showBoard(box);
        Direction currDirection = Direction.UP;
        IO.println("WASD to move, X to exit!");
        act = IO.readln();
        switch (act.toUpperCase()) {
            case "W", "S" -> {
                if (act.equals("w") || act.equals("W")) {
                    currDirection = Direction.UP;
                    box = posSwap(box, currDirection, nextRow, nextCol);
                }
                else {
                    currDirection = Direction.DOWN;
                    box = posSwap(box, currDirection, nextRow, nextCol);
                }
            }
            case "A", "D" -> {
                if (act.equals("a") || act.equals("A")) {
                    currDirection = Direction.LEFT;
                    box = posSwap(box, currDirection, nextRow, nextCol);
                }
                else {
                    currDirection = Direction.RIGHT;
                    box = posSwap(box, currDirection, nextRow, nextCol);
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
    for (String[] row : box) {IO.println(Arrays.toString(row));}
}

public String[][] posSwap(String[][] arr, Direction direct, int nextRow, int nextCol) {
    switch (direct) {
        case Direction.UP -> {
            if (nextRow == 0) {return arr;}
            int temp = nextRow;
            nextRow--;
            arr[nextRow][nextCol] = "⬛";
            arr[temp][nextCol] = "⬜";
        }
        case Direction.DOWN -> {
            if (nextRow == 3) {return arr;}
            int temp = nextRow;
            nextRow++;
            arr[nextRow][nextCol] = "⬛";
            arr[temp][nextCol] = "⬜";
        }
        case Direction.LEFT -> {
            if (nextRow == 0) {return arr;}
            int temp = nextCol;
            nextCol--;
            arr[nextRow][nextCol] = "⬛";
            arr[nextRow][temp] = "⬜";
        }
        case Direction.RIGHT -> {
            if (nextRow == 3) {return arr;}
            int temp = nextCol;
            nextCol++;
            arr[nextRow][nextCol] = "⬛";
            arr[nextRow][temp] = "⬜";
        }
    }
    return arr;

}