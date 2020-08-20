package io.dotinc.vivawallet.command.impl;

import io.dotinc.vivawallet.MinimalistClient;
import io.dotinc.vivawallet.command.Payment;
import io.dotinc.vivawallet.exception.VivaWalletException;
import io.dotinc.vivawallet.model.payment.CreatePaymentRequest;
import io.dotinc.vivawallet.model.payment.CreatePaymentResponse;
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
public class CreatePayment implements Payment {

    CreatePaymentRequest createPaymentRequest;

    public CreatePaymentResponse execute(String key) throws IOException, VivaWalletException {
        return MinimalistClient.call(CreatePaymentResponse.class, "POST", path("/api/orders"), createPaymentRequest, key);
    }
}
