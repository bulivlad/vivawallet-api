package io.dotinc.vivawallet.command.impl;

import io.dotinc.vivawallet.MinimalistClient;
import io.dotinc.vivawallet.command.Transaction;
import io.dotinc.vivawallet.enums.TransactionAction;
import io.dotinc.vivawallet.exception.VivaWalletException;
import io.dotinc.vivawallet.model.transaction.cancel.CancelTransactionRequest;
import io.dotinc.vivawallet.model.transaction.cancel.CancelTransactionResponse;
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
public class CancelTransaction implements Transaction {

    CancelTransactionRequest cancelTransactionRequest;

    @Override
    public CancelTransactionResponse execute(String apiKeyBase64, TransactionAction transactionAction) throws IOException, VivaWalletException {
        String path = path("/api/transactions/%s?amount=%s", cancelTransactionRequest.getTransactionId(), cancelTransactionRequest.getAmount());
        if (cancelTransactionRequest.getSourceCode() != null && cancelTransactionRequest.getSourceCode() != "") {
            path = path("/api/transactions/%s?amount=%s&sourceCode=%s", cancelTransactionRequest.getTransactionId(), cancelTransactionRequest.getAmount(), cancelTransactionRequest.getSourceCode());
        }

        return MinimalistClient.call(CancelTransactionResponse.class, "DELETE", path, null, apiKeyBase64);
    }
}
