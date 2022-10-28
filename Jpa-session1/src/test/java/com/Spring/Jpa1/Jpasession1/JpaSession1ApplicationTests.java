package com.Spring.Jpa1.Jpasession1;

import com.Spring.Jpa1.Jpasession1.Entity.Employee;
import com.Spring.Jpa1.Jpasession1.Repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class JpaSession1ApplicationTests
{

	@Autowired
	EmployeeRepository repository;
	@Test
	public void contextLoads()
	{
	}


	@Test
	public void testCreate()
	{
		Employee employee = new Employee();
		employee.setName("Nafees");
		employee.setAge(23);
		employee.setId(1);
		employee.setLocation("Delhi");

		repository.save(employee);
	}

	@Test
	public void testRead()
	{
		Employee employee = repository.findById(1).get();
		assertNotNull(employee);
		assertEquals("Nafees",employee.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>>"+employee.getAge());
	}

	@Test
	public void testUpdate()
	{
		Employee employee = repository.findById(1).get();
		employee.setAge(20);
		repository.save(employee);
	}

	@Test
	public void testDelete()
	{
		if(repository.existsById(2))
		{
			repository.deleteById(2);
		}
	}

	@Test
	public void testCount()
	{
		long row = repository.count();
		System.out.println(row);
	}

	@Test
	public void testFindByName()
	{
		List<Employee> employees = repository.findByName("Shazad");
		employees.forEach(p-> System.out.println(p.getAge()));
	}

	@Test
	public void testFindByNameLike()
	{
		List<Employee> employees = repository.findByNameLike("A%");
		employees.forEach(p-> System.out.println(p.getName()));
	}

	@Test
	public void testFindByAgeBetween()
	{
		List<Employee> employees = repository.findByAgeBetween(20,22);
		employees.forEach(p-> System.out.println(p.getName()));
	}

	@Test
	public void testFindAll()
	{
		Pageable pageable = PageRequest.of(0,4, Sort.by("age"));
		repository.findAll(pageable).forEach(p-> System.out.println(p.getName() + " " + p.getAge()));

	}
}
