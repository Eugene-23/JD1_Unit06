package by.tc.task01.dao.impl;

import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.*;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;


public class ApplianceDAOImpl implements ApplianceDAO {

	private static final String SOURCE = "resources/appliances_db.txt";

	@Override
	public List<Appliance> find(Criteria criteria) throws DAOException {
		
		List<Appliance> result = new ArrayList<Appliance>();
		FileReader reader = null;
		Map<String, String> params;
		
		try {
			reader = new FileReader(SOURCE);
			
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(reader);
			
			while(scan.hasNextLine()) {
				
				String str = scan.nextLine();
				
				String groupSearchName = str.split(":")[0].trim();
								
				if (groupSearchName.equals(criteria.getGroupSearchName())) {
					
					params = getParamsMap(str);
										
					if (compareParamsAndCriteria(params, criteria.getCriteria())) {
						result.add(CreateAppliance.createAppliance(params));
					}										
				}				
			}			
			
		} catch (IOException e) {
			throw new DAOException(e);
			
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new DAOException(e);
				}
			}			
		}		
		return result;
	}

	
	private static Map<String, String> getParamsMap(String str) {

		Map<String, String> result = new HashMap<String, String>();

		Pattern pattern = Pattern.compile("\\s?[,:;]?\\s+");		
		String[] params = pattern.split(str);
		
		result.put("name", params[0]);
		
		for (int i = 1; i < params.length; i++) {
			
			result.put(params[i].split("=")[0], params[i].split("=")[1]);			
		}				
		return result;
	}
	
	private boolean compareParamsAndCriteria(Map<String, String> params, Map<String, String> criteria) {
		
		boolean result = false;
		Set<String> keys = criteria.keySet();
		for (String str : keys) {
			if (params.get(str).equals(criteria.get(str))) {
				result = true;
			}
		}
		return result;
	}
	
}
