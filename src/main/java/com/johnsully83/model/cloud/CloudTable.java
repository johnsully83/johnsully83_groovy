package com.johnsully83.model.cloud;

import java.io.Serializable;
import java.util.Date;

public interface CloudTable<PK extends Comparable<PK>> extends Serializable {
	
	public PK getPk();
	
	public void setPk(PK pk);
	
	public Date getDateAdded();
	
	public void setDateAdded(Date dateAdded);
	
	public Date getDateLastModified();
	
	public void setDateLastModified(Date dateLastModified);
	
	public Boolean getIsDeleted();
	
	public void setIsDeleted(Boolean isDeleted);
	
}
