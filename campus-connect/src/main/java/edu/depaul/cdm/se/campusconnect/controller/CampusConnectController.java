package edu.depaul.cdm.se.campusconnect.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.depaul.cdm.se.campusconnect.quarter.jpa.Quarter;
import edu.depaul.cdm.se.campusconnect.quarter.mongo.QuarterRepository;
import edu.depaul.cdm.se.campusconnect.student.jpa.Student;
import edu.depaul.cdm.se.campusconnect.student.spring.StudentRepository;
import edu.depaul.cdm.se.campusconnect.student_type.jpa.StudentType;
import edu.depaul.cdm.se.campusconnect.student_type.mongo.StudentTypeRepository;
import edu.depaul.cdm.se.campusconnect.year.jpa.Year;
import edu.depaul.cdm.se.campusconnect.year.mongo.YearRepository;
import edu.depaul.cdm.se.campusconnect.classpackage.jpa.Class;
import edu.depaul.cdm.se.campusconnect.classpackage.spring.ClassRepository;
import edu.depaul.cdm.se.campusconnect.major.jpa.Major;
import edu.depaul.cdm.se.campusconnect.major.mongo.MajorRepository;

//controller for home
@Controller
public class CampusConnectController {
	@Value("${spring.application.name}")
    private String appName;
	
	@Autowired
	QuarterRepository quarterRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	ClassRepository classRepository;
	@Autowired
	YearRepository yearRepository;
	@Autowired
	StudentTypeRepository studentTypeRepository;
	@Autowired
	MajorRepository majorRepository;
	
	//A wrapper to help with ThymeLeaf binding and saving the student's enrolled classes
	ClassListWrapper classListWrapper = new ClassListWrapper();
	
	//change div in chooseClassResult so correct data gets renderded 
	Boolean enrollingFromDropped = false;
	
	Quarter quarter = new Quarter();
	String choosenQuarterName;
	
    Long studentId;
	
    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        model.addAttribute("student", new Student());
        
        List <Year> yearList = yearRepository.findAll();
        model.addAttribute("yearList", yearList);
        List <StudentType> studentTypeList = studentTypeRepository.findAll();
        model.addAttribute("studentTypeList", studentTypeList);
        List <Major> majorList = majorRepository.findAll();
        model.addAttribute("majorList", majorList);
         
        return "home";
    }
    
    @PostMapping("/")
    public String homePageSubmit(@ModelAttribute Student student) {
    	studentRepository.save(student);
    	
    	studentId = student.getId();
    	
    	return "studentResult";
    }
    
    @GetMapping("/quarter")
    public String quarterPage(Model model) {
    	
    	
    	List <Quarter> quarterList = quarterRepository.findAll();
    	
    	model.addAttribute("class", new Class());
    	model.addAttribute("quarter", quarter);
    	model.addAttribute("quarterList", quarterList);
    	return "quarter";
    }
    
    
    @GetMapping("/chooseClass")
    public String chooseClassPage(Model model, @ModelAttribute Quarter quarter, @ModelAttribute Student student) {
    	
    	//to ensure there is nothing in our classListWrapper
    	classListWrapper.getClassList().clear();
    	
    	//change div in chooseClassResult 
    	enrollingFromDropped = false;
    	
    	
    	this.quarter = quarter;
    	
    	if(quarter.getQuarterName() == null)
    	{
    		quarter.setQuarterName(choosenQuarterName); 
    	}
    	else
    		choosenQuarterName = quarter.getQuarterName();
    	
    	
    	student = studentRepository.getOne(studentId);
    	
    	List<Class> classList = classRepository.findByQuarter(quarter.getQuarterName());
    	
    	model.addAttribute("quarter", quarter);
    	model.addAttribute("classList", classList);
    	
    	return "chooseClass";
    } 
    
    @PostMapping("/chooseClass")
    public String chooseClassPageResult(Model model, @ModelAttribute Student student, @ModelAttribute Quarter quarter){
    	
    	student = studentRepository.getOne(studentId);
    	
    	model.addAttribute("classListWrapper", classListWrapper);
    	
    	model.addAttribute("quarter", quarter);
    	
    	model.addAttribute("enrollingFromDropped", enrollingFromDropped);
    	
    	return "chooseClassResult";
    }
    
    @GetMapping("/dropClass")
    public String dropClass(Model model, @ModelAttribute Student student) {
    	
    	model.addAttribute("classListWrapper", classListWrapper);
    	
    	student = studentRepository.getOne(studentId);
    	
    	student.setClasses(classListWrapper.getClassList());
    	
    	studentRepository.save(student);
    	
    	return "dropClass";	
    }
    
    @PostMapping("/dropClass")
    public String dropClassResult(Model model, @ModelAttribute Student student) {
    	student = studentRepository.getOne(studentId);
    	
    	//change div in chooseClassResult
    	enrollingFromDropped = true;
    	
    	model.addAttribute("classListWrapper", classListWrapper);
    	
    	return "dropClassResult";
    }
    
    
    
    @GetMapping("/finishedEnroll")
    public String finishedEnrollPage(Model model, @ModelAttribute Student student) {
    	
    	quarter.setQuarterName(choosenQuarterName);
    	
    	model.addAttribute("quarter", quarter);
    	model.addAttribute("classListWrapper", classListWrapper);
    	
    	student = studentRepository.getOne(studentId);
    	
    	student.setClasses(classListWrapper.getClassList());
    	
    	studentRepository.save(student);
    	
    	return"finishedEnroll";
    }
    
    
}
