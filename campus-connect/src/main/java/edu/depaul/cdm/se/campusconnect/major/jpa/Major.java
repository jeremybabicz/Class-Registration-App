package edu.depaul.cdm.se.campusconnect.major.jpa;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

import edu.depaul.cdm.se.campusconnect.major.IMajor;

@Entity
@NamedQuery(name = "findAllMajors", query = "select b from Major b")
public class Major implements Serializable, IMajor {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Long id;
	
	@Field("major_name")
	private String majorName;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getMajorName() {
		return majorName;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public void setMajorName(String major_name) {
		this.majorName = major_name;

	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
	
	 @Override
	    public boolean equals(Object object) {
	        if (!(object instanceof Major)) {
	            return false;
	        }
	        Major other = (Major) object;
	        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        StringBuilder retval = new StringBuilder();
	        retval.append("Major{");
	        retval.append("id=");
	        retval.append(id);
	        retval.append(", major name=");
	        retval.append(majorName);

	        return retval.toString();

	    }

}
