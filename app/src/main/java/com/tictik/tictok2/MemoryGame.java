package com.tictik.tictok2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MemoryGame extends AppCompatActivity {


    ImageView iv_11, iv_12, iv_13, iv_14, iv_21, iv_22, iv_23, iv_24, iv_31, iv_32, iv_33, iv_34, iv_41, iv_42, iv_43, iv_44, iv_51, iv_52, iv_53, iv_54;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_memory_game);


        iv_11 = (ImageView) findViewById(R.id.im_11);
        iv_12 = (ImageView) findViewById(R.id.im_12);
        iv_13 = (ImageView) findViewById(R.id.im_13);
        iv_14 = (ImageView) findViewById(R.id.im_14);


        iv_21 = (ImageView) findViewById(R.id.im_21);
        iv_22 = (ImageView) findViewById(R.id.im_22);
        iv_23 = (ImageView) findViewById(R.id.im_23);
        iv_24 = (ImageView) findViewById(R.id.im_24);


        iv_31 = (ImageView) findViewById(R.id.im_31);
        iv_32 = (ImageView) findViewById(R.id.im_32);
        iv_33 = (ImageView) findViewById(R.id.im_33);
        iv_34 = (ImageView) findViewById(R.id.im_34);


        iv_41 = (ImageView) findViewById(R.id.im_41);
        iv_42 = (ImageView) findViewById(R.id.im_42);
        iv_43 = (ImageView) findViewById(R.id.im_43);
        iv_44 = (ImageView) findViewById(R.id.im_44);


        iv_51 = (ImageView) findViewById(R.id.im_51);
        iv_52 = (ImageView) findViewById(R.id.im_52);
        iv_53 = (ImageView) findViewById(R.id.im_53);
        iv_54 = (ImageView) findViewById(R.id.im_54);





    }


}
