/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
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
    
    
    private void menu(){
                
        System.out.println("1. Cargar Archivo" + '\n');
        System.out.println("2. Buscar Espectador" + '\n');
        System.out.println("3. Borrar Espectador" + '\n');
        System.out.println("4. Cargar Espectadores individuales" + '\n');
        System.out.println("5. Cargar Archivo competidores" + '\n');
        System.out.println("6. cargar competidor individual" + '\n');
        System.out.println("7. Dibujo arbol" + '\n');
        System.out.println("Digite cualquier otro numero para salir");
        
    }
    public void controller() throws IOException, CsvException, DoesntExistException{
        
        menu();
        int userInput = reader.nextInt();
        boolean exit = false;

        
        while (!exit) {
            
            switch (userInput) {
                case 1:
                    
                    loadPeople();
                    menu();
                    
                    break;
                    
                case 2:
                    
                    searchPeople();
                    menu();
                    
                    break;
                    
                case 3:
                    
                    delatePeople();
                    menu();
                    
                    break;
                
                case 4:
                    
                    addViewer();
                    menu();
                    
                    break;
                
                case 5:
                    
                    loadCompetitor();
                    menu();
                    
                    break;
                    
                case 6:
                    
                    addCometitor();
                    menu();
                    
                    break;
                 
                case 7:
                    
                    three();
                    menu();
                    
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
        
        System.out.println("Digite El simbolo de separacion: " + '\n');
        System.out.println("Ejemplo: " + '\n' + ", o ;");
        
        String sep = reader.nextLine();
        
        e.loadTextFile(csv, sep);
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
    
    public void addEvent(Event e){
        
        e = new Event("Copa");
    }
    
    public void init(){
        
        e=new Event("Copa");
        Viewer v = new Viewer("1", "Diego", "Torr", "LOL", "M", "COlombia", "xd.jpg", "12142001");
        e.setRoot(v);
        
    }
    
    private void loadCompetitor() throws IOException, CsvException {
        
        System.out.println("Cargar archivo csv: " + '\n');
        System.out.println("Digite la ruta del archivo: " + '\n');
        System.out.println("Ejemplo: " + '\n' + "/Users/diegoa.torres/NetBeansProjects/LecturaDeArchivos/prueba.csv");
        
        String csv = reader.nextLine();
        
        System.out.println("Digite El simbolo de separacion: " + '\n');
        System.out.println("Ejemplo: " + '\n' + ", o ;");
        
        String sep = reader.nextLine();
        
        e.loadTextFile(csv, sep);
    } 
    
    private void addViewer() throws FileNotFoundException, IOException{
        
        try{
            System.out.println("Digite el Nombre del espectador: "+'\n');

            String name = reader.nextLine();

            System.out.println("Digite el apellido del espectador: "+'\n');

            String lastName = reader.nextLine();

            System.out.println("Digite el pais del espectador " + '\n');

            String country = reader.nextLine();

            System.out.println("Digite el id " +'\n');

            String id = reader.nextLine();

            System.out.println("Fecha de cumple anios: " + '\n');

            String birthday = reader.nextLine();

            System.out.println("Digite el email: " +'\n');

            String email = reader.nextLine();

            System.out.println("Digite el genero: " + '\n');

            String gender = reader.nextLine();

            System.out.println("Digite la ruta de la foto");

            String path = reader.nextLine();

            File f = new File (path);
            FileReader fr = new  FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            
            Viewer v = new Viewer(id, name, lastName, email, gender, country, path, birthday);
            
            e.addViewrFinal(v);
            
        }catch (FileNotFoundException ex) {
            
            System.out.println("No se encuentra el archivo: " + '\n');
            reader.nextLine();
        }catch (InputMismatchException ex) {
            
            System.out.println("Digito mal digitado: " + '\n');
            reader.nextLine();
        }
    }
    
    private void three(){
        
        System.out.println("Digite el pais para pintar el arbol: ");
        
        String country = reader.nextLine();
        
        e.DrawThree(country);
    }
    
    private void addCometitor() throws IOException, FileNotFoundException{
        
        try{
            System.out.println("Digite el Nombre del espectador: "+'\n');

            String name = reader.nextLine();

            System.out.println("Digite el apellido del espectador: "+'\n');

            String lastName = reader.nextLine();

            System.out.println("Digite el pais del espectador " + '\n');

            String country = reader.nextLine();

            System.out.println("Digite el id " +'\n');

            String id = reader.nextLine();

            System.out.println("Fecha de cumple anios: " + '\n');

            String birthday = reader.nextLine();

            System.out.println("Digite el email: " +'\n');

            String email = reader.nextLine();

            System.out.println("Digite el genero: " + '\n');

            String gender = reader.nextLine();

            System.out.println("Digite la ruta de la foto");

            String path = reader.nextLine();

            File f = new File (path);
            FileReader fr = new  FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            
            Competitor v = new Competitor(id, name, lastName, email, gender, country, path, birthday);
            
            e.addCompetitor(v);
            
        }catch (FileNotFoundException ex) {
            
            System.out.println("No se encuentra el archivo: " + '\n');
            reader.nextLine();
        }catch (InputMismatchException ex) {
            
            System.out.println("Digito mal digitado: " + '\n');
            reader.nextLine();
        }        
    }
}
