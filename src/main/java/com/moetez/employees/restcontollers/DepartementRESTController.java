package com.moetez.employees.restcontollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.moetez.employees.entities.Departement;
import com.moetez.employees.repos.DepartementRepository;
@RestController
@RequestMapping("/api/dep")
@CrossOrigin("*")
public class DepartementRESTController {
@Autowired
DepartementRepository departementRepository;
@RequestMapping(method=RequestMethod.GET)
public List<Departement> getAllDepartements()
{
return departementRepository.findAll();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Departement getDepartementById(@PathVariable("id") Long id) {
return departementRepository.findById(id).get();
}
} 


