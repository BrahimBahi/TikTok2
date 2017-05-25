package com.tictik.tictok2.Games;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tictik.tictok2.R;
import com.tictik.tictok2.model.Questions;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Quiz.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Quiz#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Quiz extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button ans1, ans2, ans3, ans4;
    TextView ques, score;
    Questions mquestion = new Questions();
    String answer;
    Random r;
    private int mscore = 0;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Quiz() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Quiz.
     */
    // TODO: Rename and change types and number of parameters
    public static Quiz newInstance(String param1, String param2) {
        Quiz fragment = new Quiz();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        r = new Random();

        score.setText("Score : "+mscore);

        ans1 = (Button) getView().findViewById(R.id.ans1);
        ans1 = (Button) getView().findViewById(R.id.ans1);
        ans1 = (Button) getView().findViewById(R.id.ans1);
        ans1 = (Button) getView().findViewById(R.id.ans1);
        ques = (TextView) getView().findViewById(R.id.question);
        score = (TextView) getView().findViewById(R.id.score);


        updateQuestion(r.nextInt(mquestion.question.length));

        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ans1.getText()==answer){
                    mscore++;
                    score.setText("Score : " + mscore);
                    updateQuestion(r.nextInt(mquestion.question.length));
                }
else {
                    gameOver();
                }
            }


        });
        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ans2.getText()==answer){
                    mscore++;
                    score.setText("Score : " + mscore);
                    updateQuestion(r.nextInt(mquestion.question.length));
                }
                else {
                    gameOver();
                }
            }
        });

        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans3.getText()==answer){
                    mscore++;
                    score.setText("Score : " + mscore);
                    updateQuestion(r.nextInt(mquestion.question.length));
                }
                else {
                    gameOver();
                }

            }
        });

        ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ans4.getText()==answer){
                    mscore++;
                    score.setText("Score : " + mscore);
                    updateQuestion(r.nextInt(mquestion.question.length));
                }
                else {
                    gameOver();
                }
            }
        });


        return inflater.inflate(R.layout.fragment_quiz, container, false);
    }

    private void gameOver() {
        ques.setText("Game Over");
    }

    private void updateQuestion(int i) {
        ques.setText(mquestion.getQuestion(i));
        ans1.setText(mquestion.getChoice1(i));
        ans2.setText(mquestion.getChoice2(i));
        ans3.setText(mquestion.getChoice3(i));
        ans4.setText(mquestion.getChoice4(i));
        answer = mquestion.getCorrectAns(i);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
