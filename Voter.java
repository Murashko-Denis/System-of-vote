/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemOfVote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Denis
 */
public class Voter {
    private Passport passport;
    //ArrayList<Candidate> candReg;
    
    VoteReg regMap;
    
    public Voter(Passport pas) {
        this.passport = pas;
    }        
    public void vote(Candidate cand) throws Exception{
        if (regMap.getAllCand().contains(cand)) {
            regMap.incCntVotes(cand);
        }
        else {
            throw new Exception("Try to vote nonexistent candidate!");
        }
    }
   
}
