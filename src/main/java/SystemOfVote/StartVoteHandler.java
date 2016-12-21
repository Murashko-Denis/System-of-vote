package SystemOfVote;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * Created by Denis on 19.12.2016.
 */


public class StartVoteHandler extends HttpServlet {
    @EJB
    VotingSystemLocal votingSystem;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.equals(req.getParameter("startVote"), "Start Vote")) {
            votingSystem.startVote();
        } else {
            votingSystem.finishVote();
        }
        resp.sendRedirect("http://localhost:8080/Denis/faces/electionCommission.jsp");
    }
}
