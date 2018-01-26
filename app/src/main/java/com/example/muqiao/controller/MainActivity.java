package com.example.muqiao.controller;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.net.Socket;
import java.io.PrintWriter;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_UP;


public class MainActivity extends AppCompatActivity {

    private static HashMap<Integer, Command> commandMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setListener();
    }

    private void init() {
        Button connect = (Button) findViewById(R.id.Connect);
        final TextView tv = (TextView) findViewById(R.id.tv);
        connect.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new Address(tv.getText().toString().trim());
                    }
                });
    }

    private void setListener() {

        setListener(R.id.Right);
        setListener(R.id.Left);
        setListener(R.id.Forward);
        setListener(R.id.Backward);
        setListener(R.id.Button01);
        setListener(R.id.Button02);
        setListener(R.id.Button03);
        setListener(R.id.Button04);
        setListener(R.id.Infra_red);
    }

    private void setListener(int button_id) {
        Button button = (Button) findViewById(button_id);
        button.setOnTouchListener(newListener());
    }

    private View.OnTouchListener newListener() {
        return new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return MainActivity.this.onTouch(view, motionEvent);
            }
        };
    }


    private boolean onTouch(View view, MotionEvent motionEvent) {
        if (commandMap == null) {
            commandMap = new HashMap<Integer, Command>();
            commandMap.put(R.id.Left, new Command("left"));
            commandMap.put(R.id.Right, new Command("right"));
            commandMap.put(R.id.Forward, new Command("forward"));
            commandMap.put(R.id.Backward, new Command("backward"));
            commandMap.put(R.id.Button01, new Command("one"));
            commandMap.put(R.id.Button02, new Command("two"));
            commandMap.put(R.id.Button03, new Command("three"));
            commandMap.put(R.id.Button04, new Command("four"));
            commandMap.put(R.id.Infra_red, new Command("red"));
        }

        if (ACTION_DOWN == motionEvent.getAction()) {
            sendCommand(commandMap.get(view.getId()));
        }

        if (ACTION_UP == motionEvent.getAction()) {
            sendCommand(new Command("stop"));
        }
        return false;
    }

    private void sendCommand(Command command) {
        CommandTask commandTask = new CommandTask(command);
        commandTask.execute();
    }
}
