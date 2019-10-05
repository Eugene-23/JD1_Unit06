package by.tc.task01.dao.impl;

import java.util.Map;

import by.tc.task01.dao.DAOException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.SearchCriteria;

public class CreateAppliance {
	
	private final static String NAME = "name";
	
	public static Appliance createAppliance(Map<String, String> params) throws DAOException {
		
		Appliance newAppliance;
		
		String nameAppliance = params.get(NAME);
		
		switch (nameAppliance) {
		case "Oven":
			newAppliance = createOven(params);
			break;
		case "Laptop":
			newAppliance = createLaptop(params);
			break;
		case "Refrigerator":
			newAppliance = createRefrigerator(params);
			break;
		case "VacuumCleaner":
			newAppliance = createVacuumCleaner(params);
			break;
		case "TabletPC":
			newAppliance = createTabletPC(params);
			break;
		case "Speakers":
			newAppliance = createSpeakers(params);
			break;
		default:
			newAppliance = null;
		}
		
		return newAppliance;
	}

	private static Oven createOven(Map<String, String> params) {
		Oven newOven;
		
		String name = params.get(NAME);
		int powerConsumption = Integer.parseInt( params.get(SearchCriteria.Oven.POWER_CONSUMPTION.toString()) );
		int weight = Integer.parseInt( params.get(SearchCriteria.Oven.WEIGHT.toString()) );
		int capacity = Integer.parseInt( params.get(SearchCriteria.Oven.CAPACITY.toString()) );
		int depth = Integer.parseInt( params.get(SearchCriteria.Oven.DEPTH.toString()) );
		double height = Double.parseDouble( params.get(SearchCriteria.Oven.HEIGHT.toString()) );
		double width = Double.parseDouble( params.get(SearchCriteria.Oven.WIDTH.toString()) );
		
		newOven = new Oven(name, powerConsumption, weight, capacity, depth, height, width);
		
		return newOven;
	}

	private static Laptop createLaptop(Map<String, String> params) {
		Laptop newLaptop = new Laptop();
		
		newLaptop.setName(params.get(NAME));
		newLaptop.setBatteryCapacity( Double.parseDouble(params.get(SearchCriteria.Laptop.BATTERY_CAPACITY.toString()) ) );
		newLaptop.setOs(params.get(SearchCriteria.Laptop.OS.toString()) );
		newLaptop.setMemoryRom( Integer.parseInt(params.get(SearchCriteria.Laptop.MEMORY_ROM.toString()) ) );
		newLaptop.setSystemMemory( Integer.parseInt(params.get(SearchCriteria.Laptop.SYSTEM_MEMORY.toString()) ) );
		newLaptop.setCpu( Double.parseDouble(params.get(SearchCriteria.Laptop.CPU.toString()) ) );
		newLaptop.setDisplayInchs( Integer.parseInt(params.get(SearchCriteria.Laptop.DISPLAY_INCHS.toString()) ) );
		
		return newLaptop;
	}

	private static Refrigerator createRefrigerator(Map<String, String> params) {
		Refrigerator newRefrigerator = new Refrigerator();
		
		newRefrigerator.setName(params.get(NAME));
		newRefrigerator.setPowerConsumption( Integer.parseInt(params.get(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString()) ) );
		newRefrigerator.setWeight( Integer.parseInt(params.get(SearchCriteria.Refrigerator.WEIGHT.toString()) ) );
		newRefrigerator.setFreezerCapacity( Integer.parseInt(params.get(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString()) ) );
		newRefrigerator.setOverallCapacity( Double.parseDouble(params.get(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString()) ) );
		newRefrigerator.setHeight( Integer.parseInt(params.get(SearchCriteria.Refrigerator.HEIGHT.toString()) ) );
		newRefrigerator.setWidth( Integer.parseInt(params.get(SearchCriteria.Refrigerator.WIDTH.toString()) ) );
		
		return newRefrigerator;
	}

	private static VacuumCleaner createVacuumCleaner(Map<String, String> params) {
		VacuumCleaner newVacuumCleaner = new VacuumCleaner();
		
		newVacuumCleaner.setName(params.get(NAME));
		newVacuumCleaner.setPowerConsumption( Integer.parseInt(params.get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString()) ) );
		newVacuumCleaner.setFilterType(params.get(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString()) );
		newVacuumCleaner.setBagType(params.get(SearchCriteria.VacuumCleaner.BAG_TYPE.toString()) );
		newVacuumCleaner.setWandType(params.get(SearchCriteria.VacuumCleaner.WAND_TYPE.toString()) );
		newVacuumCleaner.setMotorSpeeadRegulation( Integer.parseInt(params.get(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString()) ) );
		newVacuumCleaner.setCleaningWidth( Integer.parseInt(params.get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString()) ) );
		
		return newVacuumCleaner;
	}

	private static TabletPC createTabletPC(Map<String, String> params) {
		TabletPC newTabletPC = new TabletPC();
		
		newTabletPC.setName(params.get(NAME));
		newTabletPC.setBatteryCapacyti( Integer.parseInt(params.get(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString()) ) );
		newTabletPC.setDisplayInches( Integer.parseInt(params.get(SearchCriteria.TabletPC.DISPLAY_INCHES.toString()) ) );
		newTabletPC.setMemoryRom( Integer.parseInt(params.get(SearchCriteria.TabletPC.MEMORY_ROM.toString()) ) );
		newTabletPC.setFlashMemoryCapasity( Integer.parseInt(params.get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString()) ) );
		newTabletPC.setColor(params.get(SearchCriteria.TabletPC.COLOR.toString()) );
		
		return newTabletPC;
	}

	private static Speakers createSpeakers(Map<String, String> params) {
		Speakers newSpeakers = new Speakers();
		
		newSpeakers.setName(params.get(NAME));
		newSpeakers.setPowerConsumption( Integer.parseInt(params.get(SearchCriteria.Speakers.POWER_CONSUMPTION.toString()) ) );
		newSpeakers.setNumberOfSpeakers( Integer.parseInt(params.get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString()) ) );
		newSpeakers.setFrequencyRange(params.get(SearchCriteria.Speakers.FREQUENCY_RANGE.toString()) );
		newSpeakers.setCordLength( Integer.parseInt(params.get(SearchCriteria.Speakers.CORD_LENGTH.toString()) ) );
		
		return newSpeakers;
	}

}
