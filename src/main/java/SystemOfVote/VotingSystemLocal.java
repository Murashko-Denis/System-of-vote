/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemOfVote;

import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author Denis
 */
@Local
public interface VotingSystemLocal {

    String getCandString(int index);

    String whoIsWinnerString();

    Candidate getCand(int index);

    int getCntCands();

    int getCntVotes(int index);

    boolean vote(Candidate cand);

    boolean addCand(Candidate cand);

     boolean delCand(Candidate cand);

     void startVote();

     void finishVote();


    EntityManager getEm();
}
