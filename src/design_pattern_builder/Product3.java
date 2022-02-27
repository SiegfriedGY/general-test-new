package design_pattern_builder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product3 {

    private Integer id;
    private String type;
    private String name;

}
