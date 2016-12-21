/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemOfVote;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * @author Denis
 */
    @Singleton(name = "VotingSystem")
public class VotingSystem implements VotingSystemLocal {
    // public static VotingSystem system = new VotingSystem();
    public VoteReg reg = new VoteReg();
    //public Voter v = new Voter();
    public ElectionCommission ec = new ElectionCommission(reg);
    public EntityManager em = Persistence.createEntityManagerFactory("Votes").createEntityManager();
    /*List<Passport> list = em.createNamedQuery("findPassport", Passport.class)
            .setParameter("number", 1)
            .setParameter("series", 2)
            .getResultList();*/
    public VotingSystem() {
        try {
            //Passports for Voters
            Passport p1 = new Passport(1001, 111111);
            Passport p2 = new Passport(2002, 222222);
            Passport p3 = new Passport(3003, 333333);
            Passport p4 = new Passport(4004, 444444);
            Passport p5 = new Passport(4004, 555555);
            Passport p6 = new Passport(4004, 666666);
            Passport p7 = new Passport(4004, 777777);
            Passport p8 = new Passport(4004, 888888);
            Passport p9 = new Passport(4004, 999999);
            Passport p10 = new Passport(4004, 101010);
            Passport p11 = new Passport(4004, 110110);
            //Passports for Candidates
            Passport pc1 = new Passport(1111, 111111);
            Passport pc2 = new Passport(1111, 222222);
            Passport pc3 = new Passport(1111, 333333);
            Passport pc4 = new Passport(1111, 444444);
            //Passports for Candidates
            Passport pe1 = new Passport(2222, 111111);

            //Candidates
            Candidate c1 = new Candidate("Petrov", "Petya");
            Candidate c2 = new Candidate("Ivanov", "lvan");
            Candidate c3 = new Candidate("Sidorov", "Sidr");
            Candidate c4 = new Candidate("Mironov", "Miron");

            c1 = em.merge(c1);
            c2 = em.merge(c2);
            c3 = em.merge(c3);
            c4 = em.merge(c4);

            //Voters
            Voter v1 = new Voter(p1, reg);
            Voter v2 = new Voter(p2, reg);
            Voter v3 = new Voter(p3, reg);
            Voter v4 = new Voter(p4, reg);

            //ElectionCommission
            //ElectionCommission ec = new ElectionCommission(reg);

            //VoteReg
            reg.candCntHm.put(c1, 0);
            reg.candCntHm.put(c2, 0);
            reg.candCntHm.put(c3, 0);
            reg.candCntHm.put(c4, 0);

            em.getTransaction().begin();

            em.merge(p1);
            em.merge(p2);
            em.merge(p3);
            em.merge(p4);
            em.merge(p5);
            em.merge(p6);
            em.merge(p7);
            em.merge(p8);
            em.merge(p9);
            em.merge(p10);
            em.merge(p11);


            em.merge(v1);
            em.merge(v2);
            em.merge(v3);
            em.merge(v4);

            em.merge(reg);


            em.getTransaction().commit();

        } catch (Exception ex) {
            Logger.getLogger(VotingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String whoIsWinnerString() {
        if (ec.isComplited) {
            return reg.getWinner().outputSurname(reg.getWinner()) + " " + reg.getWinner().outputName(reg.getWinner());
        } else{
            return "Wait Finish Vote...";
        }
    }

    @Override
    public String getCandString(int index) {
        return reg.getAllCand().get(index).outputCandidate(reg.getAllCand().get(index));
    }
    @Override
    public Candidate getCand(int index) {
        return reg.getAllCand().get(index);
    }
    public int getCntCands(){
        return reg.getCntCands();
    }
    public int getCntVotes(int index){
        return reg.getCntVotes(reg.getAllCand().get(index));
    }

    public boolean vote(Candidate cand){
        /*if (v.vote(cand)){
            return true;
        }
        else return false;*/
        if (ec.isStart) {
            reg.incCntVotes(cand);
            return true;
        }else return false;

    }
    @Override
    public boolean addCand(Candidate cand){
        return ec.addCand(cand);
        //reg.addCandToMap(cand);
    }

    public boolean delCand(Candidate cand){
        return ec.delCand(cand);
        //return reg.delCandToMap(cand);
    }
    public void startVote(){
        ec.startVote();
    }

    public void finishVote(){
        ec.finishVote();
    }

    @Override
    public EntityManager getEm() {
        return em;
    }
}

