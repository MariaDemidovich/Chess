package view;

import model.ChessBoard;
import model.ChessPiece;

public class ChessView {
    public void displayBoard(ChessBoard board) {
        System.out.println("   A  B  C  D  E  F  G  H");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board.getBoard()[i][j];
                System.out.print((i + j) % 2 == 0 ? "\033[30;47m" : "\033[37;40m");
                System.out.print(" " + (piece != null ? piece : " ") + " ");
            }
            System.out.println("\033[0m");
        }
    }
}
