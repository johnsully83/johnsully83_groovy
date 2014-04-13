package com.johnsully83.model.wrapper.mvc.crypto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.johnsully83.model.enumeration.crypto.CryptoMethod;

@JsonPropertyOrder(value = { "encryptionKey", "value", "method" })
@XmlRootElement(name = "encryptWrapper")
@XmlType(propOrder = { "encryptionKey", "value", "method" })
public class EncryptWrapper {
	private String encryptionKey;
	private String value;
	private CryptoMethod method;
	
	public EncryptWrapper() {
		super();
	}

	public EncryptWrapper(String encryptionKey, String value) {
		super();
		this.encryptionKey = encryptionKey;
		this.value = value;
	}
	
	public String getEncryptionKey() {
		return encryptionKey;
	}

	public void setEncryptionKey(String encryptionKey) {
		this.encryptionKey = encryptionKey;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public CryptoMethod getMethod() {
		return method;
	}

	public void setMethod(CryptoMethod method) {
		this.method = method;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((encryptionKey == null) ? 0 : encryptionKey.hashCode());
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result
				+ ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EncryptWrapper other = (EncryptWrapper) obj;
		if (encryptionKey == null) {
			if (other.encryptionKey != null)
				return false;
		} else if (!encryptionKey.equals(other.encryptionKey))
			return false;
		if (method != other.method)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String
				.format("EncryptWrapper {\n encryptionKey: %s,\n value: %s,\n method: %s\n}",
						encryptionKey, value, method);
	}

}
