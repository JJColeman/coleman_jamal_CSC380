import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
public class Book
{
    private String title;
    private String publisher;
    private Author author;

    public Book(){}

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    public void setAuthor(Author author)
    {
        this.author = author;
    }

    @XmlElement
    public String getTitle()
    {
        return this.title;
    }

    @XmlElement
    public String getPublisher()
    {
        return this.publisher;
    }

    @XmlElement
    public Author getAuthor()
    {
        return this.author;
    }
}

