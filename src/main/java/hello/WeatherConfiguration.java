package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WeatherConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.mitchell.claims");
		return marshaller;
	}

	@Bean
	public MitchellClaimClient mitchellClaimClient(Jaxb2Marshaller marshaller) {
		MitchellClaimClient client = new MitchellClaimClient();
		client.setDefaultUri("http://localhost:8080/mitchell-claim/endpoints/MitchellClaimService.wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
