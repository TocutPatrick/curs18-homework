package org.beta.curs18_homework.budgetApp;

import lombok.RequiredArgsConstructor;
import org.beta.curs18_homework.budgetApp.model.Transaction;
import org.beta.curs18_homework.budgetApp.model.Type;
import org.beta.curs18_homework.budgetApp.service.TransactionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CommandRunner implements CommandLineRunner {
    private final TransactionService transactionService;

    @Override
    public void run(String... args)  {
            transactionService.setTransactions(List.of(
                    Transaction.builder()
                            .id(UUID.randomUUID().toString())
                            .product("pan")
                            .type(Type.BUY)
                            .amount(4.6)
                            .build(),
                    Transaction.builder()
                            .id(UUID.randomUUID().toString())
                            .product("glass")
                            .type(Type.SELL)
                            .amount(2.3)
                            .build(),
                    Transaction.builder()
                            .id(UUID.randomUUID().toString())
                            .product("cup")
                            .type(Type.BUY)
                            .amount(1.6)
                            .build(),
                    Transaction.builder()
                            .id(UUID.randomUUID().toString())
                            .product("spoon")
                            .type(Type.SELL)
                            .amount(3.3)
                            .build()
            ));
    }
}
