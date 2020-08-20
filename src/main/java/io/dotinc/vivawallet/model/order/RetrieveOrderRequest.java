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
public class RetrieveOrderRequest {

    /**
     * The 16-digit orderCode for which you wish to retrieve information.
     */
    Integer orderCode;

}
