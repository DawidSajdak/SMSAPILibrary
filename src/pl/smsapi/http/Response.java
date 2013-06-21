package pl.smsapi.http;

import android.util.Log;
import pl.smsapi.utils.SmsUtils;

/**
 * Class Response
 * Created by Dawid Sajdak <dawid@trzy.it> on 13:16 - 21.06.13.
 */
public class Response {

    /**
     * @var String
     */
    protected String responseText;

    /**
     * @var String
     */
    protected String id;

    /**
     * @var boolean
     */
    protected boolean valid;

    /**
     * Response constructor
     * @param responseText String
     */
    public Response(String responseText) {
        this.responseText = responseText;

        parseResponseText(); //Parse response
    }

    /**
     * Parse response
     */
    protected void parseResponseText() {
        if(SmsUtils.isNullOrEmpty(responseText)) {
            Log.e("ERROR SMS API", "Error during get response text.");
        }else {

        }
    }
}
