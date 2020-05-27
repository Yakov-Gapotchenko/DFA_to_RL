package com.example.deterministicfiniteautomatontoright_lineargrammar;

import java.util.ArrayList;




public class Rules {

    ArrayList<Rule> rulesList;

    public Rules(){
        rulesList = new ArrayList<>();
    }

    public void setRulesList(ArrayList<Rule> rulesList) {
        this.rulesList = rulesList;
    }


    public String getRulesListAsString() {
        String res="";
        for( Rule rule: rulesList)
            res+=rule.toString()+"\n";
        return res;

    }



    public ArrayList<Rule> getRulesList() {
        return rulesList;
    }

    public void addRule(Rule rule){

        rulesList.add(rule);
    }


    public void rulesConsoleOutput(){
        System.out.println("\tRules:\t");

        for(Rule rule: rulesList)
            System.out.println(rule.getLeft()+"->"+rule.getRight());


    }

    public String rulesAsOneMultilineString(){
        String res="";
        for(Rule rule: rulesList)
            res+= rule.getLeft()+"->"+rule.getRight()+"\n";

        return res;

    }

}
