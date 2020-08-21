package io.dotinc.vivawallet.model.transaction.cancel;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author vbulimac on 21/08/2020.
 */

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CancelTransactionRequest {

    /**
     * The transaction's unique ID. This is the ID of the original payment. You should use the same ID for every
     * subsequent recurring transaction.
     */
    String transactionId;

    /**
     * The amount that will be refunded in the currency's smallest denomination (e.g amount in pounds x 100).
     * It should not exceed the amount of the original payment.
     * For example, if you want to refund a payment of £100.37, you need to pass the value "10037".
     */
    Integer amount;

    /**
     * The source from which the funds will be withdrawn. Each source is linked to a wallet. If no sourceCode is set
     * then the funds will be withdrawn from the primary wallet.
     */
    String sourceCode;

}
