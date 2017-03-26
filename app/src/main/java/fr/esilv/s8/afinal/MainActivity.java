package fr.esilv.s8.afinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

import fr.esilv.s8.afinal.adapters.youtubeAdapter;
import fr.esilv.s8.afinal.models.Item;
import fr.esilv.s8.afinal.models.Youtube;

import static android.R.attr.button;



public class MainActivity extends AppCompatActivity {
/*
Develop an app that will use the YouTube Data API
 to search for Videos with a keyword search.
You will display the results in a List.
In a cell, some basic information will be displayed,
 such as the title, the description,
 the publication date, the author,
 and a thumbnail of the video.
When a cell is clicked, another page is opened
with more details, and, if possible,
an embedded YouTube player that will play the video.
Additionally, you will save every previous search
 to give the user suggestions
when they type some text to research.

Pour mettre des Objets complexes dans un Intent,
vous pouvez utiliser Serializable

Pour afficher des images à partir de leur url:
-Glide ou Picasso
(bibliothèqe externes)

Pour vous rassurer:
-Liste: 5 pts
-Cellule designée: 5 pts
-Détail: 3 pts
-Désign général: 4 pts
-Player: 3 pts
-SharedPreferences: 4 pts
*/


    //key=AIzaSyC-qJQW7ASeMB1K75vYkvsHRLRS30wqObY
    //ket2=AIzaSyB4qagEliGYNgmjkzwJHKdf2KTpyVSUf0E
    private String browserkey="AIzaSyAGTZpt7bb4yDkTLhQYTNsxnuG3LNFfRw8";
    private TextView mTextView;
    private EditText editText;
    private RecyclerView recyclerView;

    private void initializeRecyclerView()
    {
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initializeAdapter(List<Item> items) {
        youtubeAdapter adapter = new youtubeAdapter(items);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView mTextView = (TextView) findViewById(R.id.text);
        final Button button=(Button) findViewById(R.id.button);
        initializeRecyclerView();

        /*String query="skateboarding+dog";

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

        String url="https://www.googleapis.com/youtube/v3/search?part=snippet&order=viewCount&q="+query+"&type=video&videoDefinition=high&key="+browserkey;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        mTextView.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!"+error);
            }

        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);*/
    }
    public void youtubeQuery(View v)
    {
        mTextView = (TextView) findViewById(R.id.text);
        editText= (EditText) findViewById(R.id.editText);
        //mTextView.setText(editText.toString());
        String query=editText.getText().toString();
        query=query.replace(" ","+");

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

        String url="https://www.googleapis.com/youtube/v3/search?part=snippet&order=viewCount&q="+query+"&type=video&videoDefinition=high&key="+browserkey;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //mTextView.setText("Response is: "+ response.substring(500,1500));
                       // mTextView.setText(response.getClass().toString());
                       // response.fromJson();
                        String json = response;
                        Gson gson=new Gson();
                        Youtube youtube=gson.fromJson(response,Youtube.class);


                        try {
                           // Log.d("youtube",youtube.getKind());
                            //Log.d("youtube",youtube.getItems().get(0).getSnippet().getTitle());
                           //JSONObject obj = new JSONObject(json);
                            //Log.d("MyApp",obj.toString());
                            //Log.d("test",obj.get("items").toString());
                            //Log.d("test",obj.names().toString());
                          //  Log.d("My App", obj.toString());

                            initializeAdapter(youtube.getItems());

                        } catch (Throwable t) {
                            Log.e("My App", "Could not parse malformed JSON: \"" + json + "\"");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // mTextView.setText("That didn't work!"+error);
            }

    });
        queue.add(stringRequest);

}

}
