package org.beta.curs18_homework.budgetApp.controller;

import lombok.RequiredArgsConstructor;
import org.beta.curs18_homework.budgetApp.model.Transaction;
import org.beta.curs18_homework.budgetApp.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions(){
        return transactionService.getTransactions();
    }

    @GetMapping("{id}")
    public Transaction getTransactionById(@PathVariable String id){
        return transactionService.getTransactionById(id);
    }
}
