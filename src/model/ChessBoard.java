package model;

public class ChessBoard {
    private ChessPiece[][] board;

    public ChessBoard() {
        board = new ChessPiece[8][8];
        setupBoard();
    }

    private void setupBoard() {
        String[] colors = {"black", "white"};

        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("black");
            board[6][i] = new Pawn("white");
        }

        int[] majorPiecePositions = {0, 7};

        for (int i : majorPiecePositions) {
            String color = colors[i / 7];

            board[i][0] = new Rook(color);
            board[i][7] = new Rook(color);
            board[i][1] = new Knight(color);
            board[i][6] = new Knight(color);
            board[i][2] = new Bishop(color);
            board[i][5] = new Bishop(color);
            board[i][3] = new Queen(color);
            board[i][4] = new King(color);
        }
    }

    public ChessPiece[][] getBoard() {
        return board;
    }

    public ChessPiece getPiece(int x, int y) {
        return board[x][y];
    }

    public void movePiece(int startX, int startY, int endX, int endY) {
        board[endX][endY] = board[startX][startY];
        board[startX][startY] = null;
    }
}
