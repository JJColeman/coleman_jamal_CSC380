import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "library")
public class Library
{
    private List<Book> books;

    public Library()
    {
        books = new ArrayList<Book>();
    }

    public void addBook(Book book)
    {
        books.add(book);
    }

    @XmlElement(name = "books")
    public List<Book> getBooks()
    {
        return this.books;
    }
}
