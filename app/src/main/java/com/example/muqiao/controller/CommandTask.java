package com.example.muqiao.controller;

import android.os.AsyncTask;
/**
 * Created by muqiao on 16/7/27.
 */
public class CommandTask extends AsyncTask {
    private Command command;

    public CommandTask(Command command) {
        this.command = command;
    }

    @Override
    protected Object doInBackground(Object... objects) {
        try {
            Commander.send(command);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return new Object();
    }
}
