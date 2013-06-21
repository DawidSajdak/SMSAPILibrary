package pl.smsapi;

import pl.smsapi.http.HttpClient;
import pl.smsapi.http.Response;
import pl.smsapi.sms.Sms;

import java.util.ArrayList;

/**
 * Client class
 * Created by Dawid Sajdak <dawid@trzy.it> on 12:37 - 19.06.13.
 */
public class Client {

    /**
     * @var String
     */
    protected String apiURL = "https://ssl.smsapi.pl/sms.do";

    /**
     * @var String
     */
    protected String login;

    /**
     * @var String
     */
    protected String password;

    /**
     * @var boolean
     */
    protected boolean isDebugMode = false;

    /**
     * Client constructor
     */
    public Client() {}

    /**
     * Client constructor
     * @param login Client login
     * @param password Client password
     */
    public Client(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * Client constructor
     * @param login Client login
     * @param password Client password
     * @param isDebugMode isDebugMode
     */
    public Client(String login, String password, boolean isDebugMode) {
        this.login = login;
        this.password = password;
        this.isDebugMode = isDebugMode;
    }

    /**
     * Get api url
     * @return String
     */
    public String getApiUrl() {
        return this.apiURL;
    }

    /**
     * Is debug mode
     * @return boolean
     */
    public boolean isDebugMode() {
        return isDebugMode;
    }

    /**
     * Send SMS
     * @param sms Sms - See {@link pl.smsapi.sms.Sms}
     * @return Response
     */
    public Response sendSms(Sms sms) {
        HttpClient httpClient = new HttpClient(buildSmsQueryParams(sms));
        Response response = new Response(httpClient.postData());

        return response;
    }

    /**
     * Get account balance
     * @return Response
     */
    public Response getBalance() {

        ArrayList<HttpClient.ValuePair<String, String>> valuePairs = new ArrayList<HttpClient.ValuePair<String, String>>();

        HttpClient.ValuePair<String, String> valuePair = new HttpClient.ValuePair<String, String>();
        valuePair.value = "credits";
        valuePair.description = "1";

        valuePairs.add(0, valuePair);

        valuePair.value = "details";
        valuePair.description = "1";

        valuePairs.add(1, valuePair);

        HttpClient httpClient = new HttpClient(valuePairs);
        Response response = new Response(httpClient.postData());

        return response;
    }

    /**
     * Build query params
     * @param sms Sms
     * @return ArrayList<HttpClient.ValuePair<String, String>>
     */
    protected ArrayList<HttpClient.ValuePair<String, String>> buildSmsQueryParams(Sms sms) {

        ArrayList<HttpClient.ValuePair<String, String>> valuePairs = new ArrayList<HttpClient.ValuePair<String, String>>();

        HttpClient.ValuePair<String, String> valuePair = new HttpClient.ValuePair<String, String>();

        valuePair.value = "message";
        valuePair.description = sms.getMessage();

        valuePairs.add(0, valuePair);

        valuePair.value = "to";
        valuePair.description = sms.getReceiver();

        valuePairs.add(1, valuePair);

        if(sms.getIsEco()) {
            valuePair.value = "eco";
            valuePair.description = "1";

            valuePairs.add(2, valuePair);
        }else if(sms.getReceiver() != null) {
            valuePair.value = "from";
            valuePair.description = sms.getReceiver();

            valuePairs.add(2, valuePair);
        }

        return valuePairs;
    }
}
