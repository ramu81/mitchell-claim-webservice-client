package hello;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.mitchell.claims.CauseOfLossCode;
import com.mitchell.claims.CreateClaimRequest;
import com.mitchell.claims.DateRangeRequest;
import com.mitchell.claims.LossInfoType;
import com.mitchell.claims.MitchellClaimType;
import com.mitchell.claims.ReadClaimRequest;
import com.mitchell.claims.StatusCode;
import com.mitchell.claims.UpdateClaimRequest;
import com.mitchell.claims.VehicleInfoType;
import com.mitchell.claims.VehicleListType;

public class ClaimUtil {

	public static CreateClaimRequest createClaimRequest() {
		Date date = null;
		CreateClaimRequest claimRequest = new CreateClaimRequest();
		MitchellClaimType claimType = new MitchellClaimType();
		claimType.setClaimNumber("22c9c23bac142856018ce14a26b6c299");
		claimType.setClaimantFirstName("George");
		claimType.setClaimantLastName("Washington");
		date = toDate("2014-07-0-17:19:13.631-07:00");
		claimType.setLossDate(toXMLGregorianCalendar(date));
		claimType.setStatus(StatusCode.valueOf("OPEN"));
		claimType.setAssignedAdjusterID(new Long(12345));
		LossInfoType infoType = new LossInfoType();
		infoType.setCauseOfLoss(CauseOfLossCode.fromValue("Collision"));
		date = toDate("2014-07-10-17:19:13.676-07:00");
		infoType.setReportedDate(toXMLGregorianCalendar(date));
		infoType.setLossDescription("Crashed into an apple tree.");
		VehicleListType vehicles = new VehicleListType();
		VehicleInfoType vehicleInfoType = new VehicleInfoType();
		vehicleInfoType
				.setDamageDescription("Front end smashed in. Apple dents in roof.");
		vehicleInfoType.setEngineDescription("EcoBoost");
		vehicleInfoType.setExteriorColor("Deep Impact Blue");
		vehicleInfoType.setLicPlate("NO1PRES");
		date = toDate("2015-03-10-07:00");
		vehicleInfoType.setLicPlateExpDate(toXMLGregorianCalendar(date));
		vehicleInfoType.setLicPlateState("VA");
		vehicleInfoType.setMakeDescription("Ford");
		vehicleInfoType.setMileage(1776);
		vehicleInfoType.setModelDescription("Mustang");
		vehicleInfoType.setModelYear(2015);
		vehicleInfoType.setVin("1M8GDM9AXKP042788");
		vehicles.getVehicleDetails().add(vehicleInfoType);
		claimType.setVehicles(vehicles);
		claimType.setLossInfo(infoType);
		claimRequest.setMitchellClaim(claimType);
		return claimRequest;
	}

	public static UpdateClaimRequest updateClaimRequest() {
		Date date = null;
		UpdateClaimRequest claimRequest = new UpdateClaimRequest();
		MitchellClaimType claimType = new MitchellClaimType();
		claimType.setClaimNumber("22c9c23bac142856018ce14a26b6c299");
		claimType.setAssignedAdjusterID(new Long(67890));
		VehicleListType vehicles = new VehicleListType();
		VehicleInfoType vehicleInfoType = new VehicleInfoType();
		vehicleInfoType.setModelDescription("Mustang");
		vehicleInfoType.setExteriorColor("Competition Orange");
		date = toDate("2015-04-15-07:00");
		vehicleInfoType.setLicPlateExpDate(toXMLGregorianCalendar(date));
		vehicleInfoType.setVin("1M8GDM9AXKP042788");
		vehicles.getVehicleDetails().add(vehicleInfoType);
		claimType.setVehicles(vehicles);
		claimRequest.setMitchellClaim(claimType);
		return claimRequest;
	}

	public static ReadClaimRequest createReadClaimRequest() {
		ReadClaimRequest req = new ReadClaimRequest();
		req.setClaimNumber("22c9c23bac142856018ce14a26b6c299");
		return req;
	}

	public static void printClaimResponse(MitchellClaimType claimType) {

		printProperties(claimType);
		printProperties(claimType.getLossInfo());
		VehicleListType listType = claimType.getVehicles();
		if (listType != null && listType.getVehicleDetails() != null)
			for (VehicleInfoType vehicleInfo : listType.getVehicleDetails())
				printProperties(vehicleInfo);
	}

	public static void printProperties(Object obj) {
		if (obj != null) {
			Class<?> objClazz = obj.getClass();
			System.out.println();
			System.out.println("******   " + objClazz.getSimpleName()
					+ "   *******");
			for (Field objField : objClazz.getDeclaredFields()) {
				objField.setAccessible(true);
				try {
					Object value = objField.get(obj);
					if (!(value == null || value instanceof LossInfoType || value instanceof VehicleListType)) {
						System.out.println(objField.getName()
								+ "     =====>>>   " + value);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println();
		}
	}

	public static DateRangeRequest getDateRangeRequest() {
		DateRangeRequest dateRangeRequest = new DateRangeRequest();
		dateRangeRequest
				.setStartDate(toXMLGregorianCalendar(toDate("2013-03-10-07:00")));
		dateRangeRequest
				.setEndDate(toXMLGregorianCalendar(toDate("2015-03-10-07:00")));
		return dateRangeRequest;
	}

	public static Date toDate(String dateStr) {
		Date date = null;
		try {
			// date = toDate("2014-07-09T17:19:13.631-07:00");
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd-HH:mm");
			date = formatter.parse(dateStr);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/*
	 * Converts java.util.Date to javax.xml.datatype.XMLGregorianCalendar
	 */
	public static XMLGregorianCalendar toXMLGregorianCalendar(Date date) {
		if (date != null) {
			GregorianCalendar gCalendar = new GregorianCalendar();
			gCalendar.setTime(date);
			XMLGregorianCalendar xmlCalendar = null;
			try {
				xmlCalendar = DatatypeFactory.newInstance()
						.newXMLGregorianCalendar(gCalendar);
			} catch (DatatypeConfigurationException ex) {
				ex.printStackTrace();
			}
			return xmlCalendar;
		} else {
			return null;
		}
	}
}
