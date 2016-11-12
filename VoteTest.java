/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemOfVote;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Denis
 */
public class VoteTest {
    
    public VoteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() throws Exception {
        VotingSystem system = new VotingSystem();
        System.out.println("Hello World!");
        
        //Passports for Voters
        Passport p1 = new Passport(12, 12);
        Passport p2 = new Passport(1, 12);
        Passport p3 = new Passport(2, 12);
        Passport p4 = new Passport(3, 12);
        
        //Candidates
        Candidate c1 = new Candidate("Petrov","Petya");
        Candidate c2 = new Candidate("l","l");
        Candidate c3 = new Candidate("q","q");
        
        //Voters
        Voter v1 = new Voter(p1);
        Voter v2 = new Voter(p2);
        Voter v3 = new Voter(p3);
        Voter v4 = new Voter(p4);
        
        //VoteReg
        //VoteReg reg = null;
        //reg.candCntHm.put(c1,0);
        //reg.candCntHm.put(c2,0);
        //reg.candCntHm.put(c3,0);
        
        //add Candidate
        ElectionCommission com = null;
        com.addCand(c1);
        com.addCand(c2);
        com.addCand(c3);
        
        
        //vote
        v1.vote(c1);
        v1.vote(c2);
        v1.vote(c3);
        v1.vote(c2);
        
        
        Candidate winner = null;
        winner = com.whoIsWinner();
        winner.output(winner);
        //hm.put("Васька", new Integer(5)); -newInteger!!!
        //system.allowPassport(123456);
        /*Voter voter1 = new Voter(123456);
        voter1.vote();
        assertTrue(vote.number = oldNumber + 1);
        assertEquals(voter.getCandidate(), "Vasya");
        voter2.vote();
        system.getWinner() == "Petya";*/
        
    }
}
