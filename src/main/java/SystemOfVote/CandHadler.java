package SystemOfVote;



/**
 * Created by Denis on 18.12.2016.
 */

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CandHadler extends HttpServlet {
    @EJB
    VotingSystemLocal votingSystem;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        //int number = Integer.parseInt(req.getParameter("number"));
        //int serial = Integer.parseInt(req.getParameter("serial"));

        Candidate cand = new Candidate(surname,name);
        if (votingSystem.addCand(cand)){
            resp.sendRedirect("http://localhost:8080/Denis/faces/electionCommission.jsp");
        }
        else resp.getWriter().println("You cant add candidate!");
    }
}