package com.cms.RestControllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.model.Department;
import com.cms.services.DepartmentService;

@RestController
@RequestMapping("/dept")
public class RestDepartmentController {
	@Autowired
	DepartmentService DepartmentService;
	
	@PostMapping("/add")
//	public String addDept(@RequestBody Department Dept) {
//	public Department addDept(@RequestBody Department Dept) {
	public ResponseEntity<Department> addDept(@RequestBody Department Dept) {
		System.out.println("RestDeptController.addDept()");
		Optional<Department> addDept = DepartmentService.addDept(Dept);
		System.out.println(addDept.isPresent()? "Department "+addDept.get().getName() + " is created Successfully ":"Unable to Save");
//		return addDept.isPresent()?"Department "+  addDept.get().getName() + " is created Successfully ":"Unable to Save";
//		return addDept.isPresent() ? addDept.get() : null;
		return new ResponseEntity<Department>(addDept.get(), HttpStatus.OK);
	}
	
	@GetMapping(value="/list")
	public List<Department> getAllDepts(){
		Optional<List<Department>> allDepts = DepartmentService.getAllDepts();
		return allDepts.isPresent()?allDepts.get():null;
	}
	
	
	@GetMapping("/{id}")
	public Department  getDept(@PathVariable("id") int id) {
//		Department dept = DepartmentService.getDept(id);
		return DepartmentService.getDept(id);
	}
	
	/*@PutMapping(value="/update")
	public void updateDept(@RequestBody Department Dept) {
		DepartmentService.updateDept(Dept);
	}
	@DeleteMapping("/Dept/release/{id}")
	public void releaseDept(@PathVariable int id) {
		DepartmentService.deleteDept(id);
	}*/
	
}





















