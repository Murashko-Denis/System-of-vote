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
public class Passport {
    public int number;
    public int series;
    public Passport(int number, int series) throws Exception {
        this.number = number;
        this.series = series;
        if (number > 100000) {
            throw new Exception("Invalid number");
        }
    }
    
    
}
