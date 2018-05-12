
package SonyClient.proxy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the SonyClient.proxy package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetMovieStatsResponse_QNAME = new QName("http://SonyService/", "getMovieStatsResponse");
    private final static QName _GetUserActivityResponse_QNAME = new QName("http://SonyService/", "getUserActivityResponse");
    private final static QName _SendMoviesResponse_QNAME = new QName("http://SonyService/", "sendMoviesResponse");
    private final static QName _GetMovieStats_QNAME = new QName("http://SonyService/", "getMovieStats");
    private final static QName _GetUserActivity_QNAME = new QName("http://SonyService/", "getUserActivity");
    private final static QName _SendMovies_QNAME = new QName("http://SonyService/", "sendMovies");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: SonyClient.proxy
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUserActivityResponse }
     * 
     */
    public GetUserActivityResponse createGetUserActivityResponse() {
        return new GetUserActivityResponse();
    }

    /**
     * Create an instance of {@link SendMoviesResponse }
     * 
     */
    public SendMoviesResponse createSendMoviesResponse() {
        return new SendMoviesResponse();
    }

    /**
     * Create an instance of {@link GetMovieStatsResponse }
     * 
     */
    public GetMovieStatsResponse createGetMovieStatsResponse() {
        return new GetMovieStatsResponse();
    }

    /**
     * Create an instance of {@link GetUserActivity }
     * 
     */
    public GetUserActivity createGetUserActivity() {
        return new GetUserActivity();
    }

    /**
     * Create an instance of {@link GetMovieStats }
     * 
     */
    public GetMovieStats createGetMovieStats() {
        return new GetMovieStats();
    }

    /**
     * Create an instance of {@link SendMovies }
     * 
     */
    public SendMovies createSendMovies() {
        return new SendMovies();
    }

    /**
     * Create an instance of {@link Movie }
     * 
     */
    public Movie createMovie() {
        return new Movie();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovieStatsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SonyService/", name = "getMovieStatsResponse")
    public JAXBElement<GetMovieStatsResponse> createGetMovieStatsResponse(GetMovieStatsResponse value) {
        return new JAXBElement<GetMovieStatsResponse>(_GetMovieStatsResponse_QNAME, GetMovieStatsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserActivityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SonyService/", name = "getUserActivityResponse")
    public JAXBElement<GetUserActivityResponse> createGetUserActivityResponse(GetUserActivityResponse value) {
        return new JAXBElement<GetUserActivityResponse>(_GetUserActivityResponse_QNAME, GetUserActivityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMoviesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SonyService/", name = "sendMoviesResponse")
    public JAXBElement<SendMoviesResponse> createSendMoviesResponse(SendMoviesResponse value) {
        return new JAXBElement<SendMoviesResponse>(_SendMoviesResponse_QNAME, SendMoviesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovieStats }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SonyService/", name = "getMovieStats")
    public JAXBElement<GetMovieStats> createGetMovieStats(GetMovieStats value) {
        return new JAXBElement<GetMovieStats>(_GetMovieStats_QNAME, GetMovieStats.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserActivity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SonyService/", name = "getUserActivity")
    public JAXBElement<GetUserActivity> createGetUserActivity(GetUserActivity value) {
        return new JAXBElement<GetUserActivity>(_GetUserActivity_QNAME, GetUserActivity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMovies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SonyService/", name = "sendMovies")
    public JAXBElement<SendMovies> createSendMovies(SendMovies value) {
        return new JAXBElement<SendMovies>(_SendMovies_QNAME, SendMovies.class, null, value);
    }

}
