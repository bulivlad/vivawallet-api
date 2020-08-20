package io.dotinc.vivawallet.model.payment;

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
public class CancelPaymentResponse {

    /**
     * The order's unique code.
     */
    Integer orderCode;

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

}
