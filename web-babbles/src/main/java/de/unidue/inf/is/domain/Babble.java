package de.unidue.inf.is.domain;

import java.util.Date;

public class Babble {
    public int id;
    public String text;
    public Date created;
    public String creator;
    public Babble(int id,String text,Date created,String creator){
        this.id=id;
        this.text=text;
        this.created=created;
        this.creator=creator;
    }
    public int getId(){
        return id;
    }
    public String getText(){
        return text;
    }
    public Date getCreated(){
        return created;
    }
    public String getCreator(){
        return creator;
    }
}
