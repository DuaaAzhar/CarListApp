package com.example.carlistapp;

import android.app.Application;

import java.util.ArrayList;

public class CarArray extends Application {
    public static ArrayList<Cars> cars;

    @Override
    public void onCreate() {
        super.onCreate();
        cars=new ArrayList<>();
        cars.add(new Cars("Chuck Narris","03415361549", R.drawable.mercedes, "Polo"));
        cars.add(new Cars("Peter Pollok","03124008029", R.drawable.nissan,"E200" ));
        cars.add(new Cars("Chris James","03004290329",R.drawable.volkswagen ,"Almera"));
        cars.add(new Cars("John Rambo","03444034553",R.drawable.mercedes ,"E180"));
        cars.add(new Cars("Jerry Mardes","033244578029",R.drawable.nissan ,"Kombi"));
        cars.add(new Cars("Cheim Bunting","033340080984", R.drawable.volkswagen,"Honda"));
        cars.add(new Cars("Suizee Pollok","03134008838", R.drawable.nissan,"Civic" ));
        cars.add(new Cars("Reminda James","033740083847",R.drawable.volkswagen ,"Launcer"));
        cars.add(new Cars("Halvo Rambo","0322400348",R.drawable.mercedes ,"Prado"));
        cars.add(new Cars("Zerein Mardes","0303400878683",R.drawable.nissan ,"Santro"));
        cars.add(new Cars("Debble Bunting","030440087834", R.drawable.volkswagen,"Alpha"));


    }
}
