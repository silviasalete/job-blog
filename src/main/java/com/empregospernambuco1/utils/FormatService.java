package com.empregospernambuco1.utils;

import java.math.BigDecimal;

public class FormatService {

    public BigDecimal stringToBigDecimail(String parameter) {
        return new BigDecimal (parameter.replace(".","").replace(",","."));
    }
}
