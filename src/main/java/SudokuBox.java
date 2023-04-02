import java.util.List;

public class SudokuBox extends SudokuElement {
    private List<List<SudokuField>> box;

    public SudokuBox(List<List<SudokuField>> box) {
        this.box = box;
    }

    boolean isValid() {
        boolean[] visited = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (box.get(i).get(j).getFieldValue() != 0) {
                    if (visited[box.get(i).get(j).getFieldValue()]) {
                        // if the number has already been visited, then the board is invalid
                        return false;
                    } else {
                        visited[box.get(i).get(j).getFieldValue()] = true;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(box.get(i).get(j).getFieldValue() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}