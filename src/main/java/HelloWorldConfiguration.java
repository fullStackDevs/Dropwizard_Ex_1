
import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class HelloWorldConfiguration extends Configuration {

    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName;

    //**###**
    //We get an error if we use this adnotation on the integer fields
    //@NotEmpty
    private int defaultArg1;

    //@NotEmpty
    private int defaultArg2;

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    @JsonProperty
    public int getDefaultArg1() {
        return defaultArg1;
    }

    @JsonProperty
    public void setDefaultArg1(int defaultArg1) {
        this.defaultArg1 = defaultArg1;
    }

    @JsonProperty
    public int getDefaultArg2() {
        return defaultArg2;
    }

    @JsonProperty
    public void setDefaultArg2(int defaultArg2) {
        this.defaultArg2 = defaultArg2;
    }
}
