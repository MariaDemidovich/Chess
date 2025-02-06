package model;

public abstract class ChessPiece {
    protected String color;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract boolean isValidMove(int startX, int startY, int endX, int endY, ChessPiece[][] board);

    @Override
    public abstract String toString();
}
