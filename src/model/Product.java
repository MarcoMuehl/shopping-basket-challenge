package model;

import lombok.Getter;
import lombok.Setter;

/**
 * A product DTO with code and price.
 */
@Getter
@Setter
public record Product(String code, double price) {

}
