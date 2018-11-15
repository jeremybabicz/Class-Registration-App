package edu.depaul.cdm.se.campusconnect.quarter.jpa;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

import edu.depaul.cdm.se.campusconnect.quarter.IQuarter;


@Entity
@NamedQuery(name = "findAllMajors", query = "select b from Major b")
public class Quarter implements IQuarter, Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Long id;
	
	@Field("quarter_name")
	private String quarterName;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getQuarterName() {
		return quarterName;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public void setQuarterName(String quarter_name) {
		this.quarterName = quarter_name;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
	
	 @Override
	    public boolean equals(Object object) {
	        if (!(object instanceof Quarter)) {
	            return false;
	        }
	        Quarter other = (Quarter) object;
	        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        StringBuilder retval = new StringBuilder();
	        retval.append("Quarter{");
	        retval.append("id=");
	        retval.append(id);
	        retval.append(", quarter name=");
	        retval.append(quarterName);

	        return retval.toString();

	    }

}
