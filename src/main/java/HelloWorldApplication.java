import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception{
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap){

    }

    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment){
        final HelloWorldResource helloWorldResource = new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName());
        final TemplateHealthCheck templateHealthCheck = new TemplateHealthCheck(configuration.getTemplate());
        final AditionOperationResource aditionOperationResource = new AditionOperationResource(configuration.getDefaultArg1(), configuration.getDefaultArg2());
        environment.jersey().register(helloWorldResource);
        environment.healthChecks().register("template", templateHealthCheck);
        environment.jersey().register(aditionOperationResource);

    }
}
