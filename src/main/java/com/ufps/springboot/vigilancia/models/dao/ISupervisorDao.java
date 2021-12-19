package com.ufps.springboot.vigilancia.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ufps.springboot.vigilancia.models.entities.Supervisor;




public interface ISupervisorDao extends CrudRepository<Supervisor, String>{



}
