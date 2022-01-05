package com.cms.services;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.CourseDao;
import com.cms.entity.DepartmentDao;
import com.cms.entity.SectionDao;
import com.cms.entity.StudentDao;
import com.cms.model.Course;
import com.cms.model.Department;
import com.cms.model.Section;
import com.cms.model.Student;
import com.cms.repository.CourseRepository;
import com.cms.repository.DepartmentRepository;
import com.cms.repository.SectionRepository;
import com.cms.repository.StudentRepository;



@Service
@Transactional
public class CourseService {


	@Autowired
	CourseRepository courseRepository;

	@Autowired
	DepartmentRepository deptRepo;
	@Autowired
	SectionRepository SectionRepo;

	@Autowired
	StudentRepository stdRepo;


	public Optional<Course> addCourse(Course crs) {
		DepartmentDao dept = deptRepo.findById(crs.getDepartment().getId());
		//		course.getSections().stream().
		Set<SectionDao> setOfSection=new HashSet<>();
		for (Section sec : crs.getSections()) {
			//			setSection.add(SectionRepo.findById(sec.getId()));
			List<Object[]> fetchDetilsById = SectionRepo.fetchDetilsById(sec.getId());
			for (Object[] properties : fetchDetilsById) {
				setOfSection.add(SectionDao.builder().id(sec.getId()).name(properties[0].toString()).room(properties[1].toString()).build());
			}
		}

		Set<StudentDao> setOfStudent=new HashSet<>();
		for (Student std : crs.getStudents()) {
			setOfStudent.add(stdRepo.findById(std.getId()));
		}
		CourseDao course = CourseDao.builder()
				.name(crs.getName())
				.type(crs.getType())
				.code(crs.getCode())
				.year(crs.getYear())
				.department(dept)
				.sections(setOfSection)
				.students(setOfStudent)
				.build();

		CourseDao savedCourse = courseRepository.save(course);
		//		return Arrays.asList(CourseDao.builder()

		Set<Section> setSection2=new HashSet<>();
		setOfSection.forEach(obj->{
			Section sec=new Section();
			BeanUtils.copyProperties(obj, sec);
			setSection2.add(sec);
		});

		Set<Student> setStd=new HashSet<>();
		setOfStudent.forEach(std->{
			Student student = new Student();
			BeanUtils.copyProperties(std, student);
			setStd.add(student);
		});

		return Optional.of(Course.builder()
				.id(course.getId())
				.name(savedCourse.getName())
				.type(savedCourse.getType())
				.year(savedCourse.getYear())
				.code(savedCourse.getCode())
				.department(Department.builder()
						.id(dept.getId())
						.name(dept.getName())
						.head(dept.getHead())
						.cntactEmail(dept.getCntactEmail())
						.contactPhone(dept.getContactPhone())
						.build())
				.sections(setSection2)
				.students(setStd)
				.build());
	}

	public List<CourseDao> getAllCourses() {
		List<CourseDao> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}

	public void deleteCourse(int id) {
		courseRepository.deleteById(id);

	} 

	public CourseDao editCourse(int id) {
		return courseRepository.findById(id);
	}



	public CourseDao getCourse(int id) {

		return courseRepository.findById(id);
	}


	public List<CourseDao> getAllCoursesByYear(String year) {
		return courseRepository.findAllByYearIgnoreCase(year);
	}


	public void updateCourse(CourseDao course) {
		courseRepository.save(course);
	}

	public List<CourseDao> getCourseByYear(String year) {
		return courseRepository.findAllByYearIgnoreCase(year);
	}


}
