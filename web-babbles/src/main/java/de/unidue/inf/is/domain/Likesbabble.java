package de.unidue.inf.is.domain;

import java.util.Date;

public class Likesbabble {
    private String user;
    private int babbleid;
    private String type;
    private Date created;
    public Likesbabble(String user,int babbleid,String type,Date created){
        this.babbleid=babbleid;
        this.created=created;
        this.type=type;
        this.user=user;
    }

    public Date getCreated() {
        return created;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public int getBabbleid() {
        return babbleid;
    }
}
