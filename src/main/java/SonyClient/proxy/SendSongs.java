
package SonyClient.proxy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sendSongs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sendSongs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Song.java List" type="{http://SonyService/}song" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendSongs", propOrder = {
    "songJava0020List"
})
public class SendSongs {

    @XmlElement(name = "Song.java List")
    protected List<Song> songJava0020List;

    /**
     * Gets the value of the songJava0020List property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the songJava0020List property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSongJava_0020List().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Song }
     * 
     * 
     */
    public List<Song> getSongJava_0020List() {
        if (songJava0020List == null) {
            songJava0020List = new ArrayList<Song>();
        }
        return this.songJava0020List;
    }

}
