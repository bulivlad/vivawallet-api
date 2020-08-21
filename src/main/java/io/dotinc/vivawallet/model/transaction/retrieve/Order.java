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
public class Order {

    String channelId;

    /**
     * The order’s unique code.
     */
    String orderCode;

    /**
     * The ISO 3166-1 alpha-2-formatted request language.
     */
    String requestLang;

    /**
     * The unique ID of the reseller that created the order (if applicable).
     */
    String resellerId;

    /**
     * The code of the reseller's source that created the order (if applicable).
     */
    String resellerSourceCode;

    /**
     * The source from which the order was initiated.
     */
    String sourceCode;

    /**
     * List of tags used for internal tracking and report purposes.
     */
    List<String> tags;

}
