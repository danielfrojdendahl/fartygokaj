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
	private static String name;
	
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
	        System.out.println("Valid Licenses are as following: ");
	        System.out.println("A, AA, B, BB, C, CC, CCC, K");
	        validatedDriversLicense = TextUtil.getReply("DriversLicenses: ");
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
	        System.out.println("Valid Status for employees are as following: ");
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
		String validatedName = TextUtil.getReply("Namn: ");
		while (validatedName.matches(".*\\d.*")) {
				System.out.println("Namn kan inte innehålla siffror!");
				validatedName = TextUtil.getReply("Namn: ");
		}
		return validatedName;
	}
	
}
