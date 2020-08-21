package io.dotinc.vivawallet.enums;

/**
 * @author vbulimac on 21/08/2020.
 */
public enum ResponseStatus {

    ERROR("E"),
    IN_PROGRESS("A"),
    DISPUTE("M"),
    DISPUTE_REFUNDED("U"),
    CANCELLED("X"),
    REFUNDED("R"),
    SUCCESS("F");

    private String code;

    ResponseStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
