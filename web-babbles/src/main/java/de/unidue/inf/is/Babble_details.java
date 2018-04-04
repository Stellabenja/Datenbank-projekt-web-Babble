package de.unidue.inf.is;

import de.unidue.inf.is.domain.Babble;
import de.unidue.inf.is.domain.Details_babbles;
import de.unidue.inf.is.stores.StoreException;
import de.unidue.inf.is.stores.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Babble_details extends HttpServlet {
    private int babbleID;

    public Babble_details(int babbleID){
        this.babbleID=babbleID;
    }

    public int getBabbleID() {
        return babbleID;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Details_babbles details_babbles=null;
        Babble babbleobject=null;
        UserStore userStore=null;
        babbleID=Integer.parseInt(request.getParameter("babbleId"));
        try {
            babbleobject = userStore.babbleobject(Integer.parseInt(request.getParameter("babbleId")));
            details_babbles = (userStore.details(Integer.parseInt(request.getParameter("babbleId"))));
            userStore.addlikes();
            userStore.dislikes();
            userStore.complete();
        }catch (StoreException e) {}
        request.getParameter("button");
        if(request.getParameter("button1")!=null){
            userStore.addlikes();
        }else if (request.getParameter("button2")!=null){
            userStore.dislikes();
        }
        request.setAttribute("babbleobject",babbleobject);
        request.setAttribute("parameter",details_babbles);
        request.setAttribute("details",request.getParameter("babbleId"));

        request.getRequestDispatcher("/babbledetail.ftl").forward(request,response);
    }

}

