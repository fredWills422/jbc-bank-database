package com.bank.database.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bank.database.business.Account;
import com.bank.database.db.AccountRepository;

@CrossOrigin
@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepo;
	
	@GetMapping("/")
	public Iterable<Account> getAll(){
		return accountRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Account> getByPk(@PathVariable Integer id) {
		return accountRepo.findById(id);
	}

	@PostMapping
	public JsonResponse insertAccount(@RequestBody Account a) {
		JsonResponse jr =null;
		try {
			jr  = JsonResponse.getInstance(accountRepo.save(a));
		}catch(Exception e) {
			e.printStackTrace();
			jr = JsonResponse.getInstance(e);
		}return jr;
	}
	
}
