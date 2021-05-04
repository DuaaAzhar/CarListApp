package com.example.carlistapp;

public class Cars {
    String Name;
    String Number;
    int Image;
    String CarName;

    public Cars(String name, String number, int  image, String carName) {
        Name = name;
        Number = number;
        Image = image;
        CarName = carName;
    }


    public String getCarName() {
        return CarName;
    }

    public String getName() {
        return Name;
    }

    public String getNumber() {
        return Number;
    }

    public int getImage() {
        return Image;
    }


}
