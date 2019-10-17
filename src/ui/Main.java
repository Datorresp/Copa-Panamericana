/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.IOException;
import model.CsvException;
import model.DoesntExistException;
import model.*;

/**
 *
 * @author diegoa.torres
 */
public class Main {

    public Main(){
        
   
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException, CsvException, DoesntExistException {
        
        Window w = new Window();
        w.controller();
        
    }    
}
