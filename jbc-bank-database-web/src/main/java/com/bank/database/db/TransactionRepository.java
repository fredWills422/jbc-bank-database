package com.bank.database.db;

import org.springframework.data.repository.CrudRepository;

import com.bank.database.business.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}
