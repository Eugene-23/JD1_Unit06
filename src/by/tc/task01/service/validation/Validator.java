package by.tc.task01.service.validation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria.Laptop;

public class Validator {
	
	public static boolean criteriaValidator(Criteria criteria) {
		
		String name = criteria.getGroupSearchName();

		switch (name) {
		case "Laptop":
			return laptopValidator(criteria);
		case "Refrigerator":
			return true;
		case "Oven":
			return true;
		case "VacuumCleaner":
			return true;
		case "TabletPC":
			return true;
		case "Speakers":
			return true;
		default:
			return false;
		}
		
	}

	private static boolean laptopValidator(Criteria criteria) {
		
		Map<String, String> validator = new HashMap<>();
		validator.put(Laptop.BATTERY_CAPACITY.toString(), "[0-9]\\.[0-9]");
		validator.put(Laptop.CPU.toString(), "[0-9]\\.[0-9]");
		validator.put(Laptop.OS.toString(), "[0-9a-zA-Z]+");
		validator.put(Laptop.DISPLAY_INCHS.toString(), "[1-2][0-9]");
		validator.put(Laptop.SYSTEM_MEMORY.toString(), "[1-9][0-9]{3,4}");

		Set<String> criteriesKeys = criteria.getCriteria().keySet();

		for (String key : criteriesKeys) {
			String regex = validator.get(key);
			String input = criteria.getCriteria().get(key);
			
			if (Pattern.matches(regex, input)) {
				return true;
			}
		}
		return false;
	}

}
