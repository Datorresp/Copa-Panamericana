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
        init();
        
    }
    
    public void controller() throws IOException, CsvException, DoesntExistException{
        
        System.out.println("1. Cargar Archivo");
        System.out.println("2. Buscar Espectador");
        System.out.println("3. Borrar Espectador");
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
                    
                case 4:
                    
                    toStrings();
                
                    break;
                    
                default:
                    
                    exit = true;
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
        
        try {
            
            System.out.println("Modulo de buscar: " + '\n');
            System.out.println("Digite el id de la persona a buscar:  " + '\n');

            String id = reader.nextLine();

            System.out.println(e.searchViewerNormal(id, e.getRoot()));
            
        } catch (IndexOutOfBoundsException e) {
            
                        
            System.out.println("Modulo de buscar: " + '\n');
            System.out.println("Digite el id de la persona a buscar:  " + '\n');
            System.out.println("El valor digitado no corresponde:");         
            reader.nextLine();

        }
    }
    
    private void delatePeople() throws DoesntExistException{
        
        try{
            
            
            System.out.println("Modulo Eliminar espectadores: " + '\n');
            System.out.println("Digite el id de la persona a eliminar: " + '\n');

            String id = reader.nextLine();

            e.delateViewer(id, e.getRoot());
        }catch (IndexOutOfBoundsException e) {
            
                        
            System.out.println("Modulo de buscar: " + '\n');
            System.out.println("Digite el id de la persona a buscar:  " + '\n');
            System.out.println("El valor digitado no corresponde:");         
            reader.nextLine();

        }catch (DoesntExistException e){
            
                        
            System.out.println("Modulo de buscar: " + '\n');
            System.out.println("Digite el id de la persona a buscar:  " + '\n');
            System.out.println("El expectador no existe ");
            reader.nextLine();
        }
    }   
    
    public void toStrings(){
         
        e.toString();
    } 
    
    public void addEvent(Event e){
        
        e = new Event("Copa");
    }
    
    public void init(){
        
        e=new Event("Copa");
        
    }
}
