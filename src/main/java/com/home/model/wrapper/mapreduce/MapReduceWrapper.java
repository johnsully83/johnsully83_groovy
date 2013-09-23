package com.home.model.wrapper.mapreduce;

import java.io.Serializable;

public interface MapReduceWrapper extends Serializable {
	
	@Override
	public abstract int hashCode();
	
	@Override
	public boolean equals(Object obj);
	
	@Override
	public String toString();

}
