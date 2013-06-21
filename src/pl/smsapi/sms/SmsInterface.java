package pl.smsapi.sms;

/**
 * Sms interface
 * Created by Dawid Sajdak <dawid@trzy.it> on 16:05 - 20.06.13.
 */
public interface SmsInterface {

    public boolean isEco();

    public void setIsEco(boolean isEco);

    public String getMessage();

    public void setMessage(String message);

    public String getReceiver();

    public void setReceiver(String receiver);

    public String getSender();

    public void setSender(String sender);
}
