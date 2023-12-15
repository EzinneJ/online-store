package com.ezinne.services;

import com.ezinne.dtos.CatalogueRequest;
import com.ezinne.entities.Catalogue;
import com.ezinne.repositories.CatalogueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogueService {
    private final CatalogueRepository catalogueRepository;

    public List<Catalogue> catalogueList() {
        return catalogueRepository.findAll();
    }

    public Catalogue addProductToCatalogue(CatalogueRequest catalogueRequest) {
        Catalogue catalogue = new Catalogue();
        catalogue.setProductList(catalogueRequest.getProductList());
        return catalogueRepository.save(catalogue);
    }


}
