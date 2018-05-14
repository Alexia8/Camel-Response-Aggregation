
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

    private final static QName _SendMoviesResponse_QNAME = new QName("http://SonyService/", "sendMoviesResponse");
    private final static QName _GetMovieResponse_QNAME = new QName("http://SonyService/", "getMovieResponse");
    private final static QName _SendUserActivity_QNAME = new QName("http://SonyService/", "sendUserActivity");
    private final static QName _SendUserActivityResponse_QNAME = new QName("http://SonyService/", "sendUserActivityResponse");
    private final static QName _GetMovie_QNAME = new QName("http://SonyService/", "getMovie");
    private final static QName _SendSongs_QNAME = new QName("http://SonyService/", "sendSongs");
    private final static QName _SendSongsResponse_QNAME = new QName("http://SonyService/", "sendSongsResponse");
    private final static QName _GetSong_QNAME = new QName("http://SonyService/", "getSong");
    private final static QName _GetSongResponse_QNAME = new QName("http://SonyService/", "getSongResponse");
    private final static QName _SendMovies_QNAME = new QName("http://SonyService/", "sendMovies");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: SonyClient.proxy
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMovieResponse }
     * 
     */
    public GetMovieResponse createGetMovieResponse() {
        return new GetMovieResponse();
    }

    /**
     * Create an instance of {@link SendMoviesResponse }
     * 
     */
    public SendMoviesResponse createSendMoviesResponse() {
        return new SendMoviesResponse();
    }

    /**
     * Create an instance of {@link SendUserActivity }
     * 
     */
    public SendUserActivity createSendUserActivity() {
        return new SendUserActivity();
    }

    /**
     * Create an instance of {@link SendUserActivityResponse }
     * 
     */
    public SendUserActivityResponse createSendUserActivityResponse() {
        return new SendUserActivityResponse();
    }

    /**
     * Create an instance of {@link SendSongs }
     * 
     */
    public SendSongs createSendSongs() {
        return new SendSongs();
    }

    /**
     * Create an instance of {@link GetMovie }
     * 
     */
    public GetMovie createGetMovie() {
        return new GetMovie();
    }

    /**
     * Create an instance of {@link SendMovies }
     * 
     */
    public SendMovies createSendMovies() {
        return new SendMovies();
    }

    /**
     * Create an instance of {@link GetSong }
     * 
     */
    public GetSong createGetSong() {
        return new GetSong();
    }

    /**
     * Create an instance of {@link GetSongResponse }
     * 
     */
    public GetSongResponse createGetSongResponse() {
        return new GetSongResponse();
    }

    /**
     * Create an instance of {@link SendSongsResponse }
     * 
     */
    public SendSongsResponse createSendSongsResponse() {
        return new SendSongsResponse();
    }

    /**
     * Create an instance of {@link Song }
     * 
     */
    public Song createSong() {
        return new Song();
    }

    /**
     * Create an instance of {@link Movie }
     * 
     */
    public Movie createMovie() {
        return new Movie();
    }

    /**
     * Create an instance of {@link UserActivity }
     * 
     */
    public UserActivity createUserActivity() {
        return new UserActivity();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovieResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SonyService/", name = "getMovieResponse")
    public JAXBElement<GetMovieResponse> createGetMovieResponse(GetMovieResponse value) {
        return new JAXBElement<GetMovieResponse>(_GetMovieResponse_QNAME, GetMovieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendUserActivity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SonyService/", name = "sendUserActivity")
    public JAXBElement<SendUserActivity> createSendUserActivity(SendUserActivity value) {
        return new JAXBElement<SendUserActivity>(_SendUserActivity_QNAME, SendUserActivity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendUserActivityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SonyService/", name = "sendUserActivityResponse")
    public JAXBElement<SendUserActivityResponse> createSendUserActivityResponse(SendUserActivityResponse value) {
        return new JAXBElement<SendUserActivityResponse>(_SendUserActivityResponse_QNAME, SendUserActivityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SonyService/", name = "getMovie")
    public JAXBElement<GetMovie> createGetMovie(GetMovie value) {
        return new JAXBElement<GetMovie>(_GetMovie_QNAME, GetMovie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendSongs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SonyService/", name = "sendSongs")
    public JAXBElement<SendSongs> createSendSongs(SendSongs value) {
        return new JAXBElement<SendSongs>(_SendSongs_QNAME, SendSongs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendSongsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SonyService/", name = "sendSongsResponse")
    public JAXBElement<SendSongsResponse> createSendSongsResponse(SendSongsResponse value) {
        return new JAXBElement<SendSongsResponse>(_SendSongsResponse_QNAME, SendSongsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSong }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SonyService/", name = "getSong")
    public JAXBElement<GetSong> createGetSong(GetSong value) {
        return new JAXBElement<GetSong>(_GetSong_QNAME, GetSong.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSongResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SonyService/", name = "getSongResponse")
    public JAXBElement<GetSongResponse> createGetSongResponse(GetSongResponse value) {
        return new JAXBElement<GetSongResponse>(_GetSongResponse_QNAME, GetSongResponse.class, null, value);
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
