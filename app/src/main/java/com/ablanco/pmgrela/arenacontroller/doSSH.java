package com.ablanco.pmgrela.arenacontroller;

import android.os.AsyncTask;
import android.util.Log;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class doSSH extends AsyncTask {
    private String[] canales = new String[] {
            "sudo reboot",
            "p2ptv-pi/tv.sh -c acestream://93c699c70e5ce13637a3e0a5fd25ec32b2927821 -t 40 -o 1",
            "p2ptv-pi/tv.sh -c acestream://fa5920df362dccf2277597549e4aa15d15375b23 -t 40 -o 1",
            "p2ptv-pi/tv.sh -c acestream://929d59a8c981f7372accda7fcae6c1e16aee2acb -t 40 -o 1",
            "p2ptv-pi/tv.sh -c acestream://59c47b9cecb9bcd641dd4dc5f5cea6393aaea155 -t 40 -o 1",
            "p2ptv-pi/tv.sh -c acestream://4f6a31bf4fba095d8bf7fd54088bc2cf655d149e -t 40 -o 1",
            "p2ptv-pi/tv.sh -c acestream://afa7e6d0f117b02bbbb005f99ceacf1e15d24459 -t 40 -o 1",
            "p2ptv-pi/tv.sh -c acestream://3508f3cef9a00bc277558ed5c21c629babec71e2 -t 40 -o 1",
            "p2ptv-pi/tv.sh -c acestream://666945c5e63abee89b46786b70e7007ddaedf652 -t 40 -o 1",
            "p2ptv-pi/tv.sh -c acestream://e88a1585d63ce11251c627ca377af22cbc27d524 -t 40 -o 1",
            "p2ptv-pi/tv.sh -c acestream://ce3c05ed699ecdb6de5768ec82aa0e7b12d14bc1 -t 40 -o 1",
            "p2ptv-pi/tv.sh -c acestream://6c9d5ebd2003ba54c95e92b65c358978759c6a5f -t 40 -o 1",
            "p2ptv-pi/tv.sh -c acestream://61985f2043e5ffbec1c67528a8fd7c2db0daf091 -t 40 -o 1",
            "p2ptv-pi/tv.sh -c acestream://c430eb7bb1e136bf41684951c0ae0bbb5a8c02ac -t 40 -o 1",
            "p2ptv-pi/tv.sh -c acestream://d63111a6899bddc8e5426e7b3aad0f3ccf93f9b2 -t 40 -o 1",
            "p2ptv-pi/tv.sh -c acestream://6ad4e6d1908728fe2435245134ee40647248511f -t 40 -o 1",
            "p2ptv-pi/tv.sh -c acestream://92653312156987e77881ca0c0b8963b0dd7719ee -t 40 -o 1",
            "p2ptv-pi/tv.sh -c acestream://4c9dc39308f19f839315753afc634ded90baf4d7 -t 40 -o 1",
            "p2ptv-pi/tv.sh -c acestream://1aa4f88b002e983c4f21377dc8988822a2b991f9 -t 40 -o 1",
            "p2ptv-pi/tv.sh -c acestream://34cd12902628c264fd68c3051e5f07980e5edc5c -t 40 -o 1",
            "p2ptv-pi/tv.sh -c sop://broker.sopcast.com:3912/258920 -o 1",
            "p2ptv-pi/tv.sh -c sop://broker.sopcast.com:3912/258921 -o 1",
            "p2ptv-pi/tv.sh -c sop://broker.sopcast.com:3912/258922 -o 1",
            "p2ptv-pi/tv.sh -c sop://broker.sopcast.com:3912/258923 -o 1",
            "p2ptv-pi/tv.sh -c sop://broker.sopcast.com:3912/258924 -o 1",
            "p2ptv-pi/tv.sh -c sop://broker.sopcast.com:3912/258925 -o 1",
            "p2ptv-pi/tv.sh -c sop://broker.sopcast.com:3912/258926 -o 1",
            "p2ptv-pi/tv.sh -c sop://broker.sopcast.com:3912/258927 -o 1",
            "p2ptv-pi/tv.sh -c sop://broker.sopcast.com:3912/258928 -o 1",
            "p2ptv-pi/tv.sh -c sop://broker.sopcast.com:3912/258929 -o 1",
            "p2ptv-pi/tv.sh -c sop://broker.sopcast.com:3912/261184 -o 1",
            "p2ptv-pi/tv.sh -c sop://broker.sopcast.com:3912/261185 -o 1",
            "p2ptv-pi/tv.sh -c sop://broker.sopcast.com:3912/259383 -o 1",
            "p2ptv-pi/tv.sh -c sop://broker.sopcast.com:3912/259509 -o 1",
            "p2ptv-pi/tv.sh -c sop://broker.sopcast.com:3912/261182 -o 1",
            "p2ptv-pi/tv.sh -c sop://broker.sopcast.com:3912/261183 -o 1",
            "sudo shutdown",
            "git clone https://github.com/alesnav/p2ptv-pi.git | sudo apt-get install w3m w3m-img -y"

    };


    @Override
    protected Object doInBackground(Object[] params) {
        try{
            ordenador(canales[(int) params[0]]);
        }catch (Exception e){
            Log.d("Error", e.getMessage());
        }
        return "OK";
    }

    private void ordenador(String canal) throws JSchException, IOException {
        String user = "pi";
        String password = "raspberry";
        String host = "192.168.0.16";
        int port = 22;

        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, port);
        session.setPassword(password);

        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();

        ChannelExec channel = (ChannelExec) session.openChannel("exec");
        BufferedReader in = new BufferedReader(new InputStreamReader(channel.getInputStream()));
        channel.setCommand(canal);
        channel.connect();
        String msg = null;

        Log.d("Mensaje SSH", msg);

        channel.disconnect();
        session.disconnect();
    }
}
