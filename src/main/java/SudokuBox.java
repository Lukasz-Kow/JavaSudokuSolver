public class SudokuBox {
    private SudokuField[][] box;

    public SudokuBox() {
        box = new SudokuField[3][3];
        for (int i = 0; i < 3; i++) {
            box[i][0] = new SudokuField(0);
            box[i][1] = new SudokuField(0);
            box[i][2] = new SudokuField(0);
        }
    }

    public boolean isValid() {
        boolean[] visited = new boolean[10];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(box[i][j].getFieldValue() != 0) {
                    if(visited[box[i][j].getFieldValue()]) {
                        // if the number has already been visited, then the board is invalid
                        return false;
                    } else {
                        visited[box[i][j].getFieldValue()] = true;
                    }
                }
            }
        }
        return true;
    }
}