package com.devsuperior.dsdeliver.controllers;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll(){
        List<OrderDTO> orders = orderService.findAll();
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO orderDTO) {
        URI uri = null;
        try {
            orderDTO = orderService.insert(orderDTO);
            uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(orderDTO.getId()).toUri();
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return ResponseEntity.created(uri).body(orderDTO);
    }

    @PutMapping("/{id}/delivered")
    public ResponseEntity<OrderDTO> setDelivered(@PathVariable Long id){
        OrderDTO orderDTO = orderService.setDelivered(id);
        return ResponseEntity.ok().body(orderDTO);
    }
}
