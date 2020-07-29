package us.erlang.android_activity;

public class CustomMessage {
    public static int MESSAGE_TYPE_1 = 1;
    public static int MESSAGE_TYPE_2 = 2;

    public static String getMessage(int messageType){
        if(messageType == MESSAGE_TYPE_1) {
            return "message foo";
        }

        if(messageType == MESSAGE_TYPE_2) {
            return "message bar";
        }
        return null;
    }
}
