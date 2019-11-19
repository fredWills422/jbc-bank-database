package com.bank.database.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.database.business.Transaction;
import com.bank.database.db.TransactionRepository;

@CrossOrigin
@RestController
@RequestMapping("/transactions")
public class TransactionController {

	@Autowired
	private TransactionRepository transactionRepo;
	
	private JsonResponse save(Transaction transaction) {
		try {
			return JsonResponse.getInstance(transactionRepo.save(transaction));
		}catch(IllegalArgumentException ex) {
			return JsonResponse.getInstance("Parameter transaction cannot be null");
		}catch(Exception ex){
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	
	@GetMapping("/")
	public Iterable<Transaction> getAll(){
		return transactionRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody JsonResponse getByPK(@PathVariable Integer id){
		try {
			if(id ==null) return JsonResponse.getInstance("Parameter id cannot be null");
			Optional<Transaction> t = transactionRepo.findById(id);
			if(!t.isPresent()) {
				return JsonResponse.getInstance("Transaction not found");
			}return JsonResponse.getInstance(t.get());
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	
	@PostMapping
	public @ResponseBody JsonResponse insert(@RequestBody Transaction transaction) {
		try {
			return save(transaction);
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex);
		}
	}
	
	@PutMapping("/{id}")
	public @ResponseBody JsonResponse update(@RequestBody Transaction transaction, @PathVariable Integer id) {
		try {
			if(id != transaction.getId()) {
				return JsonResponse.getInstance("Parameter id doesn't match");
			}
			return save(transaction);
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex);
		}
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody JsonResponse delete(@PathVariable Integer id) {
		try {
			if(id==null) return JsonResponse.getInstance("Parameter id can't be null");
			Optional<Transaction> t = transactionRepo.findById(id);
			if(!t.isPresent()) {
				return JsonResponse.getInstance("Transaction not found");
			}
			transactionRepo.deleteById(t.get().getId());
			return JsonResponse.getInstance(t.get());
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	
}
