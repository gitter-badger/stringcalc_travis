package is.ru.stringcalculator;

import java.util.Arrays;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static int add(String text) throws Exception{
		try {
			return sum(splitNumbers(text));			
		}
		catch (Exception e) {
			throw e;	
		}
		
	}

	private static int toInt(String number){
		if (number.isEmpty()) 
			return 0;
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		if (numbers.contains("//")) {  
                        Integer numberStart = numbers.indexOf("\n") + 1;
			return numbers.substring(numberStart).split(getCustomDelimeter(numbers));
		}
		else{
			return numbers.split("[,:\n]");
		}
	}

	private static String getCustomDelimeter(String numbers){
                ArrayList<String> delimeters = new ArrayList<String>();
                Matcher m = Pattern.compile("\\[(.*?)\\]").matcher(numbers);
                while (m.find()){
			delimeters.add(m.group(1).substring(0,1));
		}
		if (delimeters.isEmpty()) {
			return numbers.substring(2,3);
		}
		else{
			String expr = "[" + StringUtils.join(delimeters,":") + ":,:\n]";			
			return StringUtils.join(expr);		
		}
	}

	private static int sum(String[] numbers) throws Exception{
                System.out.println(Arrays.toString(numbers));
		ArrayList<String> errorList = new ArrayList<String>();
		int total = 0;
		for(String numberString : numbers){
			Integer number = toInt(numberString);
			if (number < 0){
				errorList.add(numberString);
			}
			if (number < 1000)
				total += number;
		}
                
		if (!errorList.isEmpty()){
			String message = StringUtils.join(errorList,",");
			throw new Exception("Negatives not allowed: " + message);
		}

		return total;
	}



}
