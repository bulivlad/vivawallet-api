package io.dotinc.vivawallet.model.transaction.retrieve;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author vbulimac on 21/08/2020.
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionResponse {

    /**
     * The net amount of the transaction (without fees).
     */
    Float amount;

    /**
     * The date that the transaction was cleared.
     */
    String clearanceDate;

    /**
     * The commission for the specific transaction.
     */
    Float commission;

    /**
     * The username that initiated the transaction.
     */
    String createdBy;

    /**
     * The details of the card used for the transaction.
     */
    CreditCard creditCard;

    /**
     * A friendly description that is displayed to the cardholder. This description appears on the receipt the cardholder receives.
     */
    String customerTrns;

    /**
     * The fees that correspond to the specific transaction.
     */
    Float fee;

    /**
     * The date that the transaction was executed.
     */
    String insDate;

    /**
     * The merchant's unique ID.
     */
    String merchantId;

    /**
     * An ID or a short description that helps you uniquely identify the transaction. For example, this can be your customer order reference number.
     */
    String merchantTrns;

    /**
     * The details of the order that created the transaction.
     */
    Order order;

    /**
     * In case the transaction is considered to be consequent of another (e.g. in case of an installment or a refund), this is the unique ID of the originating transaction.
     */
    String parentId;

    /**
     * The details of the payment of the transaction.
     */
    Payment payment;

    /**
     * The reseller's unique ID (if one exists).
     */
    String resellerId;

    /**
     * The reseller's source (if it exists).
     */
    String resellerSourceCode;

    /**
     * The source that was declared for the specific transaction.
     */
    String sourceCode;

    /**
     * Enum:
     * "E (The transaction was not completed because of an error)"
     * "A (The transaction is in progress)"
     * "M (The cardholder has disputed the transaction with the issuing Bank)"
     * "U (A disputed transaction has been refunded)"
     * "X (The transaction was cancelled by the merchant)"
     * "R (The transaction has been fully or partially refunded)"
     * "F (The transaction has been successfully completed)"
     *
     * The transaction’s current status.
     */
    String statusId;

    /**
     * The transaction’s unique ID.
     */
    String transactionId;
}
