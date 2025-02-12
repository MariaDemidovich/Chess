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

    public boolean isKingInCheck(String color) {
        String kingColor = color.equals("white") ? "Білому" : "Чорному";
        String kingColor2 = color.equals("white") ? "Білий" : "Чорний";
        int kingX = -1, kingY = -1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board[i][j];
                if (piece instanceof King && piece.getColor().equals(color)) {
                    kingX = i;
                    kingY = j;
                }
            }
        }

        if (kingX == -1) {
            System.out.println("Помилка! " + kingColor2 + " король не знайден.");
            return false;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board[i][j];
                if (piece != null && !piece.getColor().equals(color)) {
                    if (piece.isValidMove(i, j, kingX, kingY, board)) {
                        System.out.println(kingColor + " королю шах від " + piece.getClass().getSimpleName() + " на " + i + "," + j);
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public boolean isCheckmate(String color) {
        boolean checker = !isKingInCheck(color);
        if (checker) return false;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board[i][j];
                if (piece != null && piece.getColor().equals(color)) {
                    for (int x = 0; x < 8; x++) {
                        for (int y = 0; y < 8; y++) {
                            if (piece.isValidMove(i, j, x, y, board)) {

                                ChessPiece captured = board[x][y];
                                movePiece(i, j, x, y);

                                board[i][j] = piece;
                                board[x][y] = captured;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}