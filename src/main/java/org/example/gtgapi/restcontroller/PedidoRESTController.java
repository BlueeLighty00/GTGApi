package org.example.gtgapi.restcontroller;


import org.example.gtgapi.models.dao.PedidoDAOImpl;
import org.example.gtgapi.models.dao.UsuarioDAOImpl;
import org.example.gtgapi.models.entity.Pedido;
import org.example.gtgapi.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/pedido")
public class PedidoRESTController {

    @Autowired
    UsuarioDAOImpl UsuarioService;

    @Autowired
    PedidoDAOImpl PedidoService;

    @GetMapping("/me")
    public Pedido[] misPedidos() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        Usuario user = UsuarioService.findByUsername(username);

        return PedidoService.findAllByUserId(user.getId());
    }

}
