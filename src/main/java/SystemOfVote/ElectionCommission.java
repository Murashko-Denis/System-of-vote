/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemOfVote;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Denis
 */

public class ElectionCommission {
    public boolean isStart;
    public boolean isComplited;
    public VoteReg reg;
    //@OneToOne(cascade = CascadeType.ALL)
    //private Passport passport;

    public ElectionCommission(VoteReg regMap){
        this.reg = regMap;
        //this.passport = pas;
    }
    public void startVote(){
        this.isStart = true;
        this.isComplited = false;
    }
    
    public void finishVote(){
        this.isComplited = true;
        this.isStart = false;
    }
    public Candidate whoIsWinner(){
        if (isComplited) {
            return reg.getWinner();
        }
        else {
            Candidate c = new Candidate("Vote dont Comlited!", " ");
            return c;
        }
    } 
            
    public boolean addCand(Candidate cand){
        if (!isStart) {
            if (reg.getAllCand().contains(cand)) {
                return false;
                //throw new Exception("Try to add existent candidate!");
            } else {
                reg.addCandToMap(cand);
                return true;
            }
        }
        else return false;
    }
   
    
    public boolean delCand(Candidate cand){
        if (!isStart){
            return reg.delCandToMap(cand);
        }
        else {
            return false;
        }
        
    }
    /*public Integer getSerial() {
        return serial;
    }*/
}
