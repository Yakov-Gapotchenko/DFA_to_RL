package com.example.deterministicfiniteautomatontoright_lineargrammar;

import java.util.LinkedHashSet;

public class DFA {


    String[] terminals;
    String[] nonTerminals;

    int[] isValid;

    int nrows,ncols;

    String[][] tableDFA ;/*= {{"0","1"},
            {"A","E","B","0"},
            {"B","C","E","0"},
            {"C","D","E","1"},
            {"D","D","B","1"},
            {"E","E","E","0"}};*/

    public String[] getTerminals() {
        return terminals;
    }

    public String[] getNonTerminals() {
        return nonTerminals;
    }

    public int[] getIsValid() {
        return isValid;
    }

    public int getNrows() {
        return nrows;
    }

    public int getNcols() {
        return ncols;
    }

    public String[][] getTableDFA() {
        return tableDFA;
    }


    static String arrayToString(String[] arr){
        String res="{";

        for(int i =0 ;i<arr.length-1;i++)
            res+=arr[i]+"  ";
        res= res + arr[arr.length-1]+ "}";

        return res;


    }


    static String hashSetToString(LinkedHashSet<String> set){
        String res="{";

        for(String elem: set)
            res+=elem + "   ";

        res+="}";

        return res;
    }


    public LinkedHashSet<String> findValidStates(){

        LinkedHashSet<String> res = new LinkedHashSet<>();
        for(int i=0;i<nrows;i++){
            if(isValid[i]==1)
                res.add(nonTerminals[i]);
        }

        return res;

    }

    public void setTableDFA(String[][] entire2dArray) {

        nrows = entire2dArray.length - 1;
        ncols = entire2dArray[0].length;
        terminals = new String[ncols];
        nonTerminals = new String[nrows];
        isValid = new int[nrows];

        tableDFA = new String[nrows][ncols];



        for(int j=0;j<entire2dArray[0].length;j++)
            terminals[j]=entire2dArray[0][j];


        for(int i=1;i<entire2dArray.length;i++){

            nonTerminals[i-1]=entire2dArray[i][0];

            for(int j=1;j<entire2dArray[i].length-1;j++)
                tableDFA[i-1][j-1]=entire2dArray[i][j];

            isValid[i-1]=Integer.parseInt(entire2dArray[i][entire2dArray[i].length-1]);
        }

    }



    public Rules findRules(){
        Rules rules = new Rules();

        for(int i=0;i<nrows;i++) {
            for (int j = 0; j < ncols; j++)
                rules.addRule(new Rule(nonTerminals[i], terminals[j] + tableDFA[i][j]));

            if(isValid[i]==1)
                rules.addRule(new Rule(nonTerminals[i], "_"));
        }

        return rules;

    }




    public static void main(String[] args){


        DFA dfa = new DFA();

        dfa.setTableDFA( new String[][]{{"0","1"},
                {"A","E","B","0"},
                {"B","C","E","0"},
                {"C","D","E","1"},
                {"D","D","B","1"},
                {"E","E","E","0"}});


        Rules rules = dfa.findRules();

        rules.rulesConsoleOutput();

    }
}
