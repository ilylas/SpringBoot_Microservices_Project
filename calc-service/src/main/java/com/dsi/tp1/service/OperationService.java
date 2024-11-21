package com.dsi.tp1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.tp1.entity.Operation;
import com.dsi.tp1.repository.OperationRepository;

@Service
public class OperationService {
	
	@Autowired
	private OperationRepository operationRepository;
	
	public List<Operation> getAll() {
		// TODO Auto-generated method stub
		return operationRepository.findAll() ;
	}
	
	public int add(int op1, int op2) {
	    int result = op1 + op2;
	    saveOperation("addition", op1, op2, result);
	    return result;
	}

	public int subtract(int op1, int op2) {
	    int result = op1 - op2;
	    saveOperation("subtraction", op1, op2, result);
	    return result;
	}

	public int multiply(int op1, int op2) {
	    int result = op1 * op2;
	    saveOperation("multiplication", op1, op2, result);
	    return result;
	}

	public double divide(int op1, int op2) {
	    if (op2 == 0) {
	        throw new IllegalArgumentException("Division by zero is not allowed.");
	    }
	    double result = (double) op1 / op2;
	    saveOperation("division", op1, op2, (int) result);
	    return result;
	}

    private void saveOperation(String type, int op1, int op2, int result) {
        Operation operation = new Operation();
        operation.setType(type);
        operation.setOperande1(op1);
        operation.setOperande2(op2);
        operation.setResultat(result);
        // Set date if needed
        operationRepository.save(operation);
    }
	
	
    
	


	
	
	
	
	
	
	
}
