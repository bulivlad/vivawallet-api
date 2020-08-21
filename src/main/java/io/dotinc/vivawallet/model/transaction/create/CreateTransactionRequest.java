package io.dotinc.vivawallet.model.transaction.create;

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
public class CreateTransactionRequest {

    /**
     * The transaction's unique ID. This is the ID of the original payment. You should use the same ID for every subsequent recurring transaction.
     */
    String transactionId;

    /**
     * The user who completed the details of the registration (useful for reporting/audit reasons).
     */
    String actionUser;

    /**
     * The amount requested in the currency's smallest unit of measurement. For capturing authorized transactions,
     * this amount should not exceed the amount entered in the original PreAuth.
     *
     * For example. if you want to create a payment for €100.37, you need to pass the value 10037.
     */
    Integer amount;

    /**
     * A friendly description that you want to display to the cardholder. This description appears on the receipt the cardholder receives.
     */
    String customerTrns;

    /**
     * This optional parameter defines the number of installments for the payment. [1..36]
     * Greece only.
     */
    Integer installments;

    /**
     * An ID or a short description that helps you uniquely identify the transaction. For example, this can be your customer order reference number.
     */
    String merchantTrns;
}
