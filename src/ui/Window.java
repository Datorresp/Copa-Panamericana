/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.IOException;
import java.util.Scanner;


import model.*;

/**
 *
 * @author diegoa.torres
 */
public class Window {
    
    private Scanner reader;
    private Event e;
    
    public Window(){
        
        reader = new Scanner(System.in);        
    }
    
    public void controller() throws IOException, CsvException, DoesntExistException{
        
        int userInput = reader.nextInt();
        boolean exit = false;
        
        while (!exit) {
            
            switch (userInput) {
                case 1:
                    
                    loadPeople();
                    
                    break;
                    
                case 2:
                    
                    searchPeople();
                    
                    break;
                    
                case 3:
                    
                    delatePeople();
                    
                    break;
                    
                default:
                    throw new AssertionError();
            }
        }        
    }

    private void loadPeople() throws IOException, CsvException {
        
        System.out.println("Cargar archivo csv: " + '\n');
        System.out.println("Digite la ruta del archivo: " + '\n');
        System.out.println("Ejemplo: " + '\n' + "/Users/diegoa.torres/NetBeansProjects/LecturaDeArchivos/prueba.csv");
        
        String csv = reader.nextLine();
        e.loadTextFile(csv);
    }
    
    private  void searchPeople() throws DoesntExistException{
        
        
        System.out.println("Modulo de buscar: " + '\n');
        System.out.println("Digite el id de la persona a buscar:  " + '\n');
        
        String id = reader.nextLine();
        
        System.out.println(e.searchViewerNormal(id, e.getRoot()));
    }
    
    private void delatePeople() throws DoesntExistException{
        
        System.out.println("Modulo Eliminar espectadores: " + '\n');
        System.out.println("Digite el id de la persona a eliminar: " + '\n');
        
        String id = reader.nextLine();
        
        e.delateViewer(id, e.getRoot());
    }
    
}
