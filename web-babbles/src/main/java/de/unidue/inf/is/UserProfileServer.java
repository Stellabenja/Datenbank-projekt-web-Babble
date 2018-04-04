package de.unidue.inf.is;

import de.unidue.inf.is.domain.Babble;
import de.unidue.inf.is.domain.Details_babbles;
import de.unidue.inf.is.domain.User;
import de.unidue.inf.is.stores.StoreException;
import de.unidue.inf.is.stores.UserStore;
import de.unidue.inf.is.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserProfileServer extends HttpServlet {


   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Put the user list in request and let freemarker paint it.
        User user =null;
       List<Babble> babblelist;
       Details_babbles details;
        try (UserStore userStore = new UserStore()) {
             user=userStore.userparameter(request.getParameter("userparameter"));
            babblelist=userStore.babbletime();
            userStore.complete();
        }
       request.setAttribute("babblelist",babblelist);
        request.setAttribute("parameter",user);
        request.setAttribute("user",request.getParameter("userparameter"));
        
        request.getRequestDispatcher("/userprofile.ftl").forward(request,response);
    }

}

