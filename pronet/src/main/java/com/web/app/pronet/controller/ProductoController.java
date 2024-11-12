package com.web.app.pronet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.web.app.pronet.repo.*;
import com.web.app.pronet.services.ProductoService;

import java.util.List;
import com.web.app.pronet.models.Producto;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoRepo;

     @GetMapping
    public String listarProductos(Model model) {
        List<Producto> productos = productoRepo.GetAllUsers();
        model.addAttribute("productos", productos);
        return "lista_productos";
    }
}
