import java.util.*;

public class SudokuBoard {

        private Integer[][] board;
        public SudokuBoard() {
            board = new Integer[9][9];
        }


        public void fillBoard() {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = 0;
                }
            }
            // Fill the board with random numbers
//            for (int i = 0; i < board.length; i++) {
//                for (int j = 0; j < board[i].length; j++) {
//                    if (board[i][j] == 0) {
//                        board[i][j] = random.nextInt(9) + 1;
//                    }
//                }
//            }
        }


        public void PrintBoard(){
            for(int i = 0; i<board.length;i++){
                for(int j = 0; j<board[i].length;j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }

}