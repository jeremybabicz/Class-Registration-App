package edu.depaul.cdm.se.campusconnect.classpackage.jpa;

import edu.depaul.cdm.se.campusconnect.classpackage.IClass;
import edu.depaul.cdm.se.campusconnect.student.jpa.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity//(name = "Class")
@Table(name = "class")
@NamedQuery(name = "findAllClasses", query = "select b from Class b")
public class Class implements Serializable, IClass {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Long id;
	
	private String subject;
	
	@Column(name = "course_num")
	private Integer courseNumber;
	
	@Column(name = "course_name")
	private String courseName;
	
	private String quarter;
	
	@ManyToMany(/*cascade = {CascadeType.PERSIST, CascadeType.MERGE},*/ mappedBy = "classes")
	private List<Student> students = new ArrayList<>();
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getSubject() {
		// TODO Auto-generated method stub
		return subject;
	}

	@Override
	public Integer getCourseNumber() {
		// TODO Auto-generated method stub
		return courseNumber;
	}

	@Override
	public String getCourseName() {
		// TODO Auto-generated method stub
		return courseName;
	}

	@Override
	public String getQuarter() {
		// TODO Auto-generated method stub
		return quarter;
	}
	
	@Override
	public List<Student> getStudents() {
		return students;
	}
	
	@Override
	public void setStudents(List <Student> students) {
		this.students = students;
	}

	@Override
	public void setId(Long class_id) {
		// TODO Auto-generated method stub
		this.id = class_id;
	}

	@Override
	public void setSubject(String subject) {
		// TODO Auto-generated method stub
		this.subject = subject;

	}

	@Override
	public void setCourseNumber(Integer course_num) {
		// TODO Auto-generated method stub
		this.courseNumber = course_num;
	}

	@Override
	public void setCourseName(String course_name) {
		// TODO Auto-generated method stub
		this.courseName = course_name;
	}

	@Override
	public void setQuarter(String quarter) {
		// TODO Auto-generated method stub
		this.quarter = quarter;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
	
	 @Override
	    public boolean equals(Object object) {
	        if (!(object instanceof Class)) {
	            return false;
	        }
	        Class other = (Class) object;
	        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        StringBuilder retval = new StringBuilder();
	        retval.append("Class{");
	        retval.append("id=");
	        retval.append(id);
	        retval.append(", subject=");
	        retval.append(subject);
	        retval.append(" , course num=");
	        retval.append(courseNumber);
	        retval.append(" , course name=");
	        retval.append(courseName);
	        retval.append(" , quarter=");
	        retval.append(quarter);

	        return retval.toString();

	    }

}
