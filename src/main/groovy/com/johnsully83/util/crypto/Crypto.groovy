package com.johnsully83.util.crypto

import com.johnsully83.exception.crypto.CryptoException
import com.johnsully83.util.crypto.implementations.Base64
import com.johnsully83.util.crypto.implementations.RC4
import com.johnsully83.util.crypto.implementations.TripleDES


class Crypto {

	public static byte[] base64Decode(String encrypedAndEncoded) {
		return Base64.base64Decode(encrypedAndEncoded);
	}
	
	public static String base64Encode(byte[] value) {
		return Base64.base64Encode(value);
	}
	
	/*
	 * RC4
	 */
	public static String rc4EncryptAndEncode(String value, String hexKey) throws CryptoException {
		return RC4.encryptAndEncode(value, hexKey);
	}
	
	public static String rc4DecodeAndDecrypt(String value, String hexKey) throws CryptoException {
		return RC4.decodeAndDecrypt(value, hexKey);
	}
	
	public static byte[] rc4Encrypt(String input, String keyString) throws CryptoException {
		return RC4.encrypt(input, keyString);
	}
	
	public static String rc4Decrypt(byte[] input, String keyString) throws CryptoException {
		return RC4.decrypt(input, keyString);
	}
	
	/*
	 * Triple DES
	 */
	public static String tripleDESEncryptAndEncode(String value, String hexKey) throws CryptoException {
		return TripleDES.encryptAndEncode(value, hexKey);
	}
	
	public static String tripleDESDecodeAndDecrypt(String value, String hexKey) throws CryptoException {
		return TripleDES.decodeAndDecrypt(value, hexKey);
	}
	
	public static byte[] tripleDESEncrypt(String input, String keyString) throws CryptoException {
		return TripleDES.encrypt(input, keyString);
	}
	
	public static String tripleDESDecrypt(byte[] input, String keyString) throws CryptoException {
		return TripleDES.decrypt(input, keyString);
	}
	
}
