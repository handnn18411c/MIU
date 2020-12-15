package Mcommerce.com.miu_pos_system.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order {
    private String idProduct;
    private String productName;
    private double price;
    private String imgProduct;
    private String productDetail;
    private int quantity;
}
