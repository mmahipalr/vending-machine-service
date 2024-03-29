package com.learning.vending.client.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.vending.client.exception.VendingMachineUserDataException;
import com.learning.vending.client.form.UserTransactionForm;
import com.learning.vending.client.model.Bucket;
import com.learning.vending.client.model.Coin;
import com.learning.vending.client.model.Product;
import com.learning.vending.client.service.CustomerService;

@RestController
@RequestMapping("/vendingmachine/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return customerService.getProducts();
	}
	
	@PostMapping("/dispatch")
	public Bucket<Product,List<Coin>> dispatch(@RequestBody UserTransactionForm userTransactionForm){
		if(userTransactionForm.getQuantity() <= 0) {
			throw new VendingMachineUserDataException("Invalid product quantity");
		}
		
		if(!StringUtils.hasLength(userTransactionForm.getProductId())) {
			throw new VendingMachineUserDataException("Product is not selected");
		}
		
		if(userTransactionForm.getCoin() == null) {
			throw new VendingMachineUserDataException("Invalid amount");
		}
		
		return customerService.dispatch(userTransactionForm);
	}
	
	
}	
	

