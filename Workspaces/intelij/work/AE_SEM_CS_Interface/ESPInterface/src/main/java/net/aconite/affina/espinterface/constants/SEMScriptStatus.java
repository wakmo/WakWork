/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aconite.affina.espinterface.constants;

/**
 *
 * @author thushara.pethiyagoda
 */
public enum SEMScriptStatus
{
    DELIVERED, SENT, DELETED, STAGED, PRESTAGED, RESENT;
    
    public boolean isIn(String status)
    {
        return this.toString().equals(status);
    }
}
