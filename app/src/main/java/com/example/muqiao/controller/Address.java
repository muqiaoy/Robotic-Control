package com.example.muqiao.controller;

import android.app.Application;

/**
 * Created by muqiao on 16/8/7.
 */

public class Address extends Application {
    private static String address;

    public static String getAddress() {
        return address;
    }

    public Address(String address) {
        this.address =address;
    }

    @Override
    public String toString(){
        return this.address;
    }
}