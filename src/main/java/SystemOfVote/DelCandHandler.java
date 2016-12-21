package SystemOfVote;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Denis on 19.12.2016.
 */
public class DelCandHandler extends HttpServlet {
    @EJB
    VotingSystemLocal votingSystem;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String surname = req.getParameter("surname2");
        String name = req.getParameter("name2");
        Candidate cand = new Candidate(surname,name);
        if (votingSystem.delCand(cand)) {
            resp.sendRedirect("http://localhost:8080/Denis/faces/electionCommission.jsp");
        } else {
            resp.getWriter().println("You can't delete candidate!");
        }
        /*try {
            votingSystem.delCand(cand);
        } catch (Exception e) {
            resp.getWriter().println("No such candidate!");
        }*/

    }
}
