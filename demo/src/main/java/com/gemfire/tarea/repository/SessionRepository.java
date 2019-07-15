package com.gemfire.tarea.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gemfire.tarea.model.Session;

@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface SessionRepository extends CrudRepository<Session, Long>{

	Session findByCustomerName(@Param("firstname") String firstname);
}
