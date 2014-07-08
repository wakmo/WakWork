/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aconite.affina.espinterface.jms;

import java.io.IOException;
import javax.xml.transform.Result;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.XmlMappingException;

/**
 *
 * @author wakkir.muzammil
 */
public class CustomJaxbMarshaller implements  Marshaller
{

    public boolean supports(Class<?> type)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void marshal(Object o, Result result) throws IOException, XmlMappingException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
