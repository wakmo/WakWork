//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.11 at 04:22:05 PM BST 
//


package net.aconite.affina.espinterface.xmlmapping.sem;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ScriptStatusUpdateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ScriptStatusUpdateType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="STAGED"/>
 *     &lt;enumeration value="DELETED"/>
 *     &lt;enumeration value="SENT"/>
 *     &lt;enumeration value="RESENT"/>
 *     &lt;enumeration value="DELIVERED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ScriptStatusUpdateType")
@XmlEnum
public enum ScriptStatusUpdateType {

    STAGED,
    DELETED,
    SENT,
    RESENT,
    DELIVERED;

    public String value() {
        return name();
    }

    public static ScriptStatusUpdateType fromValue(String v) {
        return valueOf(v);
    }

}
