package de.unidue.inf.is;

import de.unidue.inf.is.domain.Babble;
import de.unidue.inf.is.domain.Details_babbles;
import de.unidue.inf.is.stores.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BabbleTimeline extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Babble> babblelist;
        Details_babbles details;
        try (UserStore userStore=new UserStore()){
            babblelist=userStore.babbletime();


            userStore.complete();
        }
        request.setAttribute("babblelist",babblelist);
        request.getRequestDispatcher("/babbleTimeline.ftl").forward(request,response);
    }
    }
