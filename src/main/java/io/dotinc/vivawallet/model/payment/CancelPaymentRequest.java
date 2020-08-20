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
public class CancelPaymentRequest {

    /**
     * The 16-digit orderCode for which you requested information.
     */
    String orderCode;
}
