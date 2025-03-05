/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.pedidos.controller;

/**
 *
 * @author danie
 */


import com.example.pedidos.model.Pedido;
import com.example.pedidos.service.PedidoService;
import org.springframework.context.MessageSource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import jakarta.validation.Valid;
import java.util.Locale;

@RestController
@RequestMapping("/api/pedidos")
@Validated
public class PedidoController {
    private final PedidoService pedidoService;
    private final MessageSource messageSource;

    public PedidoController(PedidoService pedidoService, MessageSource messageSource) {
        this.pedidoService = pedidoService;
        this.messageSource = messageSource;
    }

    @GetMapping
    public Flux<Pedido> listarPedidos(@RequestHeader(value = "Accept-Language", defaultValue = "es") String language) {
        Locale locale = new Locale(language);
        String mensaje = messageSource.getMessage("pedido.lista", null, locale);
        System.out.println(mensaje);
        return pedidoService.listarPedidos();
    }

    @PostMapping
    public Mono<String> crearPedido(@Valid @RequestBody Pedido pedido, @RequestHeader(value = "Accept-Language", defaultValue = "es") String language) {
        Locale locale = new Locale(language);
        String mensaje = messageSource.getMessage("pedido.creado", null, locale);
        return pedidoService.crearPedido(pedido).map(p -> mensaje);
    }

}
