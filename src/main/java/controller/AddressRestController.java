package controller;


import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.entities.Address;
import fr.simplon.domedespuys.dto.AddressDTO;
import fr.simplon.domedespuys.repository.AddressRepository;
import fr.simplon.domedespuys.service.interfaces.IAddressService;
import fr.simplon.domedespuys.views.AddressView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/address")
public class AddressRestController {

    private final IAddressService addressService;
    private final AddressRepository addressRepository;

    @GetMapping
    @JsonView(AddressView.AddressListView.class)
    public List<Address> getAddresses(){
        return addressService.getCollections();
    }


}
