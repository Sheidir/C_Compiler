/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccompiler;

import ccompiler.lexer.Lexer;
import ccompiler.lexer.Token;
import ccompiler.lexer.Tokenizer;
import edu.svu.csc326.ArrayList;

/**
 *
 * @author daugh
 */
public class CCompiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String current = System.getProperty("user.dir");
        System.out.println(current);
        current += "\\src\\ccompiler\\lexer\\test";
        Lexer l = new Lexer(current);
        ArrayList tokens = new ArrayList();
        for(int i = 0; i < tokens.getLength(); i++){
        System.out.println(tokens.retrieve(i));
        
        }
    }
    
}
