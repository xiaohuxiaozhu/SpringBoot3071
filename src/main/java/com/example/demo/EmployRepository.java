package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface EmployRepository extends CrudRepository <Employee,Long> {
}
