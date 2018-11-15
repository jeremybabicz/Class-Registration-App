package edu.depaul.cdm.se.campusconnect.student.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import edu.depaul.cdm.se.campusconnect.student.IStudent;

import edu.depaul.cdm.se.campusconnect.classpackage.jpa.Class;


@Entity
@NamedQuery(name = "findAllStudents", query = "select b from Student b")
@Inheritance(strategy = InheritanceType.JOINED)
public class Student implements Serializable, IStudent {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotNull
    @Column(name = "id")
    private Long id;
    
    @Column(name = "f_name")
    private String firstName;
    
    @Column(name = "l_name")
    private String lastName;
    
    
    private String year;
    
    @Column(name = "student_type")
    private String studentType;
    
    private String major;
    
    
    @ManyToMany//(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "class_list",
			joinColumns = { @JoinColumn(name = "student_id") },
			inverseJoinColumns = { @JoinColumn(name = "class_id") })
    private List<Class> classes = new ArrayList<>();
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}

	@Override
	public String getYear() {
		// TODO Auto-generated method stub
		return year;
	}

	@Override
	public String getStudentType() {
		// TODO Auto-generated method stub
		return studentType;
	}

	@Override
	public String getMajor() {
		// TODO Auto-generated method stub
		return major;
	}
	
	@Override
	public List<Class> getClasses() {
		return classes;
	}
	
	
	@Override
	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}

	@Override
	public void setId(Long student_id) {
		// TODO Auto-generated method stub
		this.id = student_id;
	}

	@Override
	public void setFirstName(String f_name) {
		// TODO Auto-generated method stub
		this.firstName = f_name;
	}

	@Override
	public void setLastName(String l_name) {
		// TODO Auto-generated method stub
		this.lastName = l_name;
	}

	@Override
	public void setYear(String year) {
		// TODO Auto-generated method stub
		this.year = year;
	}

	@Override
	public void setStudentType(String student_type) {
		// TODO Auto-generated method stub
		this.studentType = student_type;
	}

	@Override
	public void setMajor(String major) {
		// TODO Auto-generated method stub
		this.major = major;
	}
	
	@Override
    public boolean equals(Object object) {
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
	
	@Override
    public String toString() {
        StringBuilder retval = new StringBuilder();
        retval.append("Student{");
        retval.append("id=");
        retval.append(id);
        retval.append(", Name=");
        retval.append(lastName);
        retval.append(", ");
        retval.append(firstName);

        return retval.toString();

    }
}
