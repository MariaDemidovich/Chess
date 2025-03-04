package model;

public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessPiece[][] board) {
        return (startX == endX || startY == endY) || (Math.abs(startX - endX) == Math.abs(startY - endY));
    }

    @Override
    public String toString() {
        return color.equals("white") ? "q" : "q";
    }
}
