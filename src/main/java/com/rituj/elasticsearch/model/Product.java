package com.rituj.elasticsearch.model;

import com.rituj.elasticsearch.commons.Constants;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Data
@Document(indexName = "products_#{elasticIndex.getIndexDate()}")
public class Product {
    
    @Id
    private String id;
    private String product;
    private String productDescription;
    private String store;
    private String displayGroup;
    private String effectiveDate;
    private String rangeStartDate;
    private String rangeEndDate;
    private String rangeStartResonCode;
    private String rangeStartResonCodeDescription;
    private String rangeEndResonCode;
    private String rangeEndResonCodeDescription;
    private String stockStartDate;
    private String stockEndDate;
}
