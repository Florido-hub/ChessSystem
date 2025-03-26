package boardgame;

import chess.ChessPiece;

public class Board {
    private int linhas;
    private int colunas;
    private Piece[][] pieces;

    public Board(int linhas, int colunas) {
        if(linhas < 1 || colunas < 1){
            throw new BoardException("ERRO NA CRIAÇÃO DO TABULEIRO!");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pieces = new Piece[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public Piece piece(int linha, int coluna){
        if(!positionExists(linha,coluna)){
            throw new BoardException("essa posicao n existe!");
        }
        return pieces[linha][coluna];
    }

    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("essa posicao n existe!");
        }
        return pieces[position.getLinha()][position.getColuna()];
    }

    public void PlacePiece(Piece piece, Position position){
        if(thereIsAPiace(position)){
            throw new BoardException(" ");
        }
        pieces[position.getLinha()][position.getColuna()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int l, int c){
        return l >= 0 && l < linhas  &&  c >= 0 && c< colunas;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getLinha(), position.getColuna());
    }

    public boolean thereIsAPiace(Position position){
        if(!positionExists(position)){
            throw new BoardException("essa posicao n existe!");
        }
        return piece(position) != null;
    }
}
