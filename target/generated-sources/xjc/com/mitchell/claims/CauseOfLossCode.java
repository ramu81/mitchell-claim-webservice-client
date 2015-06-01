//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.30 at 01:14:57 AM EDT 
//


package com.mitchell.claims;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CauseOfLossCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CauseOfLossCode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Collision"/&gt;
 *     &lt;enumeration value="Explosion"/&gt;
 *     &lt;enumeration value="Fire"/&gt;
 *     &lt;enumeration value="Hail"/&gt;
 *     &lt;enumeration value="Mechanical Breakdown"/&gt;
 *     &lt;enumeration value="Other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CauseOfLossCode", namespace = "http://www.mitchell.com/examples/claim")
@XmlEnum
public enum CauseOfLossCode {

    @XmlEnumValue("Collision")
    COLLISION("Collision"),
    @XmlEnumValue("Explosion")
    EXPLOSION("Explosion"),
    @XmlEnumValue("Fire")
    FIRE("Fire"),
    @XmlEnumValue("Hail")
    HAIL("Hail"),
    @XmlEnumValue("Mechanical Breakdown")
    MECHANICAL_BREAKDOWN("Mechanical Breakdown"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    CauseOfLossCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CauseOfLossCode fromValue(String v) {
        for (CauseOfLossCode c: CauseOfLossCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
