/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aconite.affina.espinterface.exceptions;

import org.springframework.integration.MessagingException;

/**
 *
 * @author wakkir.muzammil
 */
public class EspSAXParserException extends MessagingException
{
    private static final long serialVersionUID = 4233390499647614871L;
    private String errorCode="0";

    

    public EspSAXParserException(String message)
    {
        super(message);
    }
    
    public EspSAXParserException(String message,String errorCode)
    {
        super(message);
        this.errorCode=errorCode;
    }

    public EspSAXParserException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    public EspSAXParserException(String message, Throwable cause,String errorCode)
    {
        super(message, cause);
        this.errorCode=errorCode;
    }   

}