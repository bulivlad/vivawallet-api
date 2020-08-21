package io.dotinc.vivawallet.model.transaction.retrieve;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * @author vbulimac on 21/08/2020.
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RetrieveTransactionResponse {

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
     * The details of the specific transaction.
     */
    List<TransactionResponse> transactions;

}
