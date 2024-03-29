package oyvindma.examples.dropwizard_helloworld;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class HelloWorldConfiguration extends Configuration {

	@NotEmpty
	private String template;
	
	@NotEmpty
	private String defaultName = "John";

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

}
