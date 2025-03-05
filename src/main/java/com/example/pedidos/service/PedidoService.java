/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.pedidos.service;

/**
 *
 * @author danie
 */

import com.example.pedidos.model.Pedido;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {
    private final List<Pedido> pedidos = new ArrayList<>();

    public PedidoService() {
        pedidos.add(new Pedido("1", "PlayStation 5", 5.0));
        pedidos.add(new Pedido("2", "Xbox 360", 10.0));
    }

    public Flux<Pedido> listarPedidos() {
        return Flux.fromIterable(pedidos);
    }

    public Mono<Pedido> crearPedido(Pedido pedido) {
        pedidos.add(pedido);
        return Mono.just(pedido);
    }
}
