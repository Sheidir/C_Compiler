/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccompiler.lexer;

import edu.svu.csc326.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.Iterator;

/**
 *
 * @author daugh
 */
public class Lexer implements Iterable{
    String filename;
    
    ArrayList<Token> tokens = new ArrayList();
    ArrayList<Token> temp = new ArrayList();
    public Lexer(String filename){
    if(!filename.endsWith(".c")){
    filename += ".c";
    }
    try{
    FileReader rfile = new FileReader(filename);
    BufferedReader rReader = new BufferedReader(rfile);
    Tokenizer tk = new Tokenizer();
    tokens = readLines(tk, rReader);
    }catch(FileNotFoundException ex){
    System.out.println("File not found at " + filename);
    exit(0);
    }
        
    }
    

    @Override
    public Iterator<Token> iterator() {
        return (new Iterator<Token>() {
            private int next = 0;

            @Override
            public boolean hasNext() {
                return next < tokens.getLength();

            }

            @Override
            public Token next() {
                return tokens.retrieve(next++);

            }

        });
    
    }

    private ArrayList<Token> readLines(Tokenizer tk, BufferedReader rReader) {
        String st = "";
        try{
       
       st = rReader.readLine();
           }catch(IOException ex){
           
           
           }
        
       while(st != null){
           temp = (tk.separate(st));
           tokens = combineArrays(tokens, temp);
           
       }
    
    return tokens;
    }
    public ArrayList<Token> combineArrays(ArrayList one, ArrayList two){
    for(int i = 0; i < two.getLength(); i++){
    one.append(two.retrieve(i));
    
    }
    return one;
    }
    
    
}
