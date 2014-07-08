/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aconite.affina.espinterface.handler.feedback;

import java.util.Hashtable;
import net.acointe.affina.esp.AffinaEspUtils;
import net.aconite.affina.espinterface.constants.EspConstant;
import net.aconite.affina.espinterface.exceptions.*;
import net.aconite.affina.espinterface.helper.*;
import net.aconite.affina.espinterface.xmlmapping.sem.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.*;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.jms.JmsHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.support.channel.ChannelResolutionException;
import org.springframework.integration.transformer.MessageTransformationException;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * @author wakkir.muzammil
 */
public class XMLValidationHandler implements IEspFeedbackHandler
{
    private static final Logger logger = LoggerFactory.getLogger(XMLValidationHandler.class.getName());
    
    private EspFeedbackHeader espFeedbackHeader;
        
    public XMLValidationHandler(EspFeedbackHeader espFeedbackHeader)
    {
        this.espFeedbackHeader = espFeedbackHeader;
    }
    
    @ServiceActivator
    public void endProcess(Message<MessagingException> inMessage) 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @ServiceActivator
    public Message process(Message<MessagingException> inMessage)
    {
        //Message outMessage = processErrorMessage(inMessage);
        ScriptValidationException ex = new ScriptValidationException(inMessage.getPayload().getMessage(), 
                inMessage.getPayload().getCause().getMessage() , "-63029", ScriptProcessingRuntimeException.ERROR_VALIDATION);
        Result r = Result.getInstance(false, ex, "", null);
        r.handleError();
        ScriptStatusResponse response = r.getResultData().getScriptStatusResponse();
        MessageHeaders inHeaders = inMessage.getHeaders();
        Message<ScriptStatusResponse> outMessage = generateScriptStatusResponseMessage(inHeaders, response);
        return outMessage;
    }
    
    private Message<ScriptStatusResponse> generateScriptStatusResponseMessage(MessageHeaders headers,
                                                                              ScriptStatusResponse sourceData)
    {

        logger.info("Created ScriptStatusResponse Message : {}", sourceData.getTrackingReference());

        return MessageBuilder.withPayload(sourceData)
                .copyHeaders(headers)
                .setHeader(JmsHeaders.TYPE, EspConstant.SCRIPT_STATUS_RESPONSE)
                //.setHeader(EspConstant.JMS_MESSAGE_DEST, destination)
                .build();
    }
    /**
     * @param inMessage
     */
    
    private Message<String> generateErrorMessage(MessageHeaders headers, EspPayload espPayload)
    {        
        return MessageBuilder.withPayload(espPayload.getMessageWithHeader())
                .copyHeaders(headers)
                .setHeader(JmsHeaders.TYPE, headers.get(JmsHeaders.TYPE))
                .build();
    }
}
