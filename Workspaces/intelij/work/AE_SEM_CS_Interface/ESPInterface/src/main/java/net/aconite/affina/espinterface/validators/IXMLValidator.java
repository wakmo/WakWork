/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aconite.affina.espinterface.validators;

import net.aconite.affina.espinterface.exceptions.EspSAXParserException;
import org.springframework.integration.Message;

/**
 *
 * @author wakkir.muzammil
 */
public interface IXMLValidator
{
    public Message validate(Message message) throws EspSAXParserException;
}
