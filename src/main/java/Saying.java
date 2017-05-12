import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;


//REPRESENTATION CLASS
//***###***
//THIS IS WHAT WE RETURN
//***###***
public class Saying {

    private long id;

    @Length(max = 3)
    private String message;

    public Saying(){}

    public Saying(long id, String message) {
        this.id = id;
        this.message = message;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getMessage() {
        return message;
    }
}
