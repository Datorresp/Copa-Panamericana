/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author diegoa.torres
 */
public class Competitor extends Person{
    
    private Competitor next, previous;

    public Competitor(String id, String name, String lastName, String email, String gender, String country, String photo, String birthday) {
        super(id, name, lastName, email, gender, country, photo, birthday);

        this.next = null;
        this.next = null;
    }  

    public Competitor getNext() {
        return next;
    }

    public void setNext(Competitor next) {
        this.next = next;
    }

    public Competitor getPrevious() {
        return previous;
    }

    public void setPrevious(Competitor previous) {
        this.previous = previous;
    }
    
    public void addCompetitor(Competitor c){
        
        
    }
}
