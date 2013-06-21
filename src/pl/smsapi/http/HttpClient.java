package pl.smsapi.http;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import pl.smsapi.Client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Client class
 * Created by Dawid Sajdak <dawid@trzy.it> on 16:30 - 20.06.13.
 */
public class HttpClient {

    /**
     * @var Class
     */
    Client client;

    /**
     * @var ArrayList
     */
    ArrayList<ValuePair<String, String>> nameValuePair;

    /**
     * HttpClient constructor
     */
    public HttpClient(ArrayList<ValuePair<String, String>> nameValuePair) {
        this.nameValuePair = nameValuePair;
        client = new Client();
    }

    /**
     * Send post
     */
    public String postData() {
        // Create a new HttpClient and Post Header
        org.apache.http.client.HttpClient httpClient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(client.getApiUrl());

        try {
            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(nameValuePair.size());
            for (ValuePair<String, String> valuePair : nameValuePair) {
                nameValuePairs.add(new BasicNameValuePair(valuePair.description, valuePair.value));
            }
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Execute HTTP Post Request
            HttpResponse response = httpClient.execute(httppost);

            return response.toString();

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * ValuePair Class
     *
     * @param <E> Object
     * @param <F> Object
     */
    public static class ValuePair<E, F> {
        public E description;
        public F value;
    }
}
