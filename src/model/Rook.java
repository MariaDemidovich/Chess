package model;

public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessPiece[][] board) {
        return (startX == endX || startY == endY);
    }

    @Override
    public String toString() {
        return color.equals("white") ? "♖" : "♜";
    }
}
