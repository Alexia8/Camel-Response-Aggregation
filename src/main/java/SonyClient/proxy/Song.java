
package SonyClient.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for song complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="song">
 *   &lt;complexContent>
 *     &lt;extension base="{http://SonyService/}content">
 *       &lt;sequence>
 *         &lt;element name="streamUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "song", propOrder = {
    "streamUrl"
})
public class Song
    extends Content
{

    protected String streamUrl;

    /**
     * Gets the value of the streamUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreamUrl() {
        return streamUrl;
    }

    /**
     * Sets the value of the streamUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreamUrl(String value) {
        this.streamUrl = value;
    }

}
