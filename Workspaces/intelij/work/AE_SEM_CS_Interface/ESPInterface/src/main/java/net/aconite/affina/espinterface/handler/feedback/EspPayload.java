/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aconite.affina.espinterface.handler.feedback;

import java.io.Serializable;


/**
 *
 * @author wakkir.muzammil
 */
public class EspPayload implements Serializable
{
    private static final long serialVersionUID = 7525572295622776147L;  // unique id
    
    private String header;    
    private String message; 
    private String alarmMsg; 
    private String originalMsg;
    private boolean isError;
    
    public EspPayload(String header,String message, boolean isError) 
    {
        this.header = header;
        this.message = message;
        this.isError = isError;
    }
    
    public EspPayload(String header,String message,String alarmMsg, String originalMsg, boolean isError) 
    {
        this.header = header;
        this.message = message;
        this.alarmMsg = alarmMsg;
        this.isError = isError;
        this.originalMsg = originalMsg;
    }

    public String getOriginalMsg()
    {
        return originalMsg;
    }

    public String getMessage() 
    {
        return message;
    }

    public void setMessage(String message) 
    {
        this.message = message;
    }

    public String getAlarmMsg()
    {
        return alarmMsg;
    }

    public void setAlarmMsg(String alarmMsg)
    {
        this.alarmMsg = alarmMsg;
    }

    public boolean isError() 
    {
        return isError;
    }

    public void setIsError(boolean isError) 
    {
        this.isError = isError;
    }
   
    public String getHeader() 
    {
        return header;
    }

    public void setHeader(String header) 
    {
        this.header = header;
    }
    
    public String getMessageBody() 
    {
        return message;
    }
    
    public String getAlarmMessageBody() 
    {
        return alarmMsg;
    }
    
    public String getMessageWithHeader() 
    {
        return header+" "+message;
    }
    
    public String getAlarmMessageWithHeader() 
    {
        return header+" "+alarmMsg;
    }
    
    public String getMessageInOneLine() 
    {
        return message.replace("\n", "");
    }
    
     public String getAlarmMessageInOneLine() 
    {
        return alarmMsg.replace("\n", "");
    }
    
    public String getMessageInOneLineWithHeader() 
    {
        return getMessageWithHeader().replace("\n", "");
    }
    
    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nHeader  : ").append(header);
        sb.append("\nMessage : ").append(message);
        sb.append("\nIsError : ").append(isError);
        sb.append("\n");
        return sb.toString();
    }
    
    
    
}