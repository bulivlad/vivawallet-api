package io.dotinc.vivawallet.command.impl;

import io.dotinc.vivawallet.MinimalistClient;
import io.dotinc.vivawallet.command.Payment;
import io.dotinc.vivawallet.exception.VivaWalletException;
import io.dotinc.vivawallet.model.payment.CancelPaymentRequest;
import io.dotinc.vivawallet.model.payment.CancelPaymentResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.io.IOException;

/**
 * @author vbulimac on 20/08/2020.
 */

@ToString
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CancelPayment implements Payment {

    CancelPaymentRequest cancelPaymentRequest;

    public CancelPaymentResponse execute(String key) throws IOException, VivaWalletException {
        return MinimalistClient.call(CancelPaymentResponse.class, "DELETE", path("/api/orders/%s"), cancelPaymentRequest, key);
    }
}
