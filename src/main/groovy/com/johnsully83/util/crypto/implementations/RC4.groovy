package com.johnsully83.util.crypto.implementations

import java.security.GeneralSecurityException

import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

import org.apache.commons.codec.binary.StringUtils

import com.johnsully83.exception.crypto.CryptoException
import com.johnsully83.util.crypto.Base

class RC4 extends Base {
	
	public static String generateKey() {
		return base64Encode(KeyGenerator.getInstance(RC4_ALGORITHM).generateKey().getEncoded());
	}
	
	public static String encryptAndEncode(String value, String hexKey) throws CryptoException {
		try {
			return base64Encode(encrypt(value, hexKey));
		} catch(Exception e) {
			throw new CryptoException("Error encrypting and base64 encoding value "+value+" with RC4 with passed in key", e);
		}
	}
	
	public static String decodeAndDecrypt(String value, String hexKey) throws CryptoException {
		try {
			return decrypt(base64Decode(value), hexKey);
		} catch (Exception e) {
			throw new CryptoException("Error base64 decoding and decrypting value "+value+" with RC4 with passed in key", e);
		}
	}
	
	public static byte[] encrypt(String input, String keyString) throws CryptoException {
		try {
			byte[] key = base64Decode(keyString);
			
			return encryptRaw(input.getBytes(CHARSET), key);
		} catch(Exception e) {
			throw new CryptoException("Error encrypting with passed in key for raw byte array", e);;
		}
	}
	
	public static String decrypt(byte[] input, String keyString) throws CryptoException {
		try {
			byte[] key = base64Decode(keyString);
	
			return new String(decryptRaw(input, key), CHARSET);
		} catch(Exception e) {
			throw new CryptoException("Error decrypting raw byte array with passed in key", e);;
		}
	}

	private static byte[] encryptRaw(byte[] input, byte[] key) throws GeneralSecurityException {
		SecretKey keySpec = new SecretKeySpec(key, RC4_ALGORITHM);
		
		Cipher encrypter = Cipher.getInstance(RC4_ALGORITHM);
		encrypter.init(Cipher.ENCRYPT_MODE, keySpec);
		
		return encrypter.doFinal(input);
	}

	private static byte[] decryptRaw(byte[] input, byte[] key) throws GeneralSecurityException {
		SecretKey keySpec = new SecretKeySpec(key, RC4_ALGORITHM);

		Cipher decrypter = Cipher.getInstance(RC4_ALGORITHM);
		decrypter.init(Cipher.DECRYPT_MODE, keySpec);
		
		return decrypter.doFinal(input);
	}
	
}
