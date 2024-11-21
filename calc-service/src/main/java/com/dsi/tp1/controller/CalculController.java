package com.dsi.tp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dsi.tp1.entity.Operation;
import com.dsi.tp1.service.OperationService;

@RestController
public class CalculController {
	
    @Autowired
    private OperationService operationService;

	@Autowired
	private Environment environment;
	
    @GetMapping("/operations")
    public ResponseEntity<List<Operation>> getAllOperations() {
        List<Operation> operations = operationService.getAll();
        if (!operations.isEmpty()) {
            return ResponseEntity.ok(operations);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestParam int op1, @RequestParam int op2) {
        operationService.add(op1, op2);
        return ResponseEntity.status(HttpStatus.CREATED).body("Operation added successfully.");
    }
    
    @PostMapping("/sub")
    public ResponseEntity<String> subtract(@RequestParam int op1, @RequestParam int op2) {
        operationService.subtract(op1, op2);
        return ResponseEntity.status(HttpStatus.OK).body("Operation substracted successfully.");
    }
    
    @PostMapping("/mul")
    public ResponseEntity<String> multiply(@RequestParam int op1, @RequestParam int op2) {
        operationService.multiply(op1, op2);
        return ResponseEntity.status(HttpStatus.OK).body("Operation multiplied successfully.");
    }
    
    @PostMapping("/div")
    public ResponseEntity<String> divide(@RequestParam int op1, @RequestParam int op2) {
        operationService.divide(op1, op2);
        return ResponseEntity.status(HttpStatus.OK).body("Operation divided successfully.");
    }

	@GetMapping("/test")
	public String test() {
	    return "test with port :" + environment.getProperty("server.port");
	}
}
