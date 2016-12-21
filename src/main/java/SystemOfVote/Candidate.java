/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemOfVote;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Denis
 */
@Entity
public class Candidate implements Serializable{
    @Id
    @javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
    public String surname;
    //@OneToOne(cascade = CascadeType.ALL)
    //private Passport passport;

    public Candidate() {
    }
    
    public Candidate(String surname, String name) {
        this.surname = surname; 
        this.name = name;
        //this.passport = pas;
    }

    public String outputSurname(Candidate cand){
        return cand.surname;
    }
    public String outputName(Candidate cand){
        return cand.name;
    }
    public String outputCandidate(Candidate cand){
        return cand.outputSurname(cand) + " " + cand.outputName(cand);
    }

    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candidate candidate = (Candidate) o;

        if (name != null ? !name.equals(candidate.name) : candidate.name != null) return false;
        return surname != null ? surname.equals(candidate.surname) : candidate.surname == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }
}
