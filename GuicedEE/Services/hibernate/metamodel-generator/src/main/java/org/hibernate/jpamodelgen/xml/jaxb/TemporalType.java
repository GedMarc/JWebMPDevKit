//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.07.30 at 07:10:45 AM BST 
//


package org.hibernate.jpamodelgen.xml.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for temporal-type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="temporal-type"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="DATE"/&gt;
 *     &lt;enumeration value="TIME"/&gt;
 *     &lt;enumeration value="TIMESTAMP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "temporal-type")
@XmlEnum
public enum TemporalType {

    DATE,
    TIME,
    TIMESTAMP;

    public String value() {
        return name();
    }

    public static TemporalType fromValue(String v) {
        return valueOf(v);
    }

}
