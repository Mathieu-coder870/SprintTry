package fr.simplon.domedespuys.service.interfaces;

import fr.simplon.domedespuys.dto.ProductDTO;
import fr.simplon.domedespuys.entities.Product;

import java.util.List;

public interface IProductService extends
        ICreate<Product, ProductDTO>,
        IUpdate<ProductDTO, ProductDTO>,
        IGetItem<Product>,
        ICollection<Product>
{

}
