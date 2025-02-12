package model;

public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessPiece[][] board) {
        return Math.abs(startX - endX) == Math.abs(startY - endY);
    }

    @Override
    public String toString() {
        return color.equals("white") ? "b" : "b";
    }
}
