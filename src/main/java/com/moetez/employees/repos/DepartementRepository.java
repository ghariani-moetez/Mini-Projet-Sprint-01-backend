package com.moetez.employees.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.moetez.employees.entities.Departement;
@RepositoryRestResource(path = "dep")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular
public interface DepartementRepository extends JpaRepository<Departement, Long> {

}
