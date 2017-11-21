package com.example.robin.attackontitan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    public ListView listview1;
    public String[] sometext = {"Hello", "World", "What's", "UP"};
    public String filename = "Data";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        listview1 = (ListView) findViewById(R.id.view1);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, sometext);
        listview1.setAdapter(arrayAdapter);

        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                for (int i = 0 ; sometext.length > i ; i++){
                    if(listview1.getPositionForView(view) == i){
                        toastery(sometext[i]);
                        callEintragActivity("try");
                        break;
                    }
                }
            }
        });
    }

    public void toastery(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void callEintragActivity(String p) {
        Intent myIntent = new Intent(Menu.this, EintragActivity.class);

        Menu.this.startActivity(myIntent);
    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    /*public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }*/
}
