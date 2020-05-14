package com.example.deterministicfiniteautomatontoright_lineargrammar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.LinkedHashSet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onBtnTranform(View view) {

        EditText editText = findViewById(R.id.editTextDFA);//dfa - deterministic finite automaton
        TextView textView = findViewById(R.id.textViewRLG);//rlg - right-linear grammar


        // prepare input data
        String stringDFA = editText.getText().toString();

        String[] strArrayDFA = stringDFA.split("\n");//lines of DFA



        int nrows = strArrayDFA.length;


        String[][] entire2dArray = new String[nrows][];


        for (int i = 0; i < nrows; i++) {
            entire2dArray[i] = strArrayDFA[i].split("[ ]+");
        }

        // transform prepared input data to output
        DFA dfa = new DFA();
        dfa.setTableDFA(entire2dArray);


        // five string components of result which will be concatenate to one string
        String startState = dfa.getNonTerminals()[0];

        String states = dfa.getNonTerminals().toString();
        String alphabet = dfa.getTerminals().toString();

        String acceptStates = dfa.findValidStates().toString();

        String rulesAsStr = dfa.findRules().getRulesList().toString();

        String oneBigResult = String.format("Start state:\t%s\n" + "States:\t%s\n" + "Alphabet:\t%s\n" + "Accept states:\t%s\n" + "Rules:\t%s\n",startState,states,alphabet,acceptStates,rulesAsStr);


        // set text

        textView.setText(oneBigResult);





    }




        



}
