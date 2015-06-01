package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication
				.run(WeatherConfiguration.class);
		MitchellClaimClient claimClient = ctx
				.getBean(MitchellClaimClient.class);
		claimClient.createClaim();
		claimClient.readClaim();
		claimClient.updateClaim();
		claimClient.printDateRangeReq();
	}

}
