package com.example.deterministicfiniteautomatontoright_lineargrammar;

public class Rule {

    String left;
    String right;

    public void setRight(String right) {
        this.right = right;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

    public Rule(){

    }

    public Rule(String left, String right){
        this.left = left;
        this.right = right;

    }

    public String toString(){

        return new String(getLeft()+"->"+getRight());

    }

}
