package com.threespay.lunchertwo.model;



import com.threespay.lunchertwo.util.Constants;

import org.json.JSONException;
import org.json.JSONObject;

public class BaseLinkyPosCallbackPayload {
    private String progressMessage;
    private int input;

    public BaseLinkyPosCallbackPayload() {
    }

    public BaseLinkyPosCallbackPayload(String progressMessage, int input) {
        this.progressMessage = progressMessage;
        this.input = input;
    }

    public void init() {
        progressMessage = "";
        input = 1;
    }

    public String getProgressMessage() {
        return progressMessage;
    }

    public void setProgressMessage(String progressMessage) {
        this.progressMessage = progressMessage;
    }

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public JSONObject toJson() {
        JSONObject payload = new JSONObject();
        try {
            payload.put(Constants.PROGRESS_MESSAGE_KEY, progressMessage);
            payload.put(Constants.INPUT_KEY, input);
            return payload;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public BaseLinkyPosCallbackPayload fromJson(String data) {
        try {
            JSONObject payload = new JSONObject(data);
            this.progressMessage = payload.getString(Constants.PROGRESS_MESSAGE_KEY);
            this.input = payload.getInt(Constants.INPUT_KEY);
            return this;
        } catch (JSONException e) {
            return null;
        }
    }
}