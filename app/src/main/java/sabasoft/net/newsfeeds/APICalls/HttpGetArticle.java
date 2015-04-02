package sabasoft.net.newsfeeds.APICalls;

import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HttpGetArticle {
    String token, id;
    HttpEntity resEntityGet;

    public HttpGetArticle(String tooken, String userid) {
        this.token = tooken;
        this.id = userid;
    }
    public HttpEntity getArticles()
    {
        try {
            HttpClient client = new DefaultHttpClient();
            String getURL = "http://informerly.com/api/v1/feeds?auth_token=" + token + "&client_id=" + id;
            HttpGet get = new HttpGet(getURL);
            HttpResponse responseGet = client.execute(get);
             resEntityGet = responseGet.getEntity();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resEntityGet;
    }
}