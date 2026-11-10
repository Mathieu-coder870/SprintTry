package fr.simplon.domedespuys.dto;

import fr.simplon.domedespuys.entities.Address;
import fr.simplon.domedespuys.entities.PurchaseProduct;
import fr.simplon.domedespuys.entities.User;

import java.util.List;

public class PurchasePostDTO {
    public AddressDTO addressDTO;
    public List<PurchaseProduct> purchaseProducts;
    public String status = "PENDING";
    public User user;
    public String  number;

}
