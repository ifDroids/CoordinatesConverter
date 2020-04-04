package com.ibo.coordinatesconv;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
//import static com.ibo.coordinatesconv.DegToUtm.*;

public class MainActivity extends AppCompatActivity{
    @BindView(R.id.altitude_layout)
    LinearLayout maltitude_llayout;
    @BindView(R.id.zone_layout)
    LinearLayout mzone_llayout;
    @BindView(R.id.input_zone)
    EditText minput_zone;
    @BindView(R.id.input_letter)
    EditText miput_letter;
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
    @BindView(R.id.input_alt)
    EditText mInputalt;
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

    double lat,lon,utmx,utmy;
    String utml;
    int utmz;

    @Override
    protected void onStart() {
        super.onStart();
        double Onstartc=0.00;
        mzone_llayout.setVisibility(View.GONE);
        maltitude_llayout.setVisibility(View.VISIBLE);
        mInputlat.setText(String.valueOf(Onstartc));
        mInputlong.setText(String.valueOf(Onstartc));
        mInputalt.setText(String.valueOf(Onstartc));
        minput_zone.setText(String.valueOf(0));
        miput_letter.setText("'S'");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        final DegToUtm convert = new DegToUtm();
        final UTMTODEG convertUtmToGnss =new UTMTODEG();


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
                Editable l=mInputalt.getText();
                utmx=Double.valueOf(String.valueOf(mInputlat.getText()));
                utmy=Double.valueOf(String.valueOf(mInputlong.getText()));
                utmz=Integer.parseInt((String.valueOf(minput_zone.getText())));
                utml=String.valueOf(miput_letter.getText());
                convertUtmToGnss.UtmToDeg(utmx,utmy,utml,utmz);
                mUtmxoutput.setText(String.valueOf(convertUtmToGnss.latitude));
                mUtmyoutput.setText(String.valueOf(convertUtmToGnss.longitude));
                Log.i("MSG",String.valueOf(convertUtmToGnss.longitude));

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
                mUtmxoutput.setText(String.valueOf(convert.Easting));
                mUtmyoutput.setText(String.valueOf((convert.Northing)));
                mUtmzone.setText((String.valueOf(convert.Zone))+(String.valueOf(convert.Letter)));


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

            }
        });
        mBtninput_gnss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mzone_llayout.setVisibility(View.GONE);
                maltitude_llayout.setVisibility(View.VISIBLE);
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


            }
        });
        mBtninput_utm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maltitude_llayout.setVisibility(View.GONE);
                mBtninput_utm.setTextColor(getResources().getColor(R.color.green));
                mBtninput_utm.setBackground(getDrawable(R.drawable.round_frame_bar_option));
                mzone_llayout.setVisibility(View.VISIBLE);
                mBtnoutput_utm.setTextColor(getResources().getColor(R.color.red));

                mBtninput_gnss.setTextColor(getResources().getColor(R.color.red));
                mBtninput_hepos.setTextColor(getResources().getColor(R.color.red));
                mBtninput_gnss.setBackground(null);
                mBtninput_hepos.setBackground(null);
                input_cor_text_lat.setText("X");
                input_cor_text_lon.setText("Y");
                input_cor_text_alt.setText("Z");

            }
        });
        mBtninput_hepos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mzone_llayout.setVisibility(View.GONE);
                maltitude_llayout.setVisibility(View.VISIBLE);
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

            }
        });
    }


}






