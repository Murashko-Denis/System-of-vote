package SystemOfVote;

/**
 * Created by Denis on 16.12.2016.
 */

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class VoteHandler extends HttpServlet {
    @EJB
    VotingSystemLocal votingSystem;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num = req.getParameter("cand");
        try {
            int number = Integer.parseInt(req.getParameter("number"));
            int serial = Integer.parseInt(req.getParameter("series"));
            Passport p = new Passport();
            List<Passport> list = votingSystem.getEm().createNamedQuery("findPassport", Passport.class)
                    .setParameter("number", number)
                    .setParameter("series", serial)
                    .getResultList();
            if (list.isEmpty()) {
                resp.getWriter().println("Wrong Passport Data!");
            } else {
                Candidate cand = votingSystem.getCand(Integer.valueOf(num));

                if (votingSystem.vote(cand)) {
                    resp.sendRedirect("http://localhost:8080/Denis/faces/voter.jsp");
                } else {
                    resp.getWriter().println("Vote dont Start! or You want to vote twice!");
                }
            }
        }catch (Exception e){
            resp.getWriter().println("Enter Passport Data!");
        }
    }

}
