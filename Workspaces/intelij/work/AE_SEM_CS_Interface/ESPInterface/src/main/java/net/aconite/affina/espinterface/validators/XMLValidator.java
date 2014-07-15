/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aconite.affina.espinterface.validators;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import net.aconite.affina.espinterface.exceptions.EspSAXParserException;
import net.aconite.affina.espinterface.handler.feedback.EspPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.Message;
import org.springframework.integration.MessageHeaders;
import org.springframework.integration.MessagingException;
import org.springframework.integration.jms.JmsHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author wakkir.muzammil
 */
public class XMLValidator implements IXMLValidator
{
    private static final Logger logger = LoggerFactory.getLogger(XMLValidator.class.getName());

    private java.lang.String schema;  

    public Message validate(Message inMessage) throws EspSAXParserException
    {
        MessageHeaders inHeaders = inMessage.getHeaders();
        Object inPayload = inMessage.getPayload();

        logger.debug("DecryptMessage : Incoming Message header: {}", inHeaders);
        logger.debug("DecryptMessage : Message payload: {}", inPayload);
        logger.debug(toString());
        String xml=(String)inPayload;        

        Message outMessage=null;
            
        try
        {            
            process(xml);  
            outMessage = inMessage;
        }
        catch (ParserConfigurationException ex)
        {
            logger.error(ex.getMessage());
        }
        catch (IOException ex)
        {
            logger.error(ex.getMessage());
        }
        catch (SAXException ex)
        {
            logger.error(ex.getMessage(),ex);
            //throw new EspSAXParserException(ex.getMessage(),ex);
            outMessage=generateErrorMessage(inHeaders, new EspSAXParserException(ex.getMessage(),ex));
        }        
        

        logger.debug("Message Received : {}",outMessage.toString());
        return outMessage;
    }
     
    public String getSchema()
    {
        return schema;
    }

    public void setSchema(String schema)
    {
        this.schema = schema;
    }
    
    public void process(String xml) throws ParserConfigurationException, IOException, SAXException
    {
        //XML parsing
        DocumentBuilderFactory docBuilderfactory = DocumentBuilderFactory.newInstance();
        docBuilderfactory.setNamespaceAware(true);
        docBuilderfactory.setValidating(true);
        
        DocumentBuilder builder = docBuilderfactory.newDocumentBuilder();

        InputStream is = new ByteArrayInputStream(xml.getBytes());
        Document xmlDocument = builder.parse(is);
        xmlDocument.getDocumentElement().normalize();

        URL xsdUrlA = this.getClass().getResource(schema);
        
        SchemaFactory schemaFactory1 = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        
        Schema schema1= schemaFactory1.newSchema(xsdUrlA);

        //Validation
        javax.xml.validation.Validator validator = schema1.newValidator();
        Source source = new DOMSource(xmlDocument);
        validator.validate(source);
    }
    
    private Message<MessagingException> generateErrorMessage(MessageHeaders headers, MessagingException espPayload)
    {        
        return MessageBuilder.withPayload(espPayload)
                .copyHeaders(headers)
                .setHeader(JmsHeaders.TYPE, headers.get(JmsHeaders.TYPE))
                .build();
    }
}
