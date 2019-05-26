/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.exception;

/**
 *
 * @author User
 */
public class ResponseStatus {
    public int httpcode;
    
    public String httperrorMsg;

    public ResponseStatus(int httpcode, String httperrorMsg) {
        this.httpcode = httpcode;
        this.httperrorMsg = httperrorMsg;
    }

    public int getHttpcode() {
        return httpcode;
    }

    public void setHttpcode(int httpcode) {
        this.httpcode = httpcode;
    }

    public String getHttperrorMsg() {
        return httperrorMsg;
    }

    public void setHttperrorMsg(String httperrorMsg) {
        this.httperrorMsg = httperrorMsg;
    }
    
    
    
}
