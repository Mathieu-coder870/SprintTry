package fr.simplon.domedespuys.dto;

import fr.simplon.domedespuys.entities.Brand;
import fr.simplon.domedespuys.entities.Image;

import java.util.List;

public class ProductDTO {
public String label;
public String description;
public int price;
public String brandId;
public List<ImageDTO> images;

}
