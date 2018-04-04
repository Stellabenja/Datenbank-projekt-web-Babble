package de.unidue.inf.is;

import de.unidue.inf.is.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BabbleSearchServlet extends HttpServlet {
    public static final long serialversion=1L;
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException{
        final String databaseToCheck = "babble";
        boolean databaseExists = DBUtil.checkDatabaseExists(databaseToCheck);

        request.setAttribute("db2name", databaseToCheck);

        if (databaseExists) {
            request.setAttribute("db2exists", "vorhanden! Supi!");
        }
        else {
            request.setAttribute("db2exists", "nicht vorhanden :-(");
        }
        request.getRequestDispatcher("Babble_search.ftl").forward(request,response);

    }
}
