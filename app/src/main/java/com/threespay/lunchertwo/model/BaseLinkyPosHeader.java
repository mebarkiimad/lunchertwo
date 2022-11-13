package com.threespay.lunchertwo.model;


import com.threespay.lunchertwo.util.Constants;

import org.json.JSONException;
import org.json.JSONObject;

public class BaseLinkyPosHeader {
    String uuid;
    String timeStamp;
    String operationType;
    String terminalId;
    String cashRegisterId;

    public BaseLinkyPosHeader() {
    }

    public void init() {
        this.uuid = "";
        this.timeStamp = "";
        this.operationType = "";
        this.terminalId = "";
        this.cashRegisterId = "";
    }

    public JSONObject toJson() {
        JSONObject header = new JSONObject();
        try {
            header.put(Constants.UUID_KEY, uuid);
            header.put(Constants.TIME_STAMP_KEY, timeStamp);
            header.put(Constants.OPERATION_TYPE, operationType);
            header.put(Constants.TERMINAL_ID_KEY, terminalId);
            header.put(Constants.CASH_REGISTER_KEY, cashRegisterId);
            return header;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public BaseLinkyPosHeader fromJson(String data) {
        try {
            JSONObject header = new JSONObject(data);
            this.uuid = header.getString(Constants.UUID_KEY);
            this.timeStamp = header.getString(Constants.TIME_STAMP_KEY);
            this.terminalId = header.getString(Constants.TERMINAL_ID_KEY);
            this.cashRegisterId = header.getString(Constants.CASH_REGISTER_KEY);
            this.operationType = header.getString(Constants.OPERATION_TYPE);
            return this;
        } catch (JSONException e) {
            return null;
        }
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getCashRegisterId() {
        return cashRegisterId;
    }

    public void setCashRegisterId(String cashRegisterId) {
        this.cashRegisterId = cashRegisterId;
    }

}