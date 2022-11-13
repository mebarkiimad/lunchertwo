package com.threespay.lunchertwo.model;




import com.threespay.lunchertwo.util.Constants;

import org.json.JSONException;
import org.json.JSONObject;

public class BaseLinkyPosPayload {
    private Long amount;
    private String currency;

    public BaseLinkyPosPayload() {
    }

    public BaseLinkyPosPayload(Long amount, String currency, String progressMessage) {
        this.amount = amount;
        this.currency = currency;
    }

    public void init() {
        this.amount = 0L;
        this.currency = "";
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public JSONObject toJson() {
        JSONObject payload = new JSONObject();
        try {
            payload.put(Constants.AMOUNT_KEY, amount);
            payload.put(Constants.CURRENCY_KEY, currency);
            return payload;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public BaseLinkyPosPayload fromJson(String data) {
        try {
            JSONObject payload = new JSONObject(data);
            this.amount = payload.getLong(Constants.AMOUNT_KEY);
            this.currency = payload.getString(Constants.CURRENCY_KEY);
            return this;
        } catch (JSONException e) {
            return null;
        }
    }

}