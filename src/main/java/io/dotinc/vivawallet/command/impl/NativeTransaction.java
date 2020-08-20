package io.dotinc.vivawallet.command.impl;

import io.dotinc.vivawallet.MinimalistClient;
import io.dotinc.vivawallet.command.Native;
import io.dotinc.vivawallet.exception.VivaWalletException;
import io.dotinc.vivawallet.model.checkout.NativeTransactionRequest;
import io.dotinc.vivawallet.model.checkout.NativeTransactionResponse;
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
public class NativeTransaction implements Native {

    NativeTransactionRequest nativeTransactionRequest;

    @Override
    public NativeTransactionResponse execute(String key) throws IOException, VivaWalletException {
        return MinimalistClient.call(NativeTransactionResponse.class, "POST", path("/nativecheckout/v2/transactions"), nativeTransactionRequest, key);
    }
}
