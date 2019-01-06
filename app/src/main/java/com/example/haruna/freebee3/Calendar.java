package com.example.haruna.freebee3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.haruna.freebee3.TableMainLayout;
import android.os.Bundle;
import android.app.Activity;

public class Calendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TableMainLayout(this));
    }
}
