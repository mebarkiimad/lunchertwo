package com.threespay.lunchertwo.util;

public class Constants {

    public static String url = "http://192.168.137.1:2000/";
    public static final String DB_NAME = "cib_pay.db";

    public static final long NULL_INDEX = -1L;
    public static final String EMPTY= "";
    public static final Integer ZERO = 0;
    public static final Boolean FALSE = false;

    public static final String PREF_NAME = "cib_pay_pref";
    public static final String SUPER_MERCHANT_PASSWORD = "super_merchant_password";
    public static final String MAINTAINER_PASSWORD = "maintainer_password";

    public static final String LANGUAGE_PREF = "language_pref";

    public static final String Currency = " DA";

    public static final int MinValideAmount=0;
    public static final String DefaultAmount= "0,00";
    public static final int MaxValideAmount=3000000;
    public static final int MaxValideAmountContactless=300000;
    public static final String ISREGISTRATION = "is_registration";
    public static final String IS_TERMINAL_ACTIVE = "is_terminal_active";
    public static final String PARAMETER_PASSWORD = "parameter_password";
    public static final String PASSWORD_MAINTENEUR ="password_mainteneur" ;
    public static final String PASSWORD_MERCHANT ="password_merchant" ;

    public static final String FILE_N="1234";
    public static final int PreAutoAmount = 10000;
    public static final String TMS_CALL_TYPE = "tms_call_type" ;
    public static final String TMS_CALL_INIT = "tms_call_init";
    public static final String TMS_CALL_PARA_DOWNLOAD = "tms_call_para_download";
    public static final String AAS_CALL_PARA_DOWNLOAD = "aas_call_para_download";
    public static final String RECEIPT_TRANSDETAIL = "receipt_transDetail";


    public static final String SeparationCharacter = "\u001C";
    public static final String SubFIDSeparationCharacter = "\u001E";
    public static final String EndOfTransmissionCharacter = "\u0003";


    public static final String MAINTAINER_MENU = "maintener_menu";
    public static final String PANBLOCK = "PANBLOCK";
    public static final String ENTERPINTYPE = "ENTERPINTYPE";
    public static final String SUPPORTBYPASS = "SUPPORTBYPASS";


    public static final Integer LUNCH_AAS_DOWNLOAD = 1;
    public static final Integer OBTAIN_SIGNATURE = 2;


