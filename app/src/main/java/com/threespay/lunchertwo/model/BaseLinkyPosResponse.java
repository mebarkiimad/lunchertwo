package com.threespay.lunchertwo.model;


import com.threespay.lunchertwo.util.Constants;

import org.json.JSONException;
import org.json.JSONObject;

public class BaseLinkyPosResponse {
    private BaseLinkyPosResponsePayload payload;
    private BaseLinkyPosHeader header;
    private BaseLinkyPosSignature signature;

    public BaseLinkyPosResponse(BaseLinkyPosHeader header, BaseLinkyPosResponsePayload payload, BaseLinkyPosSignature signature) {
        this.header = header;
        this.payload = payload;
        this.signature = signature;
    }

    public BaseLinkyPosResponse() {
        this.header = new BaseLinkyPosHeader();
        this.payload = new BaseLinkyPosResponsePayload();
        this.signature = new BaseLinkyPosSignature();
    }

    public void init() {
        this.header.init();
        this.payload.init();
        this.signature.init();
    }

    public BaseLinkyPosResponsePayload getPayload() {
        return payload;
    }

    public void setPayload(BaseLinkyPosResponsePayload payload) {
        this.payload = payload;
    }

    public BaseLinkyPosHeader getHeader() {
        return header;
    }

    public void setHeader(BaseLinkyPosHeader header) {
        this.header = header;
    }

    public BaseLinkyPosSignature getSignature() {
        return signature;
    }

    public void setSignature(BaseLinkyPosSignature signature) {
        this.signature = signature;
    }

    public BaseLinkyPosResponse fromJson(String data) {
        try {
            JSONObject message = new JSONObject(data);
            JSONObject headerJsonObject = message.getJSONObject(Constants.HEADER_KEY);
            JSONObject payloadJsonObject = message.getJSONObject(Constants.PAYLOAD_KEY);
            JSONObject signatureJsonObject = message.getJSONObject(Constants.SIGNATURE_KEY);
            BaseLinkyPosHeader header = new BaseLinkyPosHeader();
            BaseLinkyPosResponsePayload payload = new BaseLinkyPosResponsePayload();
            BaseLinkyPosSignature signature = new BaseLinkyPosSignature();
            header.fromJson(headerJsonObject.toString());
            payload.fromJson(payloadJsonObject.toString());
            signature.fromJson(signatureJsonObject.toString());
            this.header = header;
            this.payload = payload;
            this.signature = signature;
            return this;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject toJson() {
        JSONObject message = new JSONObject();
        try {
            JSONObject headerObject = this.header.toJson();
            JSONObject payloadObject = this.payload.toJson();
            JSONObject signatureObject = this.signature.toJson();
            if (headerObject == null || payloadObject == null) {
                return null;
            }
            message.put(Constants.HEADER_KEY, headerObject);
            message.put(Constants.PAYLOAD_KEY, payloadObject);
            message.put(Constants.SIGNATURE_KEY, signatureObject);
            return message;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void generateSignature(){
        this.signature.generateSignature(header.toJson().toString() + payload.toJson().toString());
    }
}