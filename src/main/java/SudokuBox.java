public class SudokuBox {
    private SudokuField[][] box;

    public SudokuBox(SudokuField[][] box) {
        this.box = box;

    }

    public boolean isValid() {
        boolean[] visited = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (box[i][j].getFieldValue() != 0) {
                    if (visited[box[i][j].getFieldValue()]) {
                        // if the number has already been visited, then the board is invalid
                        return false;
                    } else {
                        visited[box[i][j].getFieldValue()] = true;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBox() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(box[i][j].getFieldValue() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}