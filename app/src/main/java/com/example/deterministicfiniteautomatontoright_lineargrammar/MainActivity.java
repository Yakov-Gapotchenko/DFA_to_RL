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


    public void onBtnTransform(View view) {

        EditText editText = findViewById(R.id.editTextDFA);//dfa - deterministic finite automaton
        TextView textView = findViewById(R.id.textViewRLG);//rlg - right-linear grammar


        // prepare input data
        String stringDFA = editText.getText().toString();

        String[] strArrayDFA = stringDFA.split("\n");//lines of DFA



        int nrows = strArrayDFA.length;


        String[][] entire2dArray = new String[nrows][];


        for (int i = 0; i < nrows; i++) {
            entire2dArray[i] = strArrayDFA[i].trim().split("[ ]+");
        }

        // transform prepared input data to output
        DFA dfa = new DFA();
        dfa.setTableDFA(entire2dArray);


        // five string components of result which will be concatenate to one string
        String startState = dfa.getNonTerminals()[0];

        String states = DFA.arrayToString(dfa.getNonTerminals());
        String alphabet = DFA.arrayToString(dfa.getTerminals());

        String acceptStates = DFA.hashSetToString(dfa.findValidStates());

        String rulesAsStr =dfa.findRules().getRulesListAsString();

        String oneBigResult = String.format("Start state:\t%s\n" + "States:\t%s\n" + "Alphabet:\t%s\n" + "Accept states:\t%s\n" + "Rules:\t%s\n",startState,states,alphabet,acceptStates,rulesAsStr);


        // set text

        textView.setText(oneBigResult);





    }




        



}
