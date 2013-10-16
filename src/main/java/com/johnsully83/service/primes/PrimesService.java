package com.johnsully83.service.primes;

import java.math.BigInteger;

import com.johnsully83.exceptions.SullyException;
import com.johnsully83.model.datatable.JQueryDataTableParameter;

public interface PrimesService {

	public BigInteger findPrime(JQueryDataTableParameter parameters) throws SullyException;
	
}
