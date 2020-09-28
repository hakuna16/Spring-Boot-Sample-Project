package com.rituj.elasticsearch.conf;

import java.time.LocalDate;

public class CommonUtils {

    public static String getIndexName() {
        return "products" + LocalDate.now();
    }
}
