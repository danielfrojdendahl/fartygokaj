package se.iths.Skeppokaj.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelpUtil {

	final static List<String> machineTypes = Arrays.asList("A001", "AA01", "B001", "BB01", "C001", "CC01", "CCC1", "K001" );
	final static List<String> driversLicenseType = Arrays.asList("A", "AA", "B", "BB", "C", "CC", "CCC", "K" );
	final static List<String> statusType = Arrays.asList("100%", "50%", "0%", "Sjuk", "VAB", "Studier", "Semester");
	final static List<String> schemaType = Arrays.asList("MF", "L", "S");
	final static List<String> volumeType = Arrays.asList("A001", "AA01", "B001", "BB01", "C001", "CC01", "CCC1", "K001");

	;	
	public static String validMachineType() {
		String validatedMachineType = "";
		boolean notInList = true;
		while (notInList) {
			System.out.println("A001, AA01, B001, BB01, C001, CC01, CCC1, K001");
			System.out.print("\nVälj en maskintyp ovan: ");
			validatedMachineType = TextUtil.getReply("Maskintyp: ");
			if (machineTypes.contains(validatedMachineType)) {
				notInList = false;
			}
		}
		return validatedMachineType;
	}

	public static String validVolumeType() {
		String validatedVolumeType = "";
		boolean notInList = true;
		while (notInList) {
			System.out.println("Tillåtna volymtyper för skepp är: ");
			System.out.println("A001, AA01, B001, BB01, C001, CC01, CCC1, K001");
			if (volumeType.contains(validatedVolumeType)) {
				notInList = false;
			}
		}
		return validatedVolumeType;
	}

	public static String validDriversLicense() {
		String validatedDriversLicense = "";
		boolean notInList = true;
		while (notInList) {
			System.out.println("Godkända körtkortstyper är: ");
			System.out.println("A, AA, B, BB, C, CC, CCC, K");
			validatedDriversLicense = TextUtil.getReply("Körkortstyp: ");
			if (driversLicenseType.contains(validatedDriversLicense)) {
				notInList = false;
			}
		}
		return validatedDriversLicense;
	}

	public static String validPersonalStatus() {
		String validatedPersonalStatus = "";
		boolean notInList = true;
		while (notInList) {
			System.out.println("Godkänd status för personal är: ");
			System.out.println("100%, 50%, 0%, Sjuk, VAB, Studier, Semester");
			validatedPersonalStatus = TextUtil.getReply("Status: ");
			if (statusType.contains(validatedPersonalStatus)) {
				notInList = false;
			}
		}
		return validatedPersonalStatus;
	}

	public static String validSchemaType() {
		String validatedSchemaType = "";
		boolean notInList = true;
		while (notInList) {
			System.out.println("Tillåtna scheman är: ");
			System.out.println("MF, L, S");
			validatedSchemaType = TextUtil.getReply("Schema: ");
			if (schemaType.contains(validatedSchemaType)) {
				notInList = false;
			}
		}
		return validatedSchemaType;
	}


	public static String validName() {
		boolean notValidName = true;
		boolean isEmpty = true;
		String validatedName = "";    				
		while (notValidName == true || isEmpty == true) { 		       			
			validatedName = TextUtil.getReply("Förnamn: ");					
			notValidName = validatedName.matches(".*\\d.*");				
			isEmpty = validatedName.isEmpty();
			if (notValidName == true || isEmpty == true) {
				System.out.println("Namn kan inte lämnas tomt eller innehålla siffror!");
			}
			
		}
		validatedName = validatedName.trim();
		return validatedName;
	}
}
