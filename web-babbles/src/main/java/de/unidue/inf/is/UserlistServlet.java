package de.unidue.inf.is;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.User;
import de.unidue.inf.is.stores.StoreException;
import de.unidue.inf.is.stores.UserStore;
import de.unidue.inf.is.utils.DBUtil;


/**
 * Einfaches Beispiel, das die Vewendung der Template-Engine zeigt.
 */
public final class UserlistServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;



    private Connection connection;
    private boolean complete;

    public UserlistServlet()throws StoreException {
    }
    static {

        /*userList.add( "Jobs");
        userList.add( "Page");
        userList.add("Sergey");
        userList.add( "Ellison");*/
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> userlist;
        try (UserStore userStore = new UserStore()) {
           userlist= userStore.userlistquery();
            // userStore.somethingElse();

            userStore.complete();
        }

        request.setAttribute("users", userlist);


        request.getRequestDispatcher("/index.ftl").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }




}
