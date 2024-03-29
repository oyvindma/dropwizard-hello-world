package oyvindma.examples.dropwizard_helloworld;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

	public static void main(String[] args) throws Exception {
		new HelloWorldApplication().run(args);
	}

	@Override
	public String getName() {
		return "hello-world";
	}

	@Override
	public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
		// TODO Auto-generated method stub
	}

	@Override
	public void run(HelloWorldConfiguration configuration, Environment environment) throws Exception {
		final HelloWorldResource helloWorldResource = new HelloWorldResource(
				configuration.getTemplate(),
				configuration.getDefaultName()
				);

		environment.jersey().register(helloWorldResource);

		final TemplateHealthCheck healthCheck =
				new TemplateHealthCheck(configuration.getTemplate());
		environment.healthChecks().register("template", healthCheck);
	}

}
