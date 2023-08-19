package br.com.erudio.utils;

import br.com.erudio.exception.UnsupportedMathOperationException;

public class MathUtils {
	
	public Double convertToDouble(String numberStr) {
		if(numberStr == null) return 0d;
		
		// BR currency 15,5 US is 15.5 -> convert to US currency
		String number = numberStr.replaceAll(",",".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0d;
	}

	public boolean isNumeric(String numberStr) {
		if(numberStr == null) return false;
		
		// BR currency 15,5 US is 15.5 -> convert to US currency
		String number = numberStr.replaceAll(",",".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	public void checkSigleNumber(String numberOne) {
		// If number = letter or special ($#@!) return new Exception
		if(!isNumeric(numberOne)) throw new UnsupportedMathOperationException("Please set a numeric value!");		
	}
	
	public void checkTwoNumbers(String numberOne, String numberTwo) {
		// If number = letter or special ($#@!) return new Exception
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");		
	}
}
