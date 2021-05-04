package com.example.carlistapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CarAdapter.CarSelected {

    TextView tvName,tvNumber,tvCarName;
    Button btnCarInfo, btnOwnInfo;
    ImageView ivCar;
    View layCarInfo;
    View layOwnInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //portrait Mode
        if(findViewById(R.id.layout_portrait)!=null)
        {
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().show(manager.findFragmentById(R.id.ListFrag))
                    .hide(manager.findFragmentById(R.id.BtnFrag))
                    .hide(manager.findFragmentById(R.id.DetailFrag))
                    .commit();
        }

        //Landscape Mode
        if(findViewById(R.id.layout_Landscape)!=null)
        {
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().show(manager.findFragmentById(R.id.ListFrag))
                    .show(manager.findFragmentById(R.id.BtnFrag))
                    .show(manager.findFragmentById(R.id.DetailFrag))
                    .commit();
        }
        btnOwnInfo.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                btnOwnInfo.setBackgroundColor(getColor(R.color.grey));
                btnCarInfo.setBackgroundColor(getColor(R.color.black));
                layCarInfo.setVisibility(View.GONE);
                layOwnInfo.setVisibility(View.VISIBLE);
            }
        });
        btnCarInfo.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                btnCarInfo.setBackgroundColor(getColor(R.color.grey));
                btnOwnInfo.setBackgroundColor(getColor(R.color.black));
                layCarInfo.setVisibility(View.VISIBLE);
                layOwnInfo.setVisibility(View.GONE);

            }
        });
    }

    private void init() {
        tvName=findViewById(R.id.tvName);
        tvNumber=findViewById(R.id.tvNumber);
        tvCarName=findViewById(R.id.tvCarName);
        btnCarInfo=findViewById(R.id.btnCarInfo);
        btnOwnInfo=findViewById(R.id.btnOwnInfo);
        layCarInfo=findViewById(R.id.layCarInfo);
        layOwnInfo=findViewById(R.id.layOwnInfo);
        ivCar=findViewById(R.id.ivCar);
        layOwnInfo.setVisibility(View.GONE);
        onCarClick(0);
    }

    @Override
    public void onCarClick(int index) {
        if(findViewById(R.id.layout_portrait)!=null) {
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().hide(manager.findFragmentById(R.id.ListFrag))
                    .show(manager.findFragmentById(R.id.BtnFrag))
                    .show(manager.findFragmentById(R.id.DetailFrag))
                    .addToBackStack(null)
                    .commit();
        }
            tvName.setText(CarArray.cars.get(index).getName());
            tvNumber.setText(CarArray.cars.get(index).getNumber());
            tvCarName.setText(CarArray.cars.get(index).getCarName());
            ivCar.setImageResource(CarArray.cars.get(index).getImage());

    }
}