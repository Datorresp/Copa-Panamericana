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
public class Viewer extends Person{
    
    private Viewer right, left;

    public Viewer(String id, String name, String lastName, String email, String gender, String country, String photo, String birthday) {
        super(id, name, lastName, email, gender, country, photo, birthday);

        this.right = null;
        this.left = null;
    }

    public Viewer getRight() {
        return right;
    }

    public void setRight(Viewer right) {
        this.right = right;
    }

    public Viewer getLeft() {
        return left;
    }

    public void setLeft(Viewer left) {
        this.left = left;
    }
    
    
    public  Viewer searchViewer(String ids){
        
        if (id.compareToIgnoreCase(ids) == 0) {
            
            return this;
            
        }else if (id.compareToIgnoreCase(ids) > 0) {
            
            return (left == null) ? null : left.searchViewer(ids);
            
        }else{
            
            return (right == null) ? null : right.searchViewer(ids);
            
        }
    }
    
    public String levelPath(String Country){
        
        String msj = "";
        
        if (country.equalsIgnoreCase(Country)) {
            
            msj += toString() +'\n';
            
            if (left != null && right.country.equalsIgnoreCase(Country)) {
                
                msj += left.toString();
            }
            msj +='\n';
            
            if (right != null && right.country.equalsIgnoreCase(Country)) {
                
                msj += right.toString();
            }
            
            msj += '\n';
            
        }if (left != null) {
            
            msj += left.levelPath(Country);
        }if (right != null) {
            
            msj +=  right.levelPath(Country);
        }
        
        return msj;
    }
}
