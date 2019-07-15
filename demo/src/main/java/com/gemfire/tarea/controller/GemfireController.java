package com.gemfire.tarea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gemfire.tarea.model.Session;
import com.gemfire.tarea.repository.SessionRepository;


@RestController
public class GemfireController {

	@Autowired
	private SessionRepository dao;

	@PostMapping("/session")
	public Session addSession(@RequestBody Session session) throws Exception {
		return dao.save(session);
	}
}
