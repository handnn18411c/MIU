package Mcommerce.com.miu_pos_system.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Category {
    private String cateName;
    private String imgCateUrl;
}
