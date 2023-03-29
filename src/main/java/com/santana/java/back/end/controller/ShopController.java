package com.santana.java.back.end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.List;

import com.santana.java.back.end.dto.ShopDTO;
import com.santana.java.back.end.dto.ShopReportDTO;
import com.santana.java.back.end.service.ShopService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @GetMapping("/shopping")
    public List<ShopDTO> getShops() {
        List<ShopDTO> produtos = shopService.getAll();
        return produtos;
    }

    @GetMapping("/shopping/shopByUser/{userIdentifier}")
    public List<ShopDTO> getShops(
            @PathVariable String userIdentifier) {
        List<ShopDTO> produtos = shopService.getByUser(userIdentifier);
        return produtos;
    }

    @GetMapping("/shopping/shopByDate")
    public List<ShopDTO> getShops(@RequestBody ShopDTO shopDTO) {

        List<ShopDTO> produtos = shopService.getByDate(shopDTO);

        return produtos;
    }

    @GetMapping("/shopping/{id}")
    public ShopDTO findById(@PathVariable Long id) {
        return shopService.findById(id);
    }

    @PostMapping("/shopping")
    public ShopDTO newShop(
            @RequestHeader(name = "key", required = true) String key,
            @Valid @RequestBody ShopDTO shopDTO) {

        return shopService.save(shopDTO, key);
    }

    @GetMapping("/shopping/search")
    public List<ShopDTO> getShopsByFilter(
            @RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy") LocalDate dataInicio,
            @RequestParam(name = "dataFim", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy") LocalDate dataFim,
            @RequestParam(name = "valorMinimo", required = false) Float valorMinimo) {

        // DateTimeFormatter parser = new DateTimeFormatterBuilder()
        // // dia/mês/ano
        // .appendPattern("dd/MM/uuuu")
        // // valor default para o horário (zero para meia-noite)
        // .parseDefaulting(ChronoField.HOUR_OF_DAY, 0).toFormatter();
        // LocalDateTime dateTime = LocalDateTime.parse(dataInicio, parser);
        return shopService.getShopsByFilter(dataInicio, dataFim, valorMinimo);
    }

    @GetMapping("/shopping/report")
    public ShopReportDTO getReportByDate(
            @RequestParam(name = "dataInicio", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataInicio,
            @RequestParam(name = "dataFim", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataFim) {

        return shopService.getReportByDate(dataInicio, dataFim);
    }
}
