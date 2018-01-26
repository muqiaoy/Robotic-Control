package com.example.muqiao.controller;

/**
 * Created by muqiao on 16/7/27.
 */
public class Command {
    private final String command;

    public Command(String command) {
        this.command =command;
    }

    @Override
    public String toString(){
        return this.command;
    }
}
