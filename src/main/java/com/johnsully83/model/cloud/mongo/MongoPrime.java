package com.johnsully83.model.cloud.mongo;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.johnsully83.model.cloud.MongoCloudTable;
import com.johnsully83.model.cloud.jpa.Prime;

@Document(collection="Prime")
public class MongoPrime implements MongoCloudTable<Integer> {
	private static final long serialVersionUID = 7411914084961501339L;
	
	@Id
	@Indexed
	private Integer id;

	private BigInteger prime;
	
	public MongoPrime() {
		super();
	}

	public MongoPrime(Integer id, BigInteger prime) {
		super();
		this.id = id;
		this.prime = prime;
	}

	public MongoPrime(Prime prime) {
		super();
		this.id=prime.getPk();
		this.prime=prime.getPrime();
	}


	public MongoPrime(BigInteger prime) {
		super();
		this.prime = prime;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public BigInteger getPrime() {
		return prime;
	}

	public void setPrime(BigInteger prime) {
		this.prime = prime;
	}

}
