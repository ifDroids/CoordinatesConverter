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
import static com.ibo.coordinatesconv.DegToUtm.*;

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
    @BindView(R.id.input_cor_text_lat)
    TextView input_cor_text_lat;
    @BindView(R.id.input_cor_text_lon)
    TextView input_cor_text_lon;
    @BindView(R.id.input_cor_text_alt)
    TextView input_cor_text_alt;

    double lat,lon;
    public void clearTextbutton() {
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
        final DegToUtm convert = new DegToUtm() {
            @Override
            public void degtoUtm(double Lat, double Lon) {
                super.degtoUtm(Lat, Lon);
            }
        };
        mBtninput_gnss.setBackground(getDrawable(R.drawable.round_frame_bar_option));
        mBtnoutput_utm.setBackground(getDrawable(R.drawable.round_frame_bar_option));
        mBtnoutput_gnss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnoutput_gnss.setTextColor(getResources().getColor(R.color.green));
                mBtnoutput_gnss.setBackground(getDrawable(R.drawable.round_frame_bar_option));

                mBtninput_gnss.setTextColor(getResources().getColor(R.color.red));
                mBtnoutput_utm.setTextColor(getResources().getColor(R.color.red));
                mBtnoutput_hepos.setTextColor(getResources().getColor(R.color.red));
                mBtnoutput_utm.setBackground(null);
                mBtnoutput_hepos.setBackground(null);
                mUtm_zone_boundaries.setVisibility(View.GONE);
                clearTextbutton();
            }
        });
        mBtnoutput_utm.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnoutput_gnss.setTextColor(getResources().getColor(R.color.red));
                mBtnoutput_gnss.setBackground(null);

                mBtninput_utm.setTextColor(getResources().getColor(R.color.red));

                mBtnoutput_utm.setTextColor(getResources().getColor(R.color.green));
                mBtnoutput_utm.setBackground(getDrawable(R.drawable.round_frame_bar_option));

                mBtnoutput_hepos.setTextColor(getResources().getColor(R.color.red));
                mBtnoutput_hepos.setBackground(null);
                mUtm_zone_boundaries.setVisibility(View.VISIBLE);
                lat = Double.valueOf(mInputlong.getText().toString());
                lon = Double.valueOf(mInputlong.getText().toString());
                convert.degtoUtm(lat,lon);
                Log.i("msg",String.valueOf(convert.Easting));
                Log.i("msg",String.valueOf(convert.Northing));
                Log.i("msg",String.valueOf(convert.Zone));
                Log.i("msg",String.valueOf(convert.Letter));


//
                clearTextbutton();
            }
        }));
        mBtnoutput_hepos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtninput_hepos.setTextColor(getResources().getColor(R.color.red));

                mBtnoutput_gnss.setTextColor(getResources().getColor(R.color.red));
                mBtnoutput_gnss.setBackground(null);
                mBtnoutput_utm.setTextColor(getResources().getColor(R.color.red));
                ;
                mBtnoutput_utm.setBackground(null);

                mBtnoutput_hepos.setTextColor(getResources().getColor(R.color.green));
                mBtnoutput_hepos.setBackground(getDrawable(R.drawable.round_frame_bar_option));

                mUtm_zone_boundaries.setVisibility(View.GONE);
                clearTextbutton();
            }
        });
        mBtninput_gnss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtninput_gnss.setTextColor(getResources().getColor(R.color.green));
                mBtninput_gnss.setBackground(getDrawable(R.drawable.round_frame_bar_option));
                mBtnoutput_gnss.setTextColor(getResources().getColor(R.color.red));
                mBtninput_utm.setTextColor(getResources().getColor(R.color.red));
                mBtninput_hepos.setTextColor(getResources().getColor(R.color.red));
                mBtninput_utm.setBackground(null);
                mBtninput_hepos.setBackground(null);
                input_cor_text_lat.setText("Latitude");
                input_cor_text_lon.setText("Longitude");
                input_cor_text_alt.setText("Altitude");
                clearTextbutton();
            }
        });
        mBtninput_utm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtninput_utm.setTextColor(getResources().getColor(R.color.green));
                mBtninput_utm.setBackground(getDrawable(R.drawable.round_frame_bar_option));

                mBtnoutput_utm.setTextColor(getResources().getColor(R.color.red));

                mBtninput_gnss.setTextColor(getResources().getColor(R.color.red));
                mBtninput_hepos.setTextColor(getResources().getColor(R.color.red));
                mBtninput_gnss.setBackground(null);
                mBtninput_hepos.setBackground(null);
                input_cor_text_lat.setText("X");
                input_cor_text_lon.setText("Y");
                input_cor_text_alt.setText("Z");
                clearTextbutton();
            }
        });
        mBtninput_hepos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtninput_gnss.setTextColor(getResources().getColor(R.color.red));
                mBtninput_utm.setTextColor(getResources().getColor(R.color.red));
                mBtninput_gnss.setBackground(null);
                mBtninput_utm.setBackground(null);
                mBtnoutput_hepos.setTextColor(getResources().getColor(R.color.red));
                mBtninput_hepos.setTextColor(getResources().getColor(R.color.green));
                mBtninput_hepos.setBackground(getDrawable(R.drawable.round_frame_bar_option));
                input_cor_text_lat.setText("X");
                input_cor_text_lon.setText("Y");
                input_cor_text_alt.setText("Elevation");
                clearTextbutton();
            }
        });
    }
}






