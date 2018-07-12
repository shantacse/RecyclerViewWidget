package com.example.shantacse.recyclear_veiw_in_online;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.shantacse.recyclear_veiw_in_online.adapter.employeeadapter;
import com.example.shantacse.recyclear_veiw_in_online.model.employee;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    List<employee> employeealllist;
    employeeadapter empadapter;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rv = findViewById(R.id.myrecycle);
        rv.setHasFixedSize(true);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        employeealllist = new ArrayList<>();
        //url = getString(R.string.baseurl)+"fetchteamprofile.php";
        url="http://192.168.43.243/shanta/fetchteamprofile.php";
        getalldata();

    }


    public void getalldata()
    {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                Log.d(String.valueOf(response),"coxtunes");

                for (int i = 0 ; i < response.length(); i++)
                {

                    try
                    {
                        JSONObject object = response.getJSONObject(i);

                        //-------add binded data to list throw model class-----///
                        employeealllist.add(new employee(

                                object.getString("image"),
                                object.getString("Name"),
                                object.getString("designation"),
                                object.getString("study"),
                                object.getString("email")

                                ));


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    //----------adding data to recycler view----//
                    empadapter = new employeeadapter(employeealllist,MainActivity.this);
                    rv.setAdapter(empadapter);


                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "SOMETHINGS WENT WRONG", Toast.LENGTH_LONG).show();
            }
        });

        com.example.shantacse.recyclear_veiw_in_online.remote.AppController.getInstance().addToRequestQueue(jsonArrayRequest);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
