/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemOfVote;

/**
 *
 * @author Denis
 */
public class Candidate {
    public String name;
    public String surname;
    
    public Candidate(String surname, String name) {
        this.name = surname; 
        this.name = name;
           
    }

    Candidate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void output(Candidate cand){
        System.out.printf("Cand %s %s \n", name, surname);
    }
}
