package com.bank.database.db;

import org.springframework.data.repository.CrudRepository;

import com.bank.database.business.Account;

public interface AccountRepository extends CrudRepository<Account, Integer>{

}
