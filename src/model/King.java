package model;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessPiece[][] board) {
        return Math.abs(startX - endX) <= 1 && Math.abs(startY - endY) <= 1;
    }

    @Override
    public String toString() {
        return color.equals("white") ? "♔" : "♚";
    }
}
