package org.beta.curs18_homework.budgetApp.service;

import org.beta.curs18_homework.budgetApp.model.Transaction;
import org.beta.curs18_homework.budgetApp.model.Type;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions.addAll(transactions);
    }

    public Transaction addTransaction(Transaction transaction) {
        transactions.add(transaction);
        return transaction;
    }

    public List<Transaction> getAllByProduct(String product) {
        return transactions.stream()
                .filter(transaction -> transaction.product().equalsIgnoreCase(product))
                .toList();
    }


    public List<Transaction> getAllByType(Type type) {
        return transactions.stream()
                .filter(transaction -> transaction.type().equals(type))
                .toList();
    }

    public Transaction getTransactionById(String id) {
        return transactions.stream()
                .filter(transaction -> transaction.id().equalsIgnoreCase(transaction.id()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Country not found"));
    }


    public Transaction deleteCountry(String id) {
        Transaction transactionToBeDeleted = transactions.stream()
                .filter(transaction -> id.equals(transaction.id()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        transactions.remove(transactionToBeDeleted);
        return transactionToBeDeleted;
    }

    public List<Transaction> getTransactionByFilter(String product, Type type, Double minAmount, Double maxAmount) {
        if (product == null || type == null || minAmount == null || maxAmount == null){
            return List.of();
        }
            return transactions.stream()
                    .filter(transaction -> transaction.product().equalsIgnoreCase(product))
                    .filter(transaction -> transaction.type().equals(type))
                    .filter(transaction -> transaction.amount() > minAmount && transaction.amount() < maxAmount)
                    .toList();
    }
}
