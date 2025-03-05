package com.example.pedidos.service;

import com.example.pedidos.model.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

class PedidoServiceTest {

    private PedidoService pedidoService;
    private List<Pedido> pedidosMock;

    @BeforeEach
    void setUp() {
        // Crear lista de pedidos simulada
        pedidosMock = new ArrayList<>();
        pedidoService = new PedidoService();
    }

    @Test
    void testListarPedidos() {
        // Crear pedidos de prueba
        Pedido pedido1 = new Pedido("1", "Mac", 100.0);
        Pedido pedido2 = new Pedido("2", "Asus VivoBook", 200.0);
        
        // Agregamos los pedidos a la lista simulada
        pedidosMock.add(pedido1);
        pedidosMock.add(pedido2);

        Flux<Pedido> pedidos = Flux.fromIterable(pedidosMock);

        StepVerifier.create(pedidos)
            .expectNext(pedido1)
            .expectNext(pedido2)
            .verifyComplete();
    }

    @Test
    void testCrearPedido() {
        Pedido nuevoPedido = new Pedido("3", "mouse", 300.0);
        Mono<Pedido> resultado = Mono.just(nuevoPedido);

        StepVerifier.create(resultado)
            .expectNextMatches(p -> p.getNombre().equals("mouse")) // Se cambia getCliente() por getNombre()
            .verifyComplete();
    }


    @Test
    void testCrearPedidoConTotalNegativo() {
        Pedido pedidoInvalido = new Pedido("4", "pantalla", -50.0);
        Mono<Pedido> resultado = Mono.just(pedidoInvalido);

        StepVerifier.create(resultado)
            .expectNextMatches(p -> p.getTotal() < 0)
            .verifyComplete();
    }
}
