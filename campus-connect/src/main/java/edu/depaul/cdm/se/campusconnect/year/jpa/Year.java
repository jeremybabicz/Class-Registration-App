package edu.depaul.cdm.se.campusconnect.year.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

import edu.depaul.cdm.se.campusconnect.student.jpa.Student;
import edu.depaul.cdm.se.campusconnect.year.IYear;

@Entity
@NamedQuery(name = "findAllYears", query = "select b from Year b")
public class Year extends Student implements Serializable, IYear {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "id")
	private Long year_id;
	
	@Field("year_name")
	private String yearName;
	
	@Override
	public Long getId() {
		return year_id;
	}

	@Override
	public String getYearName() {
		return yearName;
	}

	@Override
	public void setId(Long id) {
		this.year_id = id;
	}

	@Override
	public void setYearName(String year_name) {
		this.yearName = year_name;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (year_id != null ? year_id.hashCode() : 0);
        return hash;
    }
	
	 @Override
	    public boolean equals(Object object) {
	        if (!(object instanceof Year)) {
	            return false;
	        }
	        Year other = (Year) object;
	        if ((this.year_id == null && other.year_id != null) || (this.year_id != null && !this.year_id.equals(other.year_id))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        StringBuilder retval = new StringBuilder();
	        retval.append("Year{");
	        retval.append("id=");
	        retval.append(year_id);
	        retval.append(", year name=");
	        retval.append(yearName);

	        return retval.toString();

	    }

}
