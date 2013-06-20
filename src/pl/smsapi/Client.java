package pl.smsapi;

import pl.smsapi.sms.Sms;

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

    public String getApiUrl() {
        return this.apiURL;
    }

    /**
     * Send SMS
     * @param sms Sms - See {@link pl.smsapi.sms.Sms}
     */
    public void sendSms(Sms sms) {

    }

    public void getBalance() {

    }
}
