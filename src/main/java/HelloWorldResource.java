import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces("application/json")
public class HelloWorldResource {

    private String template;
    private String defaultName;
    private AtomicLong counter;

    public HelloWorldResource(String template, String defaultName){
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name){
        final String value = String.format(template, name.orElse(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }

}
