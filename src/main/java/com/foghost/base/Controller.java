package com.foghost.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(annotations = RestController.class)
public class Controller {

	@InitBinder
	protected void init() {

	}

	@ExceptionHandler
	protected ObjectNode expectionHandler(Exception e) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		node.put("status", 500);
		node.put("info", e.getMessage());
		return node;
	}
//	@ModelAttribute
//	protected Object modelAttribute() {
//
//	}

}
