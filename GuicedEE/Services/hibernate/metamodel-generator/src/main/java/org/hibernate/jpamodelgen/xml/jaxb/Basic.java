//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.07.30 at 07:10:45 AM BST 
//


package org.hibernate.jpamodelgen.xml.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 
 *                 @Target({METHOD, FIELD}) @Retention(RUNTIME)
 *                 public @interface Basic {
 *                 FetchType fetch() default EAGER;
 *                 boolean optional() default true;
 *                 }
 * 
 *             
 * 
 * <p>Java class for basic complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="basic"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="column" type="{http://xmlns.jcp.org/xml/ns/persistence/orm}column" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="lob" type="{http://xmlns.jcp.org/xml/ns/persistence/orm}lob" minOccurs="0"/&gt;
 *           &lt;element name="temporal" type="{http://xmlns.jcp.org/xml/ns/persistence/orm}temporal" minOccurs="0"/&gt;
 *           &lt;element name="enumerated" type="{http://xmlns.jcp.org/xml/ns/persistence/orm}enumerated" minOccurs="0"/&gt;
 *           &lt;element name="convert" type="{http://xmlns.jcp.org/xml/ns/persistence/orm}convert" minOccurs="0"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="fetch" type="{http://xmlns.jcp.org/xml/ns/persistence/orm}fetch-type" /&gt;
 *       &lt;attribute name="optional" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="access" type="{http://xmlns.jcp.org/xml/ns/persistence/orm}access-type" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "basic", propOrder = {
    "column",
    "lob",
    "temporal",
    "enumerated",
    "convert"
})
public class Basic {

    protected Column column;
    protected Lob lob;
    @XmlSchemaType(name = "token")
    protected TemporalType temporal;
    @XmlSchemaType(name = "token")
    protected EnumType enumerated;
    protected Convert convert;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "fetch")
    protected FetchType fetch;
    @XmlAttribute(name = "optional")
    protected Boolean optional;
    @XmlAttribute(name = "access")
    protected AccessType access;

    /**
     * Gets the value of the column property.
     * 
     * @return
     *     possible object is
     *     {@link Column }
     *     
     */
    public Column getColumn() {
        return column;
    }

    /**
     * Sets the value of the column property.
     * 
     * @param value
     *     allowed object is
     *     {@link Column }
     *     
     */
    public void setColumn(Column value) {
        this.column = value;
    }

    /**
     * Gets the value of the lob property.
     * 
     * @return
     *     possible object is
     *     {@link org.hibernate.jpamodelgen.xml.jaxb.Lob }
     *     
     */
    public Lob getLob() {
        return lob;
    }

    /**
     * Sets the value of the lob property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.hibernate.jpamodelgen.xml.jaxb.Lob }
     *     
     */
    public void setLob(Lob value) {
        this.lob = value;
    }

    /**
     * Gets the value of the temporal property.
     * 
     * @return
     *     possible object is
     *     {@link TemporalType }
     *     
     */
    public TemporalType getTemporal() {
        return temporal;
    }

    /**
     * Sets the value of the temporal property.
     * 
     * @param value
     *     allowed object is
     *     {@link TemporalType }
     *     
     */
    public void setTemporal(TemporalType value) {
        this.temporal = value;
    }

    /**
     * Gets the value of the enumerated property.
     * 
     * @return
     *     possible object is
     *     {@link EnumType }
     *     
     */
    public EnumType getEnumerated() {
        return enumerated;
    }

    /**
     * Sets the value of the enumerated property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnumType }
     *     
     */
    public void setEnumerated(EnumType value) {
        this.enumerated = value;
    }

    /**
     * Gets the value of the convert property.
     * 
     * @return
     *     possible object is
     *     {@link Convert }
     *     
     */
    public Convert getConvert() {
        return convert;
    }

    /**
     * Sets the value of the convert property.
     * 
     * @param value
     *     allowed object is
     *     {@link Convert }
     *     
     */
    public void setConvert(Convert value) {
        this.convert = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the fetch property.
     * 
     * @return
     *     possible object is
     *     {@link FetchType }
     *     
     */
    public FetchType getFetch() {
        return fetch;
    }

    /**
     * Sets the value of the fetch property.
     * 
     * @param value
     *     allowed object is
     *     {@link FetchType }
     *     
     */
    public void setFetch(FetchType value) {
        this.fetch = value;
    }

    /**
     * Gets the value of the optional property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOptional() {
        return optional;
    }

    /**
     * Sets the value of the optional property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOptional(Boolean value) {
        this.optional = value;
    }

    /**
     * Gets the value of the access property.
     * 
     * @return
     *     possible object is
     *     {@link AccessType }
     *     
     */
    public AccessType getAccess() {
        return access;
    }

    /**
     * Sets the value of the access property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccessType }
     *     
     */
    public void setAccess(AccessType value) {
        this.access = value;
    }

}
