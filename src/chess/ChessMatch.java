package chess;

import boardgame.Board;
import chess.pieces.Rei;
import chess.pieces.Torre;

public class ChessMatch {
    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getLinhas()][ board.getColunas()];
        for(int i=0; i< board.getLinhas(); i++){
            for(int j=0; j< board.getColunas(); j++){
                mat[i][j] = (ChessPiece) board.piece(i,j);
            }
        }
        return mat;
    }

    private void placeNewPiece(char coluna, int linha, ChessPiece piece){
        board.PlacePiece(piece, new ChessPosition(coluna, linha).toPosition());
    }

    private void initialSetup(){

        placeNewPiece('a',8, new Torre(board, Color.BLACK));
        placeNewPiece('h',8,new Torre(board, Color.BLACK));
        placeNewPiece('a', 1, new Torre(board, Color.WHITE));
        placeNewPiece('h', 1, new Torre(board, Color.WHITE));


        placeNewPiece('e',8,new Rei(board, Color.BLACK));
        placeNewPiece('e',1,new Rei(board, Color.WHITE));
    }
}
