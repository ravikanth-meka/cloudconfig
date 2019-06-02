package com.example.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

	public List<Department> findAll() ;

	public Department findByDeptNo(int deptNo);
}
