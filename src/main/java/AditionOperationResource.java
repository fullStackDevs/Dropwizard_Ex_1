import javax.ws.rs.*;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/adition")
@Produces("application/json")
public class AditionOperationResource {

    private int defaultArg1;
    private int defaultArg2;
    private AtomicLong counter;

    public AditionOperationResource(int defaultArg1, int defaultArg2){
        this.defaultArg1 = defaultArg1;
        this.defaultArg2 = defaultArg2;
        counter = new AtomicLong();
    }

    @GET
    public Result addNumbers(@QueryParam("arg1") Optional<Integer> a, @QueryParam("arg2") Optional<Integer> b){
        //-----------------
        //**###**The business logic should be extracted from here into a service or something
        //--------------------------------------------------------------------------------------
        int result = a.orElse(defaultArg1) + b.orElse(defaultArg2);
        return new Result(counter.incrementAndGet(), result);
    }

}
