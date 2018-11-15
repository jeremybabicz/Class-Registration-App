package edu.depaul.cdm.se.campusconnect.student_type.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

import edu.depaul.cdm.se.campusconnect.classpackage.jpa.Class;
import edu.depaul.cdm.se.campusconnect.student_type.IStudentType;

@Entity
@NamedQuery(name = "findAllStudentTypes", query = "select b from StudentType b")
public class StudentType implements Serializable, IStudentType {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Long id;
	
	@Field("type_name")
	private String studentTypeName;
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getStudentTypeName() {
		return studentTypeName;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public void setStudentTypeName(String type_name) {
		this.studentTypeName = type_name;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
	
	 @Override
	    public boolean equals(Object object) {
	        if (!(object instanceof StudentType)) {
	            return false;
	        }
	        StudentType other = (StudentType) object;
	        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        StringBuilder retval = new StringBuilder();
	        retval.append("StudentType{");
	        retval.append("id=");
	        retval.append(id);
	        retval.append(", type name=");
	        retval.append(studentTypeName);

	        return retval.toString();

	    }

}
