
package SonyClient.proxy;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="Movie List" type="{http://SonyService/}movie" maxOccurs="unbounded" minOccurs="0"/>
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
    "movie0020List"
})
public class SendMovies {

    @XmlElement(name = "Movie List")
    protected List<Movie> movie0020List;

    /**
     * Gets the value of the movie0020List property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the movie0020List property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMovie_0020List().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Movie }
     * 
     * 
     */
    public List<Movie> getMovie_0020List() {
        if (movie0020List == null) {
            movie0020List = new ArrayList<Movie>();
        }
        return this.movie0020List;
    }

}
