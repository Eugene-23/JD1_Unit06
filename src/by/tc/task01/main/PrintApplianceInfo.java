package by.tc.task01.main;

import java.util.List;

import by.tc.task01.entity.Appliance;

public class PrintApplianceInfo {
	
	public static void print(List<Appliance> appliance) {
		
		if (appliance.isEmpty()) {
			System.out.println("there is no appliances");
			
		} else {
			for (Appliance apl : appliance) {
				System.out.println(apl.toString());
			}
		}
		System.out.println("--------------------------------------------------------------------------------------");
	}	
}
