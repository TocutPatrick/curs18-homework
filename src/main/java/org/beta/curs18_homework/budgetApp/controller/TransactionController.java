package org.beta.curs18_homework.budgetApp.controller;

import lombok.RequiredArgsConstructor;
import org.beta.curs18_homework.budgetApp.model.Transaction;
import org.beta.curs18_homework.budgetApp.model.Type;
import org.beta.curs18_homework.budgetApp.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions(){
        return transactionService.getTransactions();
    }

    @GetMapping("filter")
    public List<Transaction> getTrasactionsByFilter(@RequestParam(required = false) String product,
                                                    @RequestParam Type type,
                                                    @RequestParam Double minAmount,
                                                    @RequestParam Double maxAmount){
        return transactionService.getTransactionByFilter(product, type, minAmount, maxAmount);
    }

    @GetMapping("{id}")
    public Transaction getTransactionById(@PathVariable String id){
        return transactionService.getTransactionById(id);
    }

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction){
        return transactionService.addTransaction(transaction.withId(UUID.randomUUID().toString()));
    }

    @DeleteMapping("{id}")
    public Transaction deleteTransaction(@PathVariable String id){
        return transactionService.deleteCountry(id);
    }
}
