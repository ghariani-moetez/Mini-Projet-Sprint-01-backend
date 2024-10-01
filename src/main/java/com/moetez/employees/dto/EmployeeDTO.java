package com.moetez.employees.dto;

import java.util.Date;

import com.moetez.employees.entities.Departement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EmployeeDTO {
	private Long idEmployee;
	private String nomEmployee;
	private Double salaire;
	private Date dateEmbauche;
	private Departement departement;
	private String nomDep;
}
