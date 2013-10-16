package com.johnsully83.model.enumeration.crypto;

public enum CryptoMethod {
	ENCRYPT("encrypt"),
	DECRYPT("decrypt");
	;
	
	private final String value;
	
	private CryptoMethod(String value) {
		this.value = value;
	}
	
	public String value() {
		return value;
	}
	
	public static CryptoMethod value(String value) {
		for(CryptoMethod method : CryptoMethod.values()) {
			if(method.value().equalsIgnoreCase(value)) {
				return method;
			}
		}
		
		throw new IllegalArgumentException(value);
	}

}
