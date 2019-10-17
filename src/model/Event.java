/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author diegoa.torres
 */
public class Event {

    private Viewer root;
    private Competitor first;
    private String name;

    public Event(String name) {

        this.name = name;
    }
    
    public Viewer getRoot() {
        return root;
    }

    public void setRoot(Viewer root) {
        this.root = root;
    }

    public Competitor getFirst() {
        return first;
    }

    public void setFirst(Competitor first) {
        this.first = first;
    }
    
    
    
    
    public void addViewer(Viewer v, Viewer roott){
        
        if (roott == null) {
            
            roott = v;
        }else{
            
            if (v.getId().compareTo(roott.getId()) > 0) {
                
                if (roott.getLeft() == null) {
                    
                    roott.setLeft(v);
                }else{
                    
                    addViewer(v, roott.getLeft());
                }
            }else{
                
                if (roott.getRight() == null) {
                    
                    roott.setRight(v);
                }else{
                    
                    addViewer(v, roott.getRight());
                }
            }
        }       
    }
    
    public void addViewrFinal(Viewer v){
        
        addViewer(v, root);
    }

    public void loadTextFile(String csv, String sep)throws IOException, CsvException{


        if (csv != null) {

            File f = new File (csv);
            FileReader fr = new  FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            int i = 0;

            String line = br.readLine();

            while (line != null) {

                System.out.println(line);

                if (line.charAt(0) != '#') {
                        
                    String[] parts = line.split(sep);
                    String id = parts[0];
                    String name = parts[1];
                    String LastName = parts[2];
                    String email = parts[3];
                    String gender = parts[4];
                    String country = parts[5];
                    String photo = parts[6];
                    String birthday = parts[7];
                        
                    Viewer cl = new Viewer(id, name, LastName, email, gender, country, photo, birthday);
                    addViewrFinal(cl);
                        
                    String rutaFichero = "Socio.txt";

                    try{

                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero));
                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaFichero));

                        oos.writeObject(cl);
                        oos.close();

                        Viewer readClient = (Viewer) ois.readObject();
                        ois.close();
                        System.out.println("Persona: " + cl.toString());

                    }catch (IOException ex) {

                        System.out.println(ex.getMessage());
                    }catch (ClassNotFoundException ex) {

                        System.out.println(ex.getMessage());
                    }


                    line = br.readLine();
                   i++; 
                }
            }
        }else{

        throw new CsvException();
        }
    }
    
    public Viewer searchViewerNormal(String id, Viewer roott) throws DoesntExistException{
        
        Viewer toReturn = null;
        
        if (roott != null) {
            
            if (id.compareToIgnoreCase(roott.getId()) > 0) {
                
                if (roott.getLeft() != null) {
                    
                    searchViewerNormal(id, roott.getLeft());                    
                }else{
                
                throw new DoesntExistException();
                }
            }else if (id.compareToIgnoreCase(roott.getId()) < 0) {
                
                 if (roott.getRight() != null) {
                    
                    searchViewerNormal(id, roott.getRight());                    
                } else{
                
                throw new DoesntExistException();
                }              
            }else if (id.compareToIgnoreCase(roott.getId()) == 0) {
                
                toReturn = roott;
            }else{
                
                throw new DoesntExistException();
            }
        }else{
            
            throw new DoesntExistException();
        }
        
        return toReturn;
    }
    
    public Viewer searchVierwerInOrden(String id, Viewer roott){
        
        boolean found = false;
        
        if (!found) {
            
            searchVierwerInOrden(id, roott.getLeft());
            
            if (id.equalsIgnoreCase(roott.getId())) {
                
                found = true;
                roott.toString();
                return roott;
            }

            searchVierwerInOrden(id, roott.getRight());
            
            if (id.equalsIgnoreCase(roott.id)) {
                
                found = true;
                roott.toString();
                return roott;
            }           
        }
        
        return null;
    }
    
    public void delateViewer(String id, Viewer raiz) throws DoesntExistException{
        
        if (raiz != null) {
            
            if (id.compareTo(raiz.getId()) > 0) {
                
                if (raiz.getLeft() != null) {
                    
                    delateViewer(id, raiz.getLeft());
                }
            }else if (id.compareTo(raiz.getId()) < 0){
                
                if (raiz.getRight() != null) {
                    
                    delateViewer(id, raiz.getRight());
                }
            }else if(id.compareTo(raiz.getId()) == 0){
                
                raiz = null;
            }else{
                
                throw new DoesntExistException();
            }
        }else{
            
            throw new DoesntExistException();
        }        
    }
    
    public void addCompetitor(Competitor c, Competitor nodo) throws DoesntExistException{
        
        if (nodo != null) {
            
            if (nodo.getNext() != null) {
                
                addCompetitor(c, nodo.getNext());
            }else{
                
                nodo.setNext(c);
            }
        }else{
            
            throw new DoesntExistException();
        }
    }

    @Override
    public String toString() {
        return "Event{" + "name=" + name + '}';
    }
    
    public void addCompetitor(Competitor c){
        
        Competitor aux = first;
        
        while (aux != null) {
            
            if (aux.getNext() != null) {
                
                aux.setNext(c);
                
            }else{
                
                aux = aux.getNext();
                
            }
        }
    }
    
    public void loadCompetitor(String csv, String sep) throws FileNotFoundException, IOException, CsvException{
              
        if (csv != null) {

            File f = new File (csv);
            FileReader fr = new  FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            int i = 0;

            String line = br.readLine();

            while (line != null) {

                System.out.println(line);

                if (line.charAt(0) != '#') {
                        
                    String[] parts = line.split(sep);
                    String id = parts[0];
                    String name = parts[1];
                    String LastName = parts[2];
                    String email = parts[3];
                    String gender = parts[4];
                    String country = parts[5];
                    String photo = parts[6];
                    String birthday = parts[7];
                        
                    Competitor com = new Competitor(id, name, LastName, email, gender, country, photo, birthday);
                    addCompetitor(com);
                        
                    String rutaFichero = "Socio.txt";

                    try{

                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero));
                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaFichero));

                        oos.writeObject(com);
                        oos.close();

                        Viewer readClient = (Viewer) ois.readObject();
                        ois.close();
                        System.out.println("Persona: " + com.toString());

                    }catch (IOException ex) {

                        System.out.println(ex.getMessage());
                    }catch (ClassNotFoundException ex) {

                        System.out.println(ex.getMessage());
                    }


                    line = br.readLine();
                   i++; 
                }
            }
        }else{

        throw new CsvException();
        }        
    }  
    
    public void DrawThree(String country){
        
        root.levelPath(country);
    }
}
