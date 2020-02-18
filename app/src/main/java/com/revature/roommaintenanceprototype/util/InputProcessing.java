package com.revature.roommaintenanceprototype.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputProcessing {
    private static final int passwordMinLength = 6;
    private static final int passwordMaxLength = 12;

    public static int getPasswordMinLength() {
        return passwordMinLength;
    }

    public static int getPasswordMaxLength() {
        return passwordMaxLength;
    }

    public static InputReturn validateEmail(String email){
        if( checkEmptyString(email) == InputReturn.EMPTY_STRING ){
            return InputReturn.EMPTY_STRING;
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()){
            return InputReturn.OK;
        }else{
            return InputReturn.INVALID_EMAIL;
        }
    }

    public static InputReturn validatePassword(String password){
        if( checkEmptyString(password) == InputReturn.EMPTY_STRING ){
            return InputReturn.EMPTY_STRING;
        }
        if( password.length() < passwordMinLength){
            return InputReturn.TOO_SHORT;
        }
        if( password.length() > passwordMaxLength ){
            return InputReturn.TOO_LONG;
        }
        return InputReturn.OK;
    }

    public static InputReturn checkEmptyString(String string){
        if(string.equals("")) return InputReturn.EMPTY_STRING;
        else return InputReturn.OK;
    }

    public enum InputReturn{
        EMPTY_STRING,
        INVALID_EMAIL,
        OK,
        TOO_SHORT,
        TOO_LONG;
    }

    public static String formatDate(int year, int month, int day){
        return year+"/"+month+"/"+day;
    }
}
