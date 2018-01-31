/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccompiler.lexer;

/**
 *
 * @author daugh
 */
public class Token {
    int col;
    int row;
    String symbol;
    TokenType type;
    
    public Token(String symbol, TokenType type, int col, int row){
    this.col = col;
    this.row = row;
    this.symbol = symbol;
    this.type = type;
    
    
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public String getSymbol() {
        return symbol;
    }

    public TokenType getType() {
        return type;
    }
    
}
