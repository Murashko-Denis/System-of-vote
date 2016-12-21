/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemOfVote;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.*;

/**
 *
 * @author Denis
 */
@Entity
public class Voter implements Serializable{
    @Id
    public int id;
    @OneToOne(cascade = CascadeType.ALL)
    private Passport passport;
    @ManyToOne(cascade = CascadeType.ALL)
    public VoteReg reg;

    boolean hasVoted;

    public Voter() {
    }
    
    public Voter(Passport pas, VoteReg regMap) {
        this.passport = pas;
        this.reg = regMap;
    }        
    public boolean vote(Candidate cand) throws Exception{
        if (reg.getAllCand().contains(cand)) {
            if (hasVoted){
                return false;
                //throw new Exception("Try to vote second time!");
            }
            else {
                reg.incCntVotes(cand);
                hasVoted = true;
                return true;
            }
        }
        else {
            return false;
            //throw new Exception("Try to vote nonexistent candidate!");
        }
    }
   /*public Map<Candidate,Integer> getResult(){
       return reg.getResult();
   }*/
}
