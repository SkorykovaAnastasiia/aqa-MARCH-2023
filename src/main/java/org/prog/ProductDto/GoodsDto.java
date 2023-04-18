package org.prog.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class GoodsDto {
    private String nameProduct;
    private int Price;
    private String URl;
}
