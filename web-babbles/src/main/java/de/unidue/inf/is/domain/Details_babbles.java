package de.unidue.inf.is.domain;

public class Details_babbles {
    private int likes;
    private int dislike;
    private int rebabble;
    private String rebabbler;
    public Details_babbles(int likes,int dislike,int rebabble){
        this.dislike=dislike;
        this.likes=likes;
        this.rebabble=rebabble;


    }

    public int getDislike() {
        return dislike;
    }

    public int getLikes() {
        return likes;
    }


    public int getRebabble() {
        return rebabble;
    }
}
