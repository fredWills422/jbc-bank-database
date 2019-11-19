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
	
	private JsonResponse save(Account account) {
		try {
			return JsonResponse.getInstance(accountRepo.save(account));
		}catch(IllegalArgumentException ex) {
			return JsonResponse.getInstance("Parameter account cannot be null");
		}catch(Exception ex){
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	
	@GetMapping("/")
	public Iterable<Account> getAll(){
		return accountRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody JsonResponse getByPK(@PathVariable Integer id){
		try {
			if(id ==null) return JsonResponse.getInstance("Parameter id cannot be null");
			Optional<Account> a = accountRepo.findById(id);
			if(!a.isPresent()) {
				return JsonResponse.getInstance("Account not found");
			}return JsonResponse.getInstance(a.get());
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	
	@PostMapping
	public @ResponseBody JsonResponse insert(@RequestBody Account account) {
		try {
			return save(account);
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex);
		}
	}
	
	@PutMapping("/{id}")
	public @ResponseBody JsonResponse update(@RequestBody Account account, @PathVariable Integer id) {
		try {
			if(id != account.getId()) {
				return JsonResponse.getInstance("Parameter id doesn't match");
			}
			return save(account);
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex);
		}
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody JsonResponse delete(@PathVariable Integer id) {
		try {
			if(id==null) return JsonResponse.getInstance("Parameter id can't be null");
			Optional<Account> a = accountRepo.findById(id);
			if(!a.isPresent()) {
				return JsonResponse.getInstance("Account not found");
			}
			accountRepo.deleteById(a.get().getId());
			return JsonResponse.getInstance(a.get());
		}catch(Exception ex) {
			return JsonResponse.getInstance(ex.getMessage());
		}
	}
	
}
