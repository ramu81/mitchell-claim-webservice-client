//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.30 at 01:14:57 AM EDT 
//


package com.mitchell.claims;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MitchellClaim" type="{http://www.mitchell.com/examples/claim}MitchellClaimType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mitchellClaim"
})
@XmlRootElement(name = "CreateClaimRequest")
public class CreateClaimRequest {

    @XmlElement(name = "MitchellClaim", required = true)
    protected MitchellClaimType mitchellClaim;

    /**
     * Gets the value of the mitchellClaim property.
     * 
     * @return
     *     possible object is
     *     {@link MitchellClaimType }
     *     
     */
    public MitchellClaimType getMitchellClaim() {
        return mitchellClaim;
    }

    /**
     * Sets the value of the mitchellClaim property.
     * 
     * @param value
     *     allowed object is
     *     {@link MitchellClaimType }
     *     
     */
    public void setMitchellClaim(MitchellClaimType value) {
        this.mitchellClaim = value;
    }

}