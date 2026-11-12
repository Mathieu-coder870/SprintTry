package fr.simplon.domedespuys.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.entities.Purchase;
import fr.simplon.domedespuys.repository.PurchaseRepository;
import fr.simplon.domedespuys.service.interfaces.IPurchaseService;
import fr.simplon.domedespuys.views.PurchaseView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/order")
public class OrderRestController {
    private IPurchaseService purchaseService;

    @GetMapping
    @JsonView(PurchaseView.PurchaseListView.class)
    public List<Purchase> getPurchases() {
        return purchaseService.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(PurchaseView.PurchaseDetailView.class)
    public Optional<Purchase> getOrder(@PathVariable String id) {
        return purchaseService.findById(Long.valueOf(id));
    }
}
