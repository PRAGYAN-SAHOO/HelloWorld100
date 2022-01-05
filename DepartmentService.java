package com.cms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.DepartmentDao;
import com.cms.model.Department;
import com.cms.repository.DepartmentRepository;

@Service
@Transactional
public class DepartmentService {


	@Autowired
	private DepartmentRepository deptRepository;

	public Optional<Department> addDept(Department dept) {
		DepartmentDao deptDao = DepartmentDao.builder()
				.id(dept.getId())
				.name(dept.getName())
				.head(dept.getHead())
				.contactPhone(dept.getContactPhone())
				.cntactEmail(dept.getCntactEmail()).build();

		DepartmentDao savedDept = deptRepository.save(deptDao);

		BeanUtils.copyProperties(savedDept, dept );
		return Optional.of(Department.builder()
				.id(dept.getId())
				.name(savedDept.getName())
				.head(savedDept.getHead())
				.contactPhone(savedDept.getContactPhone())
				.cntactEmail(savedDept.getCntactEmail())
				.build());
	}

	//	public List<Department> getAllDepts() {
	public Optional<List<Department>> getAllDepts() {
		List<Department> depts= new ArrayList<>();
		deptRepository.findAll().forEach((dept)->{
			depts.add(Department.builder()
					.id(dept.getId())
					.name(dept.getName())
					.head(dept.getHead())
					.contactPhone(dept.getContactPhone())
					.cntactEmail(dept.getCntactEmail())
					.build());
		});
		return Optional.of(depts);
	}


	public Department getDept(int id) {
		DepartmentDao dept = deptRepository.findById(id);
		return Department.builder()
				.id(dept.getId())
				.name(dept.getName())
				.head(dept.getHead())
				.contactPhone(dept.getContactPhone())
				.cntactEmail(dept.getCntactEmail())
				.build();
	}

}
