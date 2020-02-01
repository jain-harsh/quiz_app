package com.londonappbrewery.quizzler;

public class TrueFalse {
    int cquestions;
    Boolean ans;

    public TrueFalse(int questions,Boolean ans){
        cquestions=questions;
        this.ans=ans;
    }

    public int getCquestions() {
        return cquestions;
    }

    public void setCquestions(int cquestions) {
        this.cquestions = cquestions;
    }

    public Boolean getAns() {
        return ans;
    }

    public void setAns(Boolean ans) {
        this.ans = ans;
    }
}
