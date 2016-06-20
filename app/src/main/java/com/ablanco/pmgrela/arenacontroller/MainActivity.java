package com.ablanco.pmgrela.arenacontroller;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

// It's needed to add this line KexAlgorithms diffie-hellman-group1-sha1,diffie-hellman-group-exchange-sha1 on /etc/ssh/sshd_config
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Acestream buttons
        Button b1 = (Button) findViewById(R.id.button1);
        if (b1 != null) {
            b1.setText("AV1: "+Agenda.getAgenda("1"));
            b1.setOnClickListener(new ButtonListener(1)); }

        Button b2 = (Button) findViewById(R.id.button2);
        if (b2 != null) {
            b2.setText("AV2: "+Agenda.getAgenda("2"));
            b2.setOnClickListener(new ButtonListener(2)); }

        Button b3 = (Button) findViewById(R.id.button3);
        if (b3 != null) {
            b3.setText("AV3: "+Agenda.getAgenda("3"));
            b3.setOnClickListener(new ButtonListener(3)); }

        Button b4 = (Button) findViewById(R.id.button4);
        if (b4 != null) {
            b4.setText("AV4: "+Agenda.getAgenda("4"));
            b4.setOnClickListener(new ButtonListener(4)); }

        Button b5 = (Button) findViewById(R.id.button5);
        if (b5 != null) {
            b5.setText("AV5: "+Agenda.getAgenda("5"));
            b5.setOnClickListener(new ButtonListener(5)); }

        Button b6 = (Button) findViewById(R.id.button6);
        if (b6 != null) {
            b6.setText("AV6: "+Agenda.getAgenda("6"));
            b6.setOnClickListener(new ButtonListener(6)); }

        Button b7 = (Button) findViewById(R.id.button7);
        if (b7 != null) {
            b7.setText("AV7: "+Agenda.getAgenda("7"));
            b7.setOnClickListener(new ButtonListener(7)); }

        Button b8 = (Button) findViewById(R.id.button8);
        if (b8 != null) {
            b8.setText("AV8: "+Agenda.getAgenda("8"));
            b8.setOnClickListener(new ButtonListener(8)); }

        Button b9 = (Button) findViewById(R.id.button9);
        if (b9 != null) {
            b9.setText("AV9: "+Agenda.getAgenda("9"));
            b9.setOnClickListener(new ButtonListener(9)); }

        Button b10 = (Button) findViewById(R.id.button10);
        if (b10 != null) {
            b10.setText("AV10: "+Agenda.getAgenda("10"));
            b10.setOnClickListener(new ButtonListener(10)); }

        Button b11 = (Button) findViewById(R.id.button11);
        if (b11 != null) {
            b11.setText("AV11: "+Agenda.getAgenda("11"));
            b11.setOnClickListener(new ButtonListener(11)); }

        Button b12 = (Button) findViewById(R.id.button12);
        if (b12 != null) {
            b12.setText("AV12: "+Agenda.getAgenda("12"));
            b12.setOnClickListener(new ButtonListener(12)); }

        Button b13 = (Button) findViewById(R.id.button13);
        if (b13 != null) {
            b13.setText("AV13: "+Agenda.getAgenda("13"));
            b13.setOnClickListener(new ButtonListener(13)); }

        Button b14 = (Button) findViewById(R.id.button14);
        if (b14 != null) {
            b14.setText("AV14: "+Agenda.getAgenda("14"));
            b14.setOnClickListener(new ButtonListener(14)); }

        Button b15 = (Button) findViewById(R.id.button15);
        if (b15 != null) {
            b15.setText("AV15: "+Agenda.getAgenda("15"));
            b15.setOnClickListener(new ButtonListener(15)); }

        //Sopcast buttons
        Button b16 = (Button) findViewById(R.id.button16);
        if (b16 != null) {
            b16.setText("AV16: "+Agenda.getAgenda("16"));
            b16.setOnClickListener(new ButtonListener(16)); }

        Button b17 = (Button) findViewById(R.id.button17);
        if (b17 != null) {
            b17.setText("AV17: "+Agenda.getAgenda("17"));
            b17.setOnClickListener(new ButtonListener(17)); }

        Button b18 = (Button) findViewById(R.id.button18);
        if (b18 != null) {
            b18.setText("AV18: "+Agenda.getAgenda("18"));
            b18.setOnClickListener(new ButtonListener(18)); }

        Button b19 = (Button) findViewById(R.id.button19);
        if (b19 != null) {
            b19.setText("AV19: "+Agenda.getAgenda("19"));
            b19.setOnClickListener(new ButtonListener(19)); }

        Button b20 = (Button) findViewById(R.id.button20);
        if (b20 != null) {
            b20.setText("AV20: "+Agenda.getAgenda("20"));
            b20.setOnClickListener(new ButtonListener(20)); }

        Button b21 = (Button) findViewById(R.id.button21);
        if (b21 != null) {
            b21.setText("AV21: "+Agenda.getAgenda("21"));
            b21.setOnClickListener(new ButtonListener(21)); }

        Button b22 = (Button) findViewById(R.id.button22);
        if (b22 != null) {
            b22.setText("AV22: "+Agenda.getAgenda("22"));
            b22.setOnClickListener(new ButtonListener(22)); }

        Button b23 = (Button) findViewById(R.id.button23);
        if (b23 != null) {
            b23.setText("AV23: "+Agenda.getAgenda("23"));
            b23.setOnClickListener(new ButtonListener(23)); }

        Button b24 = (Button) findViewById(R.id.button24);
        if (b24 != null) {
            b24.setText("AV24: "+Agenda.getAgenda("24"));
            b24.setOnClickListener(new ButtonListener(24)); }

        Button b25 = (Button) findViewById(R.id.button25);
        if (b25 != null) {
            b25.setText("AV25: "+Agenda.getAgenda("25"));
            b25.setOnClickListener(new ButtonListener(25)); }

        Button b26 = (Button) findViewById(R.id.button26);
        if (b26 != null) {
            b26.setText("AV26: "+Agenda.getAgenda("26"));
            b26.setOnClickListener(new ButtonListener(26)); }

        Button b27 = (Button) findViewById(R.id.button27);
        if (b27 != null) {
            b27.setText("AV27: "+Agenda.getAgenda("27"));
            b27.setOnClickListener(new ButtonListener(27)); }

        Button b28 = (Button) findViewById(R.id.button28);
        if (b28 != null) {
            b28.setText("AV28: "+Agenda.getAgenda("28"));
            b28.setOnClickListener(new ButtonListener(28)); }

        Button b29 = (Button) findViewById(R.id.button29);
        if (b29 != null) {
            b29.setText("AV29: "+Agenda.getAgenda("29"));
            b29.setOnClickListener(new ButtonListener(29)); }

        Button b30 = (Button) findViewById(R.id.button30);
        if (b30 != null) {
            b30.setText("AV30: "+Agenda.getAgenda("30"));
            b30.setOnClickListener(new ButtonListener(30)); }

        Button b31 = (Button) findViewById(R.id.button31);
        if (b31 != null) {
            b31.setText("AV31: "+Agenda.getAgenda("31"));
            b31.setOnClickListener(new ButtonListener(31)); }

        Button b32 = (Button) findViewById(R.id.button32);
        if (b32 != null) {
            b32.setText("AV32: "+Agenda.getAgenda("32"));
            b32.setOnClickListener(new ButtonListener(32)); }

        Button b33 = (Button) findViewById(R.id.button33);
        if (b33 != null) {
            b33.setText("AV33: "+Agenda.getAgenda("33"));
            b33.setOnClickListener(new ButtonListener(33)); }

        Button b34 = (Button) findViewById(R.id.button34);
        if (b34 != null) {
            b34.setText("AV34: "+Agenda.getAgenda("34"));
            b34.setOnClickListener(new ButtonListener(34)); }

        Button b35 = (Button) findViewById(R.id.button35);
        if (b35 != null) {
            b35.setText("AV35: "+Agenda.getAgenda("35"));
            b35.setOnClickListener(new ButtonListener(35)); }

        Button b36 = (Button) findViewById(R.id.button36);
        if (b36 != null) {
            b36.setText("AV36: "+Agenda.getAgenda("36"));
            b36.setOnClickListener(new ButtonListener(36)); }


        Button bApagar = (Button) findViewById(R.id.buttonapagar);
        if (bApagar != null) { bApagar.setOnClickListener(new ButtonListener(36)); }

        Button bReiniciar = (Button) findViewById(R.id.buttonreboot);
        if (bReiniciar != null) { bReiniciar.setOnClickListener(new ButtonListener(0)); }

        Button bInstalar = (Button) findViewById(R.id.buttonInstalar);
        if (bInstalar != null) { bInstalar.setOnClickListener(new ButtonListener(38)); }

        Button bAgenda = (Button) findViewById(R.id.buttonagenda);
        if (bAgenda != null) { bAgenda.setOnClickListener(new ButtonListener(39)); }
    }


}



