package model;

public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessPiece[][] board) {
        int direction = color.equals("white") ? -1 : 1;

        if (startY == endY && board[endX][endY] == null) {
            if (startX + direction == endX) return true;
            if (startX + 2 * direction == endX && (startX == 6 || startX == 1)) return true;
        }

        if (Math.abs(startY - endY) == 1 && startX + direction == endX && board[endX][endY] != null) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return color.equals("white") ? "p" : "p";
    }
}
