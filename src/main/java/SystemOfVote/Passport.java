/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemOfVote;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Denis
 */
@Entity
@NamedQuery(name = "findPassport", query = "SELECT u FROM Passport u WHERE u.number = :number and u.series = :series ")
public class Passport implements Serializable {
    @Id
    @javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public int number;
    public int series;

    public Passport() {
    }
    public Passport(int number, int series) throws Exception {
        this.number = number;
        this.series = series;
        if (number > 10000) {
            throw new Exception("Invalid number");
        }
    }
    public int getNumber() {
        return this.number;
    }

    public int getSeries() {
        return this.series;
    }
}
