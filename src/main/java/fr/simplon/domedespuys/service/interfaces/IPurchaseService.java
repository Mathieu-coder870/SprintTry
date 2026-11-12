package fr.simplon.domedespuys.service.interfaces;

import fr.simplon.domedespuys.dto.PurchasePostDTO;
import fr.simplon.domedespuys.dto.PurchasePutDTO;
import fr.simplon.domedespuys.entities.Purchase;

import java.util.List;
import java.util.Optional;

public interface IPurchaseService extends

    ICreate<Purchase, PurchasePostDTO>,
        IUpdate<Purchase, PurchasePutDTO>,
        IGetItem<Purchase>,
        ICollection<Purchase>
{

    List<Purchase> findAll();


}
