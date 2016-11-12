/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemOfVote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Denis
 */
public class VoteReg {
    //public ArrayList<Candidate> candReg;
    public int cnt_votes;
    
    Map<Candidate,Integer> candCntHm = new LinkedHashMap<Candidate, Integer>();
    

    public Set<Candidate> getAllCand(){
        return candCntHm.keySet();
    }
            
    public int getCntVotes(Candidate cand){
        return candCntHm.get(cand);
        
                
    }
    

    public void incCntVotes(Candidate cand) throws Exception{
        if (candCntHm.keySet().contains(cand)) {
            candCntHm.put(cand, candCntHm.get(cand)+1);
        }
        else {
            throw new Exception("Try to inc votes nonexistent candidate!");
        }   
    }
    
    public void addCandToMap(Candidate cand){
        candCntHm.put(cand, 0);
    }
    
    public Candidate getWinner(){
        Map.Entry<Candidate, Integer> maxEntry = null; 
        for (Map.Entry<Candidate, Integer> entry : candCntHm.entrySet()) 
        { 
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) 
            { 
                maxEntry = entry; 
            } 
        }
        return maxEntry.getKey();
    }
    /*public void changeCntVotes(Candidate cand, int cnt_votes) throws Exception{
        if (candReg.contains(cand)) {
            candCntHm.put(cand,cnt_votes);
        }
        else {
            throw new Exception("Try to change votes nonexistent candidate!");
        }   
    }*/
}
