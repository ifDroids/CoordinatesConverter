package com.ibo.coordinatesconv;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static int x;
    @BindView(R.id.btn_input_gnss)
    Button mBtninput_gnss; //m for member of class
    @BindView(R.id.btn_input_utm)
    Button mBtninput_utm; //m for member of class
    @BindView(R.id.btn_input_hepos)
    Button mBtninput_hepos; //m for member of class
    @BindView(R.id.btn_output_gnss)
    Button mBtnoutput_gnss; //m for member of class
    @BindView(R.id.btn_output_utm)
    Button mBtnoutput_utm; //m for member of class
    @BindView(R.id.btn_output_hepos)
    Button mBtnoutput_hepos; //m for member of class
    @BindView(R.id.btn_debug)
    Button mBtnDebug; //m for member of class
    @BindView(R.id.input_lat)
    EditText mInputlat;
    @BindView(R.id.input_long)
    EditText mInputlong;
    @BindView(R.id.utm_x_output)
    TextView mUtmxoutput;
    @BindView(R.id.utm_y_output)
    TextView mUtmyoutput;
    @BindView(R.id.utm_zone_output)
    TextView mUtmzone;
    @BindView(R.id.utm_zone_boundaries)
    View mUtm_zone_boundaries;


    public void clearTextbutton(){
        mInputlat.setText(" ");
        mInputlong.setText(" ");
        mUtmxoutput.setText(" ");
        mUtmyoutput.setText(" ");
        mUtmzone.setText(" ");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mBtninput_gnss.setBackground(getDrawable(R.drawable.round_frame_bar_option));
        mBtnoutput_utm.setBackground(getDrawable(R.drawable.round_frame_bar_option));
    }

    @OnClick(R.id.btn_debug)
    public void onButtonClick(View v) {
        if (x==1){
            mUtmxoutput.setText(mInputlat.getText().toString());
            Log.e("MainActivity", "DEBUG");}
        else if(x==2){
            Log.e("MainActivity", "sdasda");
        }
        else if(x==3){
            Log.e("MainActivity", "sdasda");
        }
        else if(x==4){
            Log.e("MainActivity", "sdasda");
        }
        else  if(x==5){
            Log.e("MainActivity", "sdasda");
        }
        else if(x==6){
            Log.e("MainActivity", "sdasda");
        }
    }

    @OnClick(R.id.btn_output_gnss)
    public void onButtonoutput_gnss(View v) {
        x=1;
        mBtnoutput_gnss.setTextColor(Color.GREEN);
        mBtnoutput_gnss.setBackground(getDrawable(R.drawable.round_frame_bar_option));

        mBtninput_gnss.setTextColor(Color.RED);
        mBtnoutput_utm.setTextColor(Color.RED);
        mBtnoutput_hepos.setTextColor(Color.RED);
        mBtnoutput_utm.setBackground(null);
        mBtnoutput_hepos.setBackground(null);
        mUtm_zone_boundaries.setVisibility(View.GONE);
        clearTextbutton();
    }

    @OnClick(R.id.btn_output_utm)
    public void onButtonbtn_output_utm(View v) {
        x=2;
        mBtnoutput_gnss.setTextColor(Color.RED);
        mBtnoutput_gnss.setBackground(null);

        mBtninput_utm.setTextColor(Color.RED);

        mBtnoutput_utm.setTextColor(Color.GREEN);
        mBtnoutput_utm.setBackground(getDrawable(R.drawable.round_frame_bar_option));

        mBtnoutput_hepos.setTextColor(Color.RED);
        mBtnoutput_hepos.setBackground(null);
        mUtm_zone_boundaries.setVisibility(View.VISIBLE);
        clearTextbutton();
    }

    @OnClick(R.id.btn_output_hepos)
    public void onButtonoutput_hepos(View v) {
        x=3;
        mBtninput_hepos.setTextColor(Color.RED);

        mBtnoutput_gnss.setTextColor(Color.RED);
        mBtnoutput_gnss.setBackground(null);
        mBtnoutput_utm.setTextColor(Color.RED);
        mBtnoutput_utm.setBackground(null);

        mBtnoutput_hepos.setTextColor(Color.GREEN);
        mBtnoutput_hepos.setBackground(getDrawable(R.drawable.round_frame_bar_option));

        mUtm_zone_boundaries.setVisibility(View.GONE);
        clearTextbutton();
    }

    @OnClick(R.id.btn_input_gnss)
    public void onButtoninput_gnss(View v) {
        x=4;
        mBtninput_gnss.setTextColor(Color.GREEN);
        mBtninput_gnss.setBackground(getDrawable(R.drawable.round_frame_bar_option));

        mBtnoutput_gnss.setTextColor(Color.RED);

        mBtninput_utm.setTextColor(Color.RED);
        mBtninput_hepos.setTextColor(Color.RED);
        mBtninput_utm.setBackground(null);
        mBtninput_hepos.setBackground(null);
        clearTextbutton();
    }

    @OnClick(R.id.btn_input_utm)
    public void onButtoninput_utm(View v) {
        x=5;
        mBtninput_utm.setTextColor(Color.GREEN);
        mBtninput_utm.setBackground(getDrawable(R.drawable.round_frame_bar_option));

        mBtnoutput_utm.setTextColor(Color.RED);

        mBtninput_gnss.setTextColor(Color.RED);
        mBtninput_hepos.setTextColor(Color.RED);
        mBtninput_gnss.setBackground(null);
        mBtninput_hepos.setBackground(null);
        clearTextbutton();
    }

    @OnClick(R.id.btn_input_hepos)
    public void onButtoninput_hepos(View v) {
        x=6;
        mBtninput_gnss.setTextColor(Color.RED);
        mBtninput_utm.setTextColor(Color.RED);
        mBtninput_gnss.setBackground(null);
        mBtninput_utm.setBackground(null);

        mBtnoutput_hepos.setTextColor(Color.RED);

        mBtninput_hepos.setTextColor(Color.GREEN);
        mBtninput_hepos.setBackground(getDrawable(R.drawable.round_frame_bar_option));
        clearTextbutton();
    }



}



