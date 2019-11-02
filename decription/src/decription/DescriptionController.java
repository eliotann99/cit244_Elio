/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decription;

/**
 *
 * @author eliot
 */
public class DescriptionController {
    private DecriptionGui view;
    private Model model;
    private String text;
    private String hash;
    
    public static void main(String[] args) {
        setup();
    }// close main method
    
    public static void setup() {
        DescriptionController dc = new DescriptionController();
        dc.createModel();
        dc.createView();
    }// clsoe method

    public void createModel(){
        model = new Model();
        model.setController(this);
    }//close method
    
    public void createView() {
        view = new DecriptionGui();
        view.setController(this);
        view.decriptionGui();
    }// close method
    
    public void modelCaller(){
        model.messageDecripter();
    }
    
    
    
    public String getText() {
        return text;
    }// close method


    public void setText(String text) {
        this.text = text;
    }// close method

    /**
     * @return the hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * @param hash the hash to set
     */
    public void setHash(String hash) {
        this.hash = hash;
    }
    
    
}// close class
