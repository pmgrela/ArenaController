package com.ablanco.pmgrela.arenacontroller;

import android.util.Log;
import android.view.View;

public class ButtonListener implements View.OnClickListener {
    private int nOrden;

    ButtonListener(int n){
        nOrden = n;
    }

    @Override
    public void onClick(View v) {
        try {
            new doSSH().execute(nOrden);
        } catch (Exception e) {
            Log.d("Error", "Falla internet");
            e.printStackTrace();
        }
    }
}