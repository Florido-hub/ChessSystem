package chess;

import boardgame.Position;

public class ChessPosition {
    private char coluna;
    private int linha;

    public ChessPosition(char coluna, int linha) {
        if(coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8){
            throw new ChessException("Valores validos de a1 ate h8.");
        }
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public char getColuna() {
        return coluna;
    }

    protected Position toPosition(){
        return new Position(8-linha,coluna - 'a');
    }

    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char) ('a' + position.getColuna()), 8 - position.getLinha());
    }

    @Override
    public String toString() {
        return "" + coluna + linha;
    }
}
