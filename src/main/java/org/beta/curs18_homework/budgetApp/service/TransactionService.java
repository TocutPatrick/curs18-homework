package org.beta.curs18_homework.budgetApp.service;

import org.beta.curs18_homework.budgetApp.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {
    List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions.addAll(transactions);
    }

    public Transaction getTransactionById(String id) {
        return transactions.stream()
                .filter(transaction -> transaction.id().equalsIgnoreCase(transaction.id()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Country not found"));
    }
}
