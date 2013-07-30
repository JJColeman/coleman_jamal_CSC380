import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "author")
public class Author
{
    public String name;
    public int phone;

    public Author(){};

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPhone(int phone)
    {
        this.phone = phone;
    }

    @XmlElement
    public String getName()
    {
        return this.name;
    }

    @XmlElement
    public int getPhone()
    {
        return this.phone;
    }
}
