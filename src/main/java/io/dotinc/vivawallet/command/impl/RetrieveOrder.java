package io.dotinc.vivawallet.command.impl;

import io.dotinc.vivawallet.MinimalistClient;
import io.dotinc.vivawallet.command.Order;
import io.dotinc.vivawallet.exception.VivaWalletException;
import io.dotinc.vivawallet.model.order.RetrieveOrderRequest;
import io.dotinc.vivawallet.model.order.RetrieveOrderResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.IOException;

/**
 * @author vbulimac on 20/08/2020.
 */

@ToString
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RetrieveOrder implements Order {

    RetrieveOrderRequest retrieveOrderRequest;

    public RetrieveOrderResponse execute(String key) throws IOException, VivaWalletException {
        return MinimalistClient.call(RetrieveOrderResponse.class, "GET", path("/api/orders/%s"), retrieveOrderRequest, key);
    }
}
