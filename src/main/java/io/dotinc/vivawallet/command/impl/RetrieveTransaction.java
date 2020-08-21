package io.dotinc.vivawallet.command.impl;

import io.dotinc.vivawallet.MinimalistClient;
import io.dotinc.vivawallet.command.Transaction;
import io.dotinc.vivawallet.enums.TransactionAction;
import io.dotinc.vivawallet.exception.VivaWalletException;
import io.dotinc.vivawallet.model.transaction.retrieve.RetrieveTransactionRequest;
import io.dotinc.vivawallet.model.transaction.retrieve.RetrieveTransactionResponse;
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
public class RetrieveTransaction implements Transaction {

    RetrieveTransactionRequest retrieveTransactionRequest;

    @Override
    public RetrieveTransactionResponse execute(String apiKeyBase64, TransactionAction transactionAction) throws IOException, VivaWalletException {
        switch (transactionAction) {
            case RETRIEVE_SINGLE:
                return retrieveSingle(apiKeyBase64);
            case RETRIEVE_FOR_DATE:
                return retrieveForDate(apiKeyBase64);
            case RETRIEVE_FOR_ORDER:
                return retrieveForOrder(apiKeyBase64);
            case RETRIEVE_FOR_CLEARANCE_DATE:
                return retrieveForClearanceDate(apiKeyBase64);
            case RETRIEVE_FOR_SOURCE_CODE_AND_DATA:
                return retrieveForSourceCodeAndDate(apiKeyBase64);
        }

        return null;
    }

    private RetrieveTransactionResponse retrieveSingle(String apiKeyBase64) throws IOException, VivaWalletException {
        String path = path("/api/transactions/%s", retrieveTransactionRequest.getTransactionId());
        return MinimalistClient.call(RetrieveTransactionResponse.class, "GET", path, null, apiKeyBase64);
    }

    private RetrieveTransactionResponse retrieveForDate(String apiKeyBase64) throws IOException, VivaWalletException {
        String path = path("/api/transactions/?date=%s", retrieveTransactionRequest.getDate());
        return MinimalistClient.call(RetrieveTransactionResponse.class, "GET", path, null, apiKeyBase64);
    }

    private RetrieveTransactionResponse retrieveForOrder(String apiKeyBase64) throws IOException, VivaWalletException {
        String path = path("/api/transactions/?ordercode=%s", retrieveTransactionRequest.getOrderCode());
        return MinimalistClient.call(RetrieveTransactionResponse.class, "GET", path, null, apiKeyBase64);
    }

    private RetrieveTransactionResponse retrieveForClearanceDate(String apiKeyBase64) throws IOException, VivaWalletException {
        String path = path("/api/transactions/?clearancedate=%s", retrieveTransactionRequest.getClearanceDate());
        return MinimalistClient.call(RetrieveTransactionResponse.class, "GET", path, null, apiKeyBase64);
    }

    private RetrieveTransactionResponse retrieveForSourceCodeAndDate(String apiKeyBase64) throws IOException, VivaWalletException {
        String path = path("/api/transactions/?sourcecode=%s&date=%s", retrieveTransactionRequest.getSourcecode(), retrieveTransactionRequest.getDate());
        return MinimalistClient.call(RetrieveTransactionResponse.class, "GET", path, null, apiKeyBase64);
    }

}
