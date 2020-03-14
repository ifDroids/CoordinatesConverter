package com.ibo.coordinatesconv;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

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

//     EditText input_lat;
//     EditText input_long;
//     TextView utm_x_output;
//     TextView utm_y_output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mBtnDebug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lat= mInputlat.getText().toString();
                mUtmxoutput.setText(lat);
                Log.e("MainActivity",getString(R.string.bar_gnss));
                //mUtmxoutput.setText(mInputlat.getText().toString());

            }
        });
    }
}
