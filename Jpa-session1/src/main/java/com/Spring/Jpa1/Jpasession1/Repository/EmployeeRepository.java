package com.Spring.Jpa1.Jpasession1.Repository;

import com.Spring.Jpa1.Jpasession1.Entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;


//public interface EmployeeRepository extends CrudRepository<Employee,Integer>
public interface EmployeeRepository extends CrudRepository<Employee,Integer>, PagingAndSortingRepository<Employee,Integer>
{
    Page<Employee> findAll(Pageable pageable);
    @Override
    Optional<Employee> findById(Integer id);

    List<Employee> findByName(String Name);

    List<Employee> findByNameLike(String Name);

    List<Employee> findByAgeBetween(Integer Age1, Integer Age2);



}
