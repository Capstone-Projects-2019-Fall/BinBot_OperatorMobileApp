package com.example.binbot_mobiledev;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class JSONreciever extends AsyncTask<Void,Void,Void> {

    Socket socket;

    @Override
    protected Void doInBackground(Void... voids) {

        /*Get socket and pot number for connection*/
        try
        {
            socket = new Socket("", Integer.parseInt(null));

            InputStream inputStream = socket.getInputStream();


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
