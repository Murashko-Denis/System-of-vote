/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemOfVote;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Denis
 */
public class ElectionCommission {
    private boolean isComplited;
  
    VoteReg regMap;
    
    private void startVote(){
        
    }
    
    private void finishVote(){
        
    }
    public Candidate whoIsWinner(){
        return regMap.getWinner();
    } 
            
    public void addCand(Candidate cand){
        regMap.addCandToMap(cand);
    }
    
    public void delCand(Candidate cand) throws Exception{
        if (regMap.getAllCand().contains(cand)){
            regMap.getAllCand().remove(cand);
        }
        else {
            throw new Exception("Try to remove nonexistent candidate!");
        }
        
    }
}
