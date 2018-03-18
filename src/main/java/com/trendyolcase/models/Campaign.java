package com.trendyolcase.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "campaigns")
public class Campaign {

    @Id
    private String id;

    @NotNull(message = "Campaign Name is compulsory")
    private String name;
    @NotNull(message = "Campaign Type is compulsory")
    private String type;
    @NotNull(message = "Campaign Type ID is compulsory")
    private String typeId;
    @NotNull(message = "Campaign Type Name is compulsory")
    private String typeName;
    @NotNull(message = "Campaign Discount Type is compulsory")
    private String discountType;
    @NotNull(message = "Campaign Discount is compulsory")
    private long discount;
    private long maxDiscount;

    public Campaign() {
    }

    public Campaign(
            String name,
            String type,
            String typeId,
            String typeName,
            String discountType,
            long discount,
            long maxDiscount
    ) {
        this.name = name;
        this.type = type;
        this.typeId = typeId;
        this.typeName = typeName;
        this.discountType = discountType;
        this.discount = discount;
        this.maxDiscount = maxDiscount;
    }

    // *** GETTERS ***
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getDiscountType() {
        return discountType;
    }

    public long getDiscount() {
        return discount;
    }

    public long getMaxDiscount() {
        return maxDiscount;
    }

    //*** SETTERS ***
    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    public void setMaxDiscount(long maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    @Override
    public String toString() {
        return String.format(
                "Campaign[id=%s, name='%s', typeId='%s', typeName='%s, discountType='%s, discount='%s, maxDiscount='%s]",
                id, name, typeId, typeName, discountType, discount, maxDiscount);
    }

}
