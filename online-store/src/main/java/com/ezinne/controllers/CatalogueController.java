package com.ezinne.controllers;

import com.ezinne.services.CatalogueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CatalogueController {
    private CatalogueService catalogueService;
}
