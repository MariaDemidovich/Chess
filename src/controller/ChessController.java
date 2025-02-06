package controller;

import model.ChessBoard;
import model.ChessPiece;
import view.ChessView;

import java.util.Scanner;

public class ChessController {
    private ChessBoard board;
    private ChessView view;
    private boolean isWhiteTurn;

    public ChessController() {
        board = new ChessBoard();
        view = new ChessView();
        isWhiteTurn = true;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            view.displayBoard(board);
            System.out.println((isWhiteTurn ?
                    "Белые" : "Чёрные") +
                    ", введите ход (например, e2 e4), или 'exit' для выхода: ");
            String move = scanner.nextLine();
            if (move.equalsIgnoreCase("exit")) break;
            if (processMove(move)) {
                isWhiteTurn = !isWhiteTurn;
            } else {
                System.out.println("Недопустимый ход!");
            }
        }
    }

    private boolean processMove(String move) {
        if (!move.matches("^[a-h][1-8] [a-h][1-8]$")) return false;

        String[] parts = move.split(" ");
        int startX = 8 - Character.getNumericValue(parts[0].charAt(1));
        int startY = parts[0].charAt(0) - 'a';
        int endX = 8 - Character.getNumericValue(parts[1].charAt(1));
        int endY = parts[1].charAt(0) - 'a';

        ChessPiece piece = board.getPiece(startX, startY);
        if (piece == null || (isWhiteTurn && !piece.getColor().equals("white")) || (!isWhiteTurn && !piece.getColor().equals("black"))) {
            return false;
        }

        if (piece.isValidMove(startX, startY, endX, endY, board.getBoard())) {
            board.movePiece(startX, startY, endX, endY);
            return true;
        }

        return false;
    }
}
