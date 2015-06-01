package hello;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.mitchell.claims.ClaimResponse;
import com.mitchell.claims.CreateClaimRequest;
import com.mitchell.claims.CreateClaimResponse;
import com.mitchell.claims.DateRangeRequest;
import com.mitchell.claims.ListOfClaims;
import com.mitchell.claims.MitchellClaimType;
import com.mitchell.claims.ReadClaimRequest;
import com.mitchell.claims.UpdateClaimRequest;
import com.mitchell.claims.UpdateClaimResponse;

public class MitchellClaimClient extends WebServiceGatewaySupport {

	public void createClaim() {
		CreateClaimRequest req = ClaimUtil.createClaimRequest();
		CreateClaimResponse claimResponse = (CreateClaimResponse) getWebServiceTemplate()
				.marshalSendAndReceive(
						req,
						new SoapActionCallback(
								"http://com/mitchell/examples/claim/mitchellclaimservice"));
		System.out.println();
		System.out.println("*****************************************************************");
		System.out.println("			"+claimResponse.getCreateClaimResponse());
		System.out.println("*****************************************************************");
	}

	public void readClaim() {
		ReadClaimRequest req = ClaimUtil.createReadClaimRequest();
		ClaimResponse claimResponse = (ClaimResponse) getWebServiceTemplate()
				.marshalSendAndReceive(
						req,
						new SoapActionCallback(
								"http://com/mitchell/examples/claim/mitchellclaimservice"));
		System.out.println("*****************************************************************");
		System.out.println("			readClaim								");
		System.out.println("*****************************************************************");
		ClaimUtil.printClaimResponse(claimResponse.getClaimResponse());
	}

	public void updateClaim() {
		UpdateClaimRequest req = ClaimUtil.updateClaimRequest();
		UpdateClaimResponse claimResponse = (UpdateClaimResponse) getWebServiceTemplate()
				.marshalSendAndReceive(
						req,
						new SoapActionCallback(
								"http://com/mitchell/examples/claim/mitchellclaimservice"));
		System.out.println();
		System.out.println("*****************************************************************");
		System.out.println("			"+claimResponse.getUpdateClaimResponse());
		System.out.println("*****************************************************************");
	}

	public void printDateRangeReq() {
		DateRangeRequest req = ClaimUtil.getDateRangeRequest();
		ListOfClaims claimResponse = (ListOfClaims) getWebServiceTemplate()
				.marshalSendAndReceive(
						req,
						new SoapActionCallback(
								"http://com/mitchell/examples/claim/mitchellclaimservice"));
		System.out.println("*****************************************************************");
		System.out.println("			DateRangeReq								");
		System.out.println("*****************************************************************");
		for (MitchellClaimType mitchellClaimType : claimResponse
				.getListOfClaims()) {
			ClaimUtil.printClaimResponse(mitchellClaimType);
		}
	}
}
