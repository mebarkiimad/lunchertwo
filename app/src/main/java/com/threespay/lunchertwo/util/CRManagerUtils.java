package com.threespay.lunchertwo.util;

import android.util.Log;


import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.xml.bind.DatatypeConverter;
import javax.xml.datatype.DatatypeFactory;


public class CRManagerUtils {
    public enum Report {
        OK_ONLINE(0),
        OK_OFFLINE(1),
        DENIED_ONLINE(2),
        DENIED_OFFLINE(3),
        ABORT(4),
        TIME_OUT(5);
        private final int reportCode;

        Report(int reportCode) {
            this.reportCode = reportCode;
        }

        public int getReportCode() {
            return reportCode;
        }
    }

    public enum SPDHOperationStatus {
        OK(000),
        OK_WITH_TOTALS(001),
        OK_CHECK_CARDHOLDER(003),
        OK_SIGNATURE_CARDHOLDER(004),

        OK_ADMINISTRATIVE_TRANSACTION(007);
        private final int operationCode;

        SPDHOperationStatus(int operationCode) {
            this.operationCode = operationCode;
        }

        public int getOperationCode() {
            return operationCode;
        }
    }

    public enum AbortOperationStatus {
        TRANSACTION_FAILED(1);
        private final int operationCode;

        AbortOperationStatus(int operationCode) {
            this.operationCode = operationCode;
        }

        public int getOperationCode() {
            return operationCode;
        }
    }

    public enum TimeoutOperationStatus {
        INSERT_CARD_TIMEOUT(1),
        RIPPED_CARD_TIMEOUT(2),
        UNREAD_CARD_TIMEOUT(3),
        UKNONWN_CARD_TIMEOUT(4),
        MUTED_CARD_TIMEOUT(5),
        UNACCEPTED_CARD_TIMEOUT(6),
        INVALID_CARD_TIMEOUT(7),
        EXPIRED_CARD_TIMEOUT(8),
        NOCONTACTLESS_CARD_TIMEOUT(9);
        private int operationCode;

        TimeoutOperationStatus(int operationCode) {
            this.operationCode = operationCode;
        }

        public int getOperationCode() {
            return operationCode;
        }
    }
    private static final String DATE_PATTERN = "ddMMyyyyHHmmss";


    public static String signSHA256(String value) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(value.getBytes());
            byte[] digestedBytes = messageDigest.digest(value.getBytes(StandardCharsets.UTF_8));
            return DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
        } catch (Exception e) {
            return "";
        }
    }

    public static  String generateUUID(String terminalId, String cashRegisterId) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
        return simpleDateFormat.format(new Date()).concat(terminalId).concat(cashRegisterId);
    }
    public static String getWlanIP(String interfaceName) throws SocketException {
//        WifiManager wifiMgr = (WifiManager) getSystemService(WIFI_SERVICE);
//        WifiInfo wifiInfo = wifiMgr.getConnectionInfo();
//        int ip = wifiInfo.getIpAddress();
//        String ipAddress = Formatter.formatIpAddress(ip);
        for(Enumeration<NetworkInterface> list = NetworkInterface.getNetworkInterfaces(); list.hasMoreElements();)
        {
            NetworkInterface i = list.nextElement();
            // Log.e("network_interfaces", "display name " + i.getDisplayName());
            for (Enumeration<InetAddress> enumIpAddr = i.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                InetAddress inetAddress = enumIpAddr.nextElement();
                if (inetAddress instanceof Inet6Address) {
                    // It's ipv6
                } else if (inetAddress instanceof Inet4Address) {
                    // It's ipv4
                    Log.e("interface",i.getDisplayName()+"\t\t"+inetAddress.getHostAddress());
                    if(i.getDisplayName().equals(interfaceName)) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        }
        return "";
    }
}
