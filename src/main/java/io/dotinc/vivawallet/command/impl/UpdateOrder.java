package io.dotinc.vivawallet.command.impl;

import io.dotinc.vivawallet.MinimalistClient;
import io.dotinc.vivawallet.command.Order;
import io.dotinc.vivawallet.exception.VivaWalletException;
import io.dotinc.vivawallet.model.order.UpdateOrderRequest;
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
public class UpdateOrder implements Order {

    UpdateOrderRequest updateOrderRequest;

    public Void execute(String key) throws IOException, VivaWalletException {
        return MinimalistClient.call(Void.class, "PATCH", path("/api/orders/%s", updateOrderRequest.getOrderCode()), updateOrderRequest, key);
    }
}
