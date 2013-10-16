package com.johnsully83.model.wrapper.mapreduce.implementations;

import java.util.Arrays;

import com.johnsully83.model.wrapper.mapreduce.MapReduceWrapper;

public class RoguePrime implements MapReduceWrapper {
	private static final long serialVersionUID = 32373900831935921L;
	
	private int firstIndexToFind;
	private String nextKnownPrime;
	private int duplicateEntries;
	private String[] allPrimesForIndex;
	
	public RoguePrime() {
		super();
	}

	public RoguePrime(int firstIndexToFind, String nextKnownPrime) {
		super();
		this.firstIndexToFind = firstIndexToFind;
		this.nextKnownPrime = nextKnownPrime;
	}

	public int getFirstIndexToFind() {
		return firstIndexToFind;
	}

	public void setFirstIndexToFind(int firstIndexToFind) {
		this.firstIndexToFind = firstIndexToFind;
	}

	public String getNextKnownPrime() {
		return nextKnownPrime;
	}

	public void setNextKnownPrime(String nextKnownPrime) {
		this.nextKnownPrime = nextKnownPrime;
	}

	public int getDuplicateEntries() {
		return duplicateEntries;
	}

	public void setDuplicateEntries(int duplicateEntries) {
		this.duplicateEntries = duplicateEntries;
	}

	public String[] getAllPrimesForIndex() {
		return allPrimesForIndex;
	}

	public void setAllPrimesForIndex(String[] allPrimesForIndex) {
		this.allPrimesForIndex = allPrimesForIndex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(allPrimesForIndex);
		result = prime * result + duplicateEntries;
		result = prime * result + firstIndexToFind;
		result = prime * result
				+ ((nextKnownPrime == null) ? 0 : nextKnownPrime.hashCode());
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
		RoguePrime other = (RoguePrime) obj;
		if (!Arrays.equals(allPrimesForIndex, other.allPrimesForIndex))
			return false;
		if (duplicateEntries != other.duplicateEntries)
			return false;
		if (firstIndexToFind != other.firstIndexToFind)
			return false;
		if (nextKnownPrime == null) {
			if (other.nextKnownPrime != null)
				return false;
		} else if (!nextKnownPrime.equals(other.nextKnownPrime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String
				.format("RoguePrime {\n firstIndexToFind: %s,\n nextKnownPrime: %s,\n duplicateEntries: %s,\n allPrimesForIndex: %s\n}",
						firstIndexToFind, nextKnownPrime, duplicateEntries,
						Arrays.toString(allPrimesForIndex));
	}
	
}
