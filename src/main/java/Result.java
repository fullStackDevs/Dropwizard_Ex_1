import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

    private long id;
    private int result;

    public Result(){}

    public Result(long id, int result) {
        this.id = id;
        this.result = result;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public int getResult() {
        return result;
    }
}
