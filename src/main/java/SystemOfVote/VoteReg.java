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
import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Denis
 */
@Entity
public class VoteReg implements Serializable {
    //public int cnt_votes;
    @Id
    public int id;
    @ElementCollection
    @MapKeyColumn
    @CollectionTable
    public Map<Candidate, Integer> candCntHm = new LinkedHashMap<Candidate, Integer>();

    public VoteReg() {
    }

    public ArrayList<Candidate> getAllCand() {
        Set candList = candCntHm.keySet();
        ArrayList list = new ArrayList(candList);
        return list;
    }

    public int getCntVotes(Candidate cand) {
        return candCntHm.get(cand);
    }

    public int getCntCands() {
        return candCntHm.size();
    }


    public boolean incCntVotes(Candidate cand)  {
        if (candCntHm.keySet().contains(cand)) {
            candCntHm.put(cand, candCntHm.get(cand) + 1);
            return true;
        } else {
            return false;
            //throw new Exception("Try to inc votes nonexistent candidate!");
        }
    }

    public void addCandToMap(Candidate cand) {
        candCntHm.put(cand, 0);
    }

    public boolean delCandToMap(Candidate cand) {
        if (candCntHm.keySet().contains(cand)) {
            candCntHm.remove(cand);
            return true;
        } else {
            return false;
        }

    }


    public Candidate getWinner() {
        Map.Entry<Candidate, Integer> maxEntry = null;
        for (Map.Entry<Candidate, Integer> entry : candCntHm.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        int cnt = 0;
        for (Map.Entry<Candidate, Integer> entry : candCntHm.entrySet()) {
            if (maxEntry.equals(entry.getValue())) {
                cnt++;
            }
        }
        if (cnt == 1) {
            return maxEntry.getKey();
        } else {
             Candidate c = new Candidate("ReVote, equals votes","");
             return c;
        }

    }

    public Map<Candidate, Integer> getResult() {
        return candCntHm;
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
