package com.trendyolcase.services;

import com.trendyolcase.models.Campaign;
import com.trendyolcase.models.CartItem;
import com.trendyolcase.utils.exceptions.CampaignNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service("discountService")
public class DiscountService {
    @Autowired
    private CampaignService campaignService;

    private CartItem applyDiscount(CartItem cartItem) {

        Long price = cartItem.getPrice();
        String productId = cartItem.getProductId();
        String categoryId = cartItem.getCategoryId();

        List<Campaign> campaigns = campaignService.findCampaigns(Arrays.asList(productId, categoryId));

        campaigns.forEach((campaign) -> {
            switch (campaign.getDiscountType()) {
                case "ORAN": {
                    Long discountRate = ((campaign.getDiscount())) / 100L;
                    Long discount = price * discountRate;
                    Long maxDiscount = campaign.getMaxDiscount();

                    Long maybeDiscountPrice = cartItem.getDiscountPrice();

                    Long finalPrice;
                    if(maybeDiscountPrice != null){
                        finalPrice = maybeDiscountPrice;
                    } else {
                        finalPrice = price;
                    }

                    if (discount < maxDiscount) {
                        cartItem.setDiscountPrice(finalPrice - discount);
                    } else {
                        cartItem.setDiscountPrice(finalPrice - maxDiscount);
                    }
                    break;
                }
                case "TUTAR": {
                    Long discount = campaign.getDiscount();

                    Long maybeDiscountPrice = cartItem.getDiscountPrice();

                    Long finalPrice;
                    if(maybeDiscountPrice != null){
                        finalPrice = maybeDiscountPrice;
                    } else {
                        finalPrice = price;
                    }

                    if (finalPrice > discount) {
                        cartItem.setDiscountPrice(finalPrice - discount);
                    } else {
                        cartItem.setDiscountPrice(0L);
                    }

                    break;
                }
                default:
                    throw new CampaignNotValidException("Not a valid campaign");
            }
        });
        return cartItem;
    }

    public List<CartItem> applyDiscounts(List<CartItem> cartItems) {
        List<CartItem> discountEligibleCartItems = new ArrayList<>();

        //grouping cart items by their category ids
        Map<String, List<CartItem>> cartItemsByCategories = cartItems.stream().collect(
                Collectors.groupingBy(CartItem::getCategoryId)
        );

        //iterating through groups
        cartItemsByCategories.forEach((categoryId, cartItemsByCategory) -> {
            if (campaignService.existsWithTypeId(categoryId)) { //if a campaign is available for a category
                //receiving max priced item from the cart among them
                discountEligibleCartItems.add(cartItemsByCategory.stream().max(Comparator.comparing(CartItem::getPrice)).get());
            } else {
                //those which don't have a category campaign are also added.
                discountEligibleCartItems.addAll(cartItemsByCategory);
            }
        });

        return discountEligibleCartItems.stream().map((this::applyDiscount)).collect(Collectors.toList());
    }

}
