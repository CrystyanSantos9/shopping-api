package com.santana.java.back.end.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.santana.java.back.end.model.Shop;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ShopDTO {

    @NotBlank
    private String userIdentifier;
    // @NotNull
    private Float total;
    // @NotNull
    private LocalDateTime date;
    @NotNull
    private List<ItemDTO> items;

    public static ShopDTO convert(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setDate(shop.getDate());
        shopDTO.setItems(shop.getItems().stream().map(ItemDTO::convert).collect(Collectors.toList()));
        shopDTO.setTotal(shop.getTotal());
        return shopDTO;
    }

}
