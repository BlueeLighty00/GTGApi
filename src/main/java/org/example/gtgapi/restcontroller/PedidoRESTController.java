package org.example.gtgapi.restcontroller;


import org.example.gtgapi.models.dao.PedidoDAOImpl;
import org.example.gtgapi.models.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoRESTController {

    @Autowired
    PedidoDAOImpl PedidoService;

    @GetMapping("/list")
    public Pedido[] pedidos() {

        return PedidoService.findAll();
    }

    @GetMapping("/list/{id}")
    public Pedido pedidoID(@PathVariable Long id) {

        return PedidoService.findById(id);
    }

}
