package com.votingsystem;

public class Candidato{

    private String name;
    private int votes;

    public Candidato(String name) {
        this.name = name;
        this.votes = 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public void addVote() {
        this.votes++;
    }
}