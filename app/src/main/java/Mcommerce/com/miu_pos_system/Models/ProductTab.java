package Mcommerce.com.miu_pos_system.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductTab {
    private String productID;
    private String productName;
    private String category;
    private String createDate;
    private int quantity;
    private double price;

}