    //LINKYPOS CALLBACKS MESSAGES
    public static final String PROGRESSMSG_TRANSACTION_PURCHASE = "PROGRESSMSG_TRANSACTION_PURCHASE";
    public static final String CASHREGISTER_PROGRESSMSG = "CASHREGISTER_PROGRESSMSG";
    public static final String PROGRESSMSG_INSERT_CARD = "PROGRESSMSG_INSERT_CARD";
    public static final String PROGRESSMSG_INSERT_CARD_TIMEOUT = "PROGRESSMSG_INSERT_CARD_TIMEOUT";
    public static final String PROGRESSMSG_RIPPED_CARD_TIMEOUT = "PROGRESSMSG_RIPPED_CARD_TIMEOUT";
    public static final String PROGRESSMSG_UNREAD_CARD_TIMEOUT = "PROGRESSMSG_UNREAD_CARD_TIMEOUT";
    public static final String PROGRESSMSG_UKNONWN_CARD_TIMEOUT = "PROGRESSMSG_UNKNOWN_CARD_TIMEOUT";
    public static final String PROGRESSMSG_MUTED_CARD_TIMEOUT = "PROGRESSMSG_MUTED_CARD_TIMEOUT";
    public static final String PROGRESSMSG_UNACCEPTED_CARD_TIMEOUT = "PROGRESSMSG_UNACCEPTED_CARD_TIMEOUT";
    public static final String PROGRESSMSG_INVALID_CARD_TIMEOUT = "PROGRESSMSG_INVALID_CARD_TIMEOUT";
    public static final String PROGRESSMSG_EXPIRED_CARD_TIMEOUT = "PROGRESSMSG_EXPIRED_CARD_TIMEOUT";
    public static final String PROGRESSMSG_NOCONTACTLESS_CARD_TIMEOUT = "PROGRESSMSG_NOCONTACTLESS_CARD_TIMEOUT";
    public static final String PROGRESSMSG_DEVICE_BUSY = "PROGRESSMSG_DEVICE_BUSY";
    public static final String PROGRESSMSG_PENDING_ENTER_PIN = "PROGRESSMSG_PENDING_ENTER_PIN";
    public static final String PROGRESSMSG_ENTER_PIN = "PROGRESSMSG_ENTER_PIN";
    public static final String PROGRESSMSG_TRANSACTION_REJECTED= "PROGRESSMSG_TRANSACTION_REJECTED";
    public static final String PROGRESSMSG_TRANSACTION_APPROVED= "PROGRESSMSG_TRANSACTION_APPROVED";
    public static final String PROGRESSMSG_TRANSACTION_FAILED= "PROGRESSMSG_TRANSACTION_FAILED";
    public static final String PROGRESSMSG_RECEIPT_PREVIEW= "PROGRESSMSG_RECEIPT_PREVIEW";
    public static final String PROGRESSMSG_TELEPARAMETRAGE_MANDATORY = "PROGRESSMSG_TELEPARAMETRAGE_MANDATORY";
    public static final String PROGRESSMSG_PENDING_INSERT_CARD = "PROGRESSMSG_PENDING_INSERT_CARD";
    public static final String PROGRESSMSG_PENDING_REQUEST_AUTHORIZATION = "PROGRESSMSG_PENDING_REQUEST_AUTHORIZATION";
    public static final String PROGRESSMSG_REQUEST_AUTHORIZATION = "PROGRESSMSG_REQUEST_AUTHORIZATION";
    public static final String OPERATION_TYPE_CALLBACK = "CALLBACK";
    public static final String OPERATION_TYPE_PURCHASE = "PURCHASE";
    public static final String OPERATION_TYPE_REFUND = "REFUND";
    public static final String OPERATION_TYPE_CANCEL = "CANCEL";
    public static final String ACKNOWLEDGEMENT = "ACK";
    public static final String NOACKNOWLEDGEMENT = "NAK";
    public static final String OPERATION_TYPE_KEY = "operationType";
    public static final String HEADER_KEY = "header";
    public static final String UUID_KEY = "uuid";
    public static final String TIME_STAMP_KEY = "timestamp";
    public static final String TERMINAL_ID_KEY = "tid";
    public static final String CASH_REGISTER_KEY = "crid";
    public static final String SIGNATURE_KEY = "signature";
    public static final String PROGRESS_MESSAGE_KEY = "progressMessage";
    public static final String AMOUNT_KEY = "amount";
    public static final String CURRENCY_KEY = "currency";
    public static final String PAYLOAD_KEY = "payload";
    public static final String SCHEME_KEY = "scheme";
    public static final String TRXTIMESTAMP_KEY = "trxtimestamp";
    public static final String AUTHONUM_KEY = "authonum";
    public static final String OPSTATUS_KEY = "opstatus";
    public static final String REPORT_KEY = "report";
    public static final String HOLDERRECEIPT_KEY = "holdereceipt";
    public static final String MERCHANTRECEIPT_KEY = "merchantreceipt";

    public static final String ACTION_START_WIRELESS = "com.satim.cibpay.ACTION_START_WIRELESS";
    public static final String ACTION_STOP_WIRELESS = "com.satim.cibpay.ACTION_STOP_WIRELESS";
    public static final String ACTION_CASHREGISTER_PROGRESSMSG = "com.satim.cibpay.ACTION_CASHREGISTER_PROGRESSMSG";
    public static final String OPERATION_TYPE = "operationType";
    public static final String SHA_256_KEY = "sha256";
    public static final String SIGNATURE_KEY_KEY = "signature";
    public static final String UI_REPLY_TIMEOUT = "UI_REPLY_TIMEOUT";
    public static final String INPUT_KEY = "input";


    public static final String ACTION_START = "com.threespay.lunchertwo.MService.ACTION_START";
    public static final String ACTION_DO_MESSAGE = "com.threespay.lunchertwo.MService.ACTION_DO_MESSAGE";
    public static final String ACTION_STOP_SERVICE = "com.threespay.lunchertwo.MService.STOP_SERVICE";
}
