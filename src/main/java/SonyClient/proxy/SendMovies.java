
package SonyClient.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sendMovies complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sendMovies">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="content_receiver" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendMovies", propOrder = {
    "contentReceiver"
})
public class SendMovies {

    @XmlElement(name = "content_receiver")
    protected String contentReceiver;

    /**
     * Gets the value of the contentReceiver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentReceiver() {
        return contentReceiver;
    }

    /**
     * Sets the value of the contentReceiver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentReceiver(String value) {
        this.contentReceiver = value;
    }

}
