package chess;

import boardgame.Board;
import boardgame.Position;
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

    private void initialSetup(){

        board.PlacePiece(new Torre(board, Color.BLACK),new Position(0,0));
        board.PlacePiece(new Torre(board, Color.BLACK),new Position(0,7));
        board.PlacePiece(new Torre(board, Color.WHITE),new Position(7,0));
        board.PlacePiece(new Torre(board, Color.WHITE),new Position(7,7));


        board.PlacePiece(new Rei(board, Color.BLACK), new Position(0,4));
        board.PlacePiece(new Rei(board, Color.WHITE), new Position(7,4));
    }
}
