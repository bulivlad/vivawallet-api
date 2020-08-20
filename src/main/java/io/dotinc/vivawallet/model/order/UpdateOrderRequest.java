package io.dotinc.vivawallet.model.order;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author vbulimac on 20/08/2020.
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateOrderRequest {

    /**
     * The new amount of the order (in the currency's smallest unit of measurement.)
     */
    Integer amount;

    /**
     * Allows the order to accept multiple payments (true) or not (false).
     */
    Boolean disablePaidState;

    /**
     * The expiration date of the order.
     */
    String expirationDate;

    /**
     * Changes the cancelled status of the order.
     */
    Boolean isCanceled;

}
