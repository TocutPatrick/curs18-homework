package org.beta.curs18_homework.budgetApp.model;

import lombok.Builder;
import lombok.With;

@With
@Builder
public record Transaction(
        String id,
        String product,
        Type type,
        Double amount
) {
}
