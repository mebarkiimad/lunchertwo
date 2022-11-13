package com.threespay.lunchertwo.model;



import com.threespay.lunchertwo.util.Constants;

import org.json.JSONException;
import org.json.JSONObject;

public class BaseLinkyPosResponsePayload {
    private String amount;
    private String currency;
    private String scheme;
    private String trxtimestamp;
    private int authonum;
    private int opstatus;
    private String holdereceipt;
    private String merchantreceipt;
    private int report;

    public BaseLinkyPosResponsePayload () {
    }

    public void init () {
        this.amount = "";
        this.currency = "";
        this.scheme = "";
        this.trxtimestamp = "";
        this.holdereceipt = "";
        this.merchantreceipt = "";
        this.report = -1;
        this.authonum = -1;
        this.opstatus = -1;
    }

    public String getScheme () {
        return scheme;
    }

    public void setScheme ( String scheme ) {
        this.scheme = scheme;
    }

    public String getTrxtimestamp () {
        return trxtimestamp;
    }

    public void setTrxtimestamp ( String trxtimestamp ) {
        this.trxtimestamp = trxtimestamp;
    }


    public String getHoldereceipt () {
        return holdereceipt;
    }

    public void setHoldereceipt ( String holdereceipt ) {
        this.holdereceipt = holdereceipt;
    }

    public String getMerchantreceipt () {
        return merchantreceipt;
    }

    public void setMerchantreceipt ( String merchantreceipt ) {
        this.merchantreceipt = merchantreceipt;
    }

    public String getAmount () {
        return amount;
    }

    public void setAmount ( String amount ) {
        this.amount = amount;
    }

    public String getCurrency () {
        return currency;
    }

    public void setCurrency ( String currency ) {
        this.currency = currency;
    }

    public int getAuthonum () {
        return authonum;
    }

    public void setAuthonum ( int authonum ) {
        this.authonum = authonum;
    }

    public int getOpstatus () {
        return opstatus;
    }

    public void setOpstatus ( int opstatus ) {
        this.opstatus = opstatus;
    }

    public int getReport () {
        return report;
    }

    public void setReport ( int report ) {
        this.report = report;
    }

    public JSONObject toJson () {
        JSONObject payload = new JSONObject();
        try {
            payload.put(Constants.AMOUNT_KEY , amount);
            payload.put(Constants.CURRENCY_KEY , currency);
            payload.put(Constants.SCHEME_KEY , scheme);
            payload.put(Constants.TRXTIMESTAMP_KEY , trxtimestamp);
            payload.put(Constants.AUTHONUM_KEY , authonum);
            payload.put(Constants.OPSTATUS_KEY , opstatus);
            payload.put(Constants.REPORT_KEY , report);
            payload.put(Constants.HOLDERRECEIPT_KEY , holdereceipt);
            payload.put(Constants.MERCHANTRECEIPT_KEY , merchantreceipt);

            return payload;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public BaseLinkyPosResponsePayload fromJson ( String data ) {
        try {
            JSONObject payload = new JSONObject(data);
            this.amount = payload.getString(Constants.AMOUNT_KEY);
            this.currency = payload.getString(Constants.CURRENCY_KEY);
            this.scheme = payload.getString(Constants.SCHEME_KEY);
            this.trxtimestamp = payload.getString(Constants.TRXTIMESTAMP_KEY);
            this.authonum = payload.getInt(Constants.AUTHONUM_KEY);
            this.opstatus = payload.getInt(Constants.OPSTATUS_KEY);
            this.report = payload.getInt(Constants.REPORT_KEY);
            this.holdereceipt = payload.getString(Constants.HOLDERRECEIPT_KEY);
            this.merchantreceipt = payload.getString(Constants.MERCHANTRECEIPT_KEY);
            return this;
        } catch (JSONException e) {
            return null;
        }
    }

}
