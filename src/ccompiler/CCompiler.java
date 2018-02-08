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
import java.util.Iterator;

/**
 *
 * @author daugh
 */
public class CCompiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Lexer l = new Lexer(args[0]);
        Iterator it = l.iterator();
        while(it.hasNext()){
            
        System.out.println(it.next());
        
        }
    }
    
}
