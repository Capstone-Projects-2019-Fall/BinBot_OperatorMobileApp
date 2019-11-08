package edu.temple.BinBot_OperatorMobileApp;

import androidx.appcompat.app.AppCompatActivity;
import edu.temple.BinBot_OperatorMobileApp.connections.ServerConnection;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button start;
    Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        start = findViewById(R.id.start_button);
        stop = findViewById(R.id.stop_button);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    static class MakeConnection extends AsyncTask<Void,Void,Void>{

        static final String IP = "192.168.56.1";
        static final int PORT = 7002;
        private static ServerConnection serverConnection;

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                serverConnection = new ServerConnection(IP,PORT);
            } catch (IOException e) {

            }

            return null;
        }
    }


}
