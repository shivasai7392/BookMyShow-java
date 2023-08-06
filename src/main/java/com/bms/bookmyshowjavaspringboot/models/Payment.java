package com.bms.bookmyshowjavaspringboot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseModel{
    private int amount;
    private PaymentType paymentType;
    private PaymentStatus paymentStatus;
    private String referenceId;
    private PaymentProvider paymentProvider;
}
