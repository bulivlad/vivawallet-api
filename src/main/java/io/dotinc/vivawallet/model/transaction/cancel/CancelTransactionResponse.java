package io.dotinc.vivawallet.model.transaction.cancel;

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
public class CancelTransactionResponse {

    /**
     * The server date and time (in ISO 8601 format) that the Order was cancelled.
     */
    String timeStamp;

    /**
     * If the call is unsuccessful, an error code is generated. For successful calls, "0" is returned.
     */
    Integer errorCode;

    /**
     * If the ErrorCode is other than "0", a descriptive error message is returned.
     */
    String errorText;

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
     * The transaction's unique ID.
     */
    String transactionId;

}
