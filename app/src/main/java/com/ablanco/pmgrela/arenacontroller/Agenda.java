package com.ablanco.pmgrela.arenacontroller;


import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;

public class Agenda extends AsyncTask{
    private static List<String> eventos;

    public static String getAgenda(String c){
        try{
            return (String) new Agenda().execute(c).get();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Canal "+c;
    }

    private static final String DATE_FORMAT = "dd/MM/yy HH:mm";

    private static Date getDate(String d){
        try{
            Date date = new SimpleDateFormat(DATE_FORMAT).parse(d);
            return date;
        }catch(Exception e){
            e.printStackTrace();
        }
        return new Date();
    }

    private static ArrayList getChannels(String e){
        String[] cs = e.split("/AV");
        ArrayList canales = new ArrayList();
        for(int i = 1; i < cs.length; i++){
            canales.add(cs[i]);
        }
        return canales;
    }

    private static String getTitulo(String e){
        String[] fechaYResto = e.split(" CET ");
        String[] nombreYResto = fechaYResto[1].split("/AV");
        return nombreYResto[0];
    }

    private static String html2text(String html) {
        return Jsoup.parse(html).text();
    }

    private static void getProg(){
        try {
            eventos = new ArrayList<>();
            Log.d("GET PROG", "Getting events");
            System.setProperty("http.agent",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.29 Safari/537.36");

            URL oracle = new URL("http://arenavision.in/agenda/");
            BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                if(inputLine.contains(" CET ")) {
                    String line = (html2text(inputLine));
                    eventos.add(line);
                    //Log.d("EMISION ", line);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String prog(String channel){
        if (eventos == null) getProg();

        Date dateNow = new Date();
        String lastEvent = "";
        for (Iterator<String> i = eventos.iterator(); i.hasNext();) {
            String e = i.next();
            if (!getChannels(e).contains(channel)) continue;
            Date dateEvento = getDate(e.substring(0,14));
            if (dateNow.after(dateEvento)){
                lastEvent = e;
            }else{
                return lastEvent;
            }
            /*if(dateNow.before(dateEvento)){
                return getTitulo(e);
            }*/
        }
        return lastEvent;
    }

    @Override
    protected Object doInBackground(Object[] params) {
        String r="";
        try {
            r=prog((String)params[0]);
        }catch (Exception e){
            Log.d("Error",e.getMessage());
        }
        return r;
    }
}