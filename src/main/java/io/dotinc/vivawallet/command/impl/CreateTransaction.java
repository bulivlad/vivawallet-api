package io.dotinc.vivawallet.command.impl;

import io.dotinc.vivawallet.MinimalistClient;
import io.dotinc.vivawallet.command.Transaction;
import io.dotinc.vivawallet.enums.TransactionAction;
import io.dotinc.vivawallet.exception.VivaWalletException;
import io.dotinc.vivawallet.model.transaction.create.CreateTransactionRequest;
import io.dotinc.vivawallet.model.transaction.create.CreateTransactionResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.io.IOException;

/**
 * @author vbulimac on 21/08/2020.
 */

@ToString
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateTransaction implements Transaction {

    CreateTransactionRequest createTransactionRequest;

    @Override
    public CreateTransactionResponse execute(String apiKeyBase64, TransactionAction transactionAction) throws IOException, VivaWalletException {
        return MinimalistClient.call(CreateTransactionResponse.class, "POST", path("/api/transactions/%s", createTransactionRequest.getTransactionId()), createTransactionRequest, apiKeyBase64);
    }
}
