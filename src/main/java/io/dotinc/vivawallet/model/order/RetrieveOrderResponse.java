package io.dotinc.vivawallet.model.order;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * @author vbulimac on 20/08/2020.
 */

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RetrieveOrderResponse {

    /**
     * A user-friendly description for the order.
     */
    String customerTrns;

    /**
     * The exact date and time at which the order expires.
     */
    String expirationDate;

    /**
     * The merchant's reference code for the specific order.
     */
    String merchantTrns;

    /**
     * The unique 12-digit code of the order.
     */
    Integer orderCode;

    /**
     * The net payment amount of the order (without fees).
     */
    Float requestAmount;

    /**
     * The ISO 3166-1 alpha-2-formatted request language.
     */
    String requestLang;

    /**
     * The code of the source related to this order.
     */
    String sourceCode;

    /**
     * Enum: "0 (Pending)" "1 (Expired)" "2 (Canceled)" "3 (Paid)"
     * The status of the order.
     */
    String stateId;

    /**
     * An array containing all related tags.
     */
    List<String> tags;


}
