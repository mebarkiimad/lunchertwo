package com.threespay.lunchertwo.model;



import com.threespay.lunchertwo.util.CRManagerUtils;
import com.threespay.lunchertwo.util.Constants;

import org.json.JSONException;
import org.json.JSONObject;

public class BaseLinkyPosSignature {
    String sha256;

    public BaseLinkyPosSignature ( String sha256 ) {
        this.sha256 = sha256;
    }

    public BaseLinkyPosSignature () {
    }
    public void init() {
        this.sha256 = "";
    }

    public JSONObject toJson () {
        JSONObject signature = new JSONObject();
        try {
            signature.put(Constants.SHA_256_KEY , sha256);
            return signature;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public BaseLinkyPosSignature fromJson ( String data ) {
        try {
            JSONObject signature = new JSONObject(data);
            this.sha256 = signature.getString(Constants.SHA_256_KEY);
            return this;
        } catch (JSONException e) {
            return null;
        }
    }

    public String getSha256 () {
        return sha256;
    }

    public void setSha256 ( String sha256 ) {
        this.sha256 = sha256;
    }
    public String generateSignature(String message) {
        String hashValue = "";
        try {

            hashValue = CRManagerUtils.signSHA256(message);

        }
        catch(Exception e) {

        }
        this.sha256 = hashValue;
        return hashValue;
    }
}
