package pl.smsapi.sms;

/**
 * Sms Class
 * Created by Dawid Sajdak <dawid@trzy.it> on 13:37 - 20.06.13.
 */
public class Sms implements SmsInterface {

    /**
     * @var String
     */
    protected String message;

    /**
     * @var String
     */
    protected String receiver;

    /**
     * @var boolean
     */
    protected boolean isEco;

    /**
     * @var String
     */
    protected String sender;

    @Override
    public boolean getIsEco() {
        return isEco;
    }

    @Override
    public void setIsEco(boolean isEco) {
        this.isEco = isEco;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getReceiver() {
        return receiver;
    }

    @Override
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Override
    public String getSender() {
        return sender;
    }

    @Override
    public void setSender(String sender) {
        this.sender = sender;
    }
}
