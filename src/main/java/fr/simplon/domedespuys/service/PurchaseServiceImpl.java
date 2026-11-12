package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.BrandDTO;
import fr.simplon.domedespuys.dto.PurchasePostDTO;
import fr.simplon.domedespuys.dto.PurchasePutDTO;
import fr.simplon.domedespuys.entities.Brand;
import fr.simplon.domedespuys.entities.Purchase;
import fr.simplon.domedespuys.repository.PurchaseRepository;
import fr.simplon.domedespuys.service.interfaces.IPurchaseService;

import java.util.List;

public class PurchaseServiceImpl implements IPurchaseService {

    private PurchaseRepository purchaseRepository;

    @Override
    public List<Purchase> getCollection() {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase create(PurchasePostDTO dto) {
        Purchase purchase = new Purchase();
        dtoToObject(dto, purchase);
        return purchase;
    }

    @Override
    public Purchase getById(String id) {
        return purchaseRepository
                .findById(Long.parseLong(id))
                .orElse(null);
    }

    @Override
    public Purchase update(String id, PurchasePutDTO dto) {
        return null;
    }

    private void dtoToObject(PurchasePostDTO dto, Purchase purchase) {
        purchase.setStatus(dto.status);
        PurchaseRepository.saveAndFlush(purchase);
    }
}
