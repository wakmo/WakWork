/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aconite.affina.espinterface.exceptions;

/**
 *
 * @author thushara.pethiyagoda
 */
public class ScriptableCardNotFoundException extends ScriptProcessingRuntimeException
{

    static final long serialVersionUID = -3387516993124229942L;

    public ScriptableCardNotFoundException()
    {
        super();
    }

    public ScriptableCardNotFoundException(String message)
    {
        super(message);
    }

    public ScriptableCardNotFoundException(String message, String errCode)
    {
        super(message, errCode);
    }

    public ScriptableCardNotFoundException(String message, String eReason , String errCode)
    {
        super(message, eReason, errCode);

    }
    
    public ScriptableCardNotFoundException(String message, String eReason , String errCode, int errType)
    {
        super(message, eReason, errCode, errType);

    }
}
