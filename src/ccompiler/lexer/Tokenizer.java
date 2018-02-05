/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccompiler.lexer;

import edu.svu.csc326.ArrayList;

/**
 *
 * @author daugh
 */
public class Tokenizer {
    String st;
    ArrayList<Token> tokens;
    int row = 0;
    String operators = "+-*/=><&|";
    public Tokenizer(){
        this("");
    }
    
    public Tokenizer(String st){
    tokens = new ArrayList();
    this.st = st;
    }

    private String handleState(STATE state, STATE newState, String temp, int i) {
        while (state != STATE.NONE){
        char c = st.charAt(i);
        newState = evaluate(c);
        if(state == STATE.STRING || state == STATE.CHAR){
        temp = handleString(state, newState, i, temp);
        }else if(newState == state){
        temp += c;
        }else if(state == STATE.ALPHABETIC && newState == STATE.NUMERIC){
        temp += c;
        newState = STATE.ALPHABETIC;
        }else if(state == STATE.NUMERIC && c == '.'){
        temp +=c;
        newState = STATE.NUMERIC;
        }else{
        newState = STATE.NONE;
        }
        if(i == st.length() -1){
        return temp;
        }
        i++;
        state = newState;

        }
        
        
        return temp;
    }

    private String handleString(STATE state, STATE newState, int i, String temp) {
        char c;
        while(state != newState){
        c = st.charAt(i);
        newState = evaluate(c);
        temp += c;
        state = newState;
        i++;
        
        }
    return temp;
    }
    private enum STATE{
    ALPHABETIC, NUMERIC, STRING, CHAR, OPERATOR, NONE 
    }
    
    public ArrayList separate(String st){
    this.st = st;
    tokens = new ArrayList();
    separate();
    return tokens;
    }
    
    private void separate(){
    char c;
    STATE state = STATE.NONE;
    STATE newState;
    String temp = "";
    for(int i = 0; i < st.length(); i++){
     
     c = st.charAt(i);
    newState = evaluate(c);
    if(state != STATE.NONE){
    temp = handleState(state, newState, temp, i);
    tokens.append(new Token(temp, TokenType.getType(temp), 0, 0));
    i += temp.length() -2;
    temp = "";
    newState = STATE.NONE;
    }
    if(state == STATE.NONE){
    if(Character.isWhitespace(c)){
    i += skipWhiteSpace(i);
    }else{
    temp += c;
    if(newState == STATE.NONE){
    tokens.append(new Token(temp, TokenType.getType(temp), 0, 0));
    temp = "";
    }
    }
    
    }
       
    state = newState;
    }
    
    }
    private STATE evaluate(char c){
    if(Character.isAlphabetic(c)){
    return STATE.ALPHABETIC;
    }if(Character.isDigit(c)){
    return STATE.NUMERIC;
    }if(c == '\''){
    return STATE.CHAR;
    }if(c == '\"'){
    return STATE.STRING;
    }if(operators.indexOf(c) > -1){
    return STATE.OPERATOR;
    }
    
    return STATE.NONE;
    }
    private int skipWhiteSpace(int i){
    int numWhiteSpaces = 0;
    char c = st.charAt(i);
    while(Character.isWhitespace(c)){
    c = st.charAt(i);
    numWhiteSpaces++;
    i++;
    }
    return numWhiteSpaces -2;
    }
}
