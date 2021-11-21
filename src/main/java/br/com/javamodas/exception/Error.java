package br.com.javamodas.exception;

public class Error {
    private String msgUser;
    private String msgDev;

    public Error(String msgUser, String msgDev) {
        this.msgUser = msgUser;
        this.msgDev = msgDev;
    }

    public String getMsgUser() {
        return msgUser;
    }


    public String getMsgDev() {
        return msgDev;
    }

}