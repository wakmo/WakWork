/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aconite.affina.espinterface.jms;

import java.io.IOException;
import javax.xml.transform.Source;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;

/**
 *
 * @author wakkir.muzammil
 */
public class CustomJaxbUnmarshaller implements  Unmarshaller
{

    public boolean supports(Class<?> type)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object unmarshal(Source source) throws IOException, XmlMappingException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
   
    
}
