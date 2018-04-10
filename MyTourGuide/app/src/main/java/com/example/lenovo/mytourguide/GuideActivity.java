package com.example.lenovo.mytourguide;

/**
 * Created by lenovo on 08-04-2018.
 */
import java.io.ByteArrayInputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import android.os.StrictMode;
import com.example.lenovo.mytourguide.R;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.app.Activity;

import android.os.Bundle;
import android.util.Log;

import android.widget.TextView;

public class GuideActivity extends Activity
{

    private WebView webview;

    //***** Called when the activity is first created *****
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        final String TAG = "Activity2";


        String ln = getIntent().getExtras().getString("tag");
        if((ln.equals("Español"))|| (ln.equals("Spanish")))
        {
            TextView t1 = (TextView) findViewById(R.id.thanks);
            t1.setText("Gracias por usar mi aplicación.");


            TextView t2 = (TextView) findViewById(R.id.link);
            t2.setText("Las ubicaciones de visitantes en el interior " + getIntent().getExtras().getString("com.example.lenovo.mytourguide.radius") + " millas para " +getIntent().getExtras().getString("com.example.lenovo.mytourguide.location"));

        }
        else
        {
            TextView t1 = (TextView) findViewById(R.id.thanks);
            t1.setText("Happy Travelling!!.");


            TextView t2 = (TextView) findViewById(R.id.link);
            t2.setText("Visitor locations found within " + getIntent().getExtras().getString("com.example.lenovo.mytourguide.radius") + " miles for " +getIntent().getExtras().getString("com.example.lenovo.mytourguide.location"));


        }

        String url = getIntent().getExtras().getString("com.example.lenovo.mytourguide.link");
        Log.i(TAG, url);

        try{
            //***** Parsing the xml file*****
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            XMLReader xr = sp.getXMLReader();

            tgparse myXML_parser = new tgparse();
            xr.setContentHandler(myXML_parser);


            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(url.replace(" ", "%20"));
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httpget, responseHandler);
            Log.i(TAG,"responseBody: " + responseBody);
            ByteArrayInputStream is = new ByteArrayInputStream(responseBody.getBytes());
            xr.parse(new InputSource(is));


            Log.i(TAG, "parse complete");


            TextView placename[];
            TextView placeaddress[];
            TextView placerating[];

            tgxml data;
            data = tgparse.getXMLData();
            placename = new TextView[data.getName().size()];
            placeaddress = new TextView[data.getName().size()];
            placerating = new TextView[data.getName().size()];

            webview = (WebView) findViewById(R.id.myWebView);
            webview.getSettings().setJavaScriptEnabled(true);
            webview.setWebViewClient(new WebViewClient());
            //    webview.setBackgroundColor(0);
            //  webview.setBackgroundResource(R.drawable.openbook);

            String stg1 = new String();
            stg1 = "<html>";
            for (int i = 1; i < (data.getName().size()); i++) {
                Log.i(TAG, " "+i );
                Log.i(TAG, "Name= "+data.getName().get(i));
                Log.i(TAG, "Address= "+data.getAddress().get(i));
                Log.i(TAG, "Rating= "+data.getRating().get(i));

                placename[i] = new TextView(this);
                placename[i].setText("Name= "+data.getName().get(i));

                placeaddress[i] = new TextView(this);
                placeaddress[i].setText("Address= "+data.getAddress().get(i));

                placerating[i] = new TextView(this);
                placerating[i].setText("Rating= "+data.getRating().get(i));


                if((ln.equals("Español"))|| (ln.equals("Spanish")))
                {
                    stg1 = stg1 + "Nombre: " + data.getName().get(i) + "<br>" + " Dirección: "+data.getAddress().get(i) + "<br>" + " clasificación= "+data.getRating().get(i) + "<br>" + "<br>";
                }
                else
                {
                    stg1 = stg1 + "Name: " + data.getName().get(i) + "<br>" + " Address: "+data.getAddress().get(i) + "<br>" + " Rating= "+data.getRating().get(i) + "<br>" + "<br>";
                }

            }
            stg1 = stg1 + "</html>";
            webview.loadDataWithBaseURL(null, stg1, "text/html", "utf-8","about:blank");

        }
        catch(Exception e)
        {
            Log.i(TAG, "Exception caught", e);

        }


    }



}