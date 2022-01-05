package com.cms.RestControllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.entity.CourseDao;
import com.cms.model.Course;
import com.cms.services.CourseService;

@RestController
@RequestMapping("/courses")
public class RestCourseController {
	@Autowired
	CourseService courseService;
	
	@PostMapping("/add")
//	public String addcourse(@RequestBody Course course) {
	public Course addcourse(@RequestBody Course course) {
		System.out.println("RestCourseController.addcourse()");
		Optional<Course> addCourse = courseService.addCourse(course);
		System.out.println(addCourse.isPresent()? addCourse.get().getName() + " is created Successfully ":"Unable to Save");
//		return addCourse.isPresent()? addCourse.get().getName() + " is created Successfully ":"Unable to Save";
		return addCourse.isPresent()? addCourse.get():null;
	}
	
	@GetMapping(value="/list")
	public List<CourseDao> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@PutMapping(value="/update")
	public void updateCourse(@RequestBody CourseDao course) {
		courseService.updateCourse(course);
	}
	
	@GetMapping("/{id}")
	public CourseDao  getCourse(@PathVariable("id") int id) {
		return courseService.getCourse(id);
	}
	
	@DeleteMapping("/course/release/{id}")
	public void releaseCourse(@PathVariable int id) {
		courseService.deleteCourse(id);
	}
	
}





















