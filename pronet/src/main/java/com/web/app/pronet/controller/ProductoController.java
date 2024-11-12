package com.web.app.pronet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        List<Producto> productos = productoRepo.GetAllProductos();
        model.addAttribute("productos", productos);
        return "lista_productos";
    }
    // Mostrar formulario para crear un producto
    @GetMapping("/nuevo")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("producto", new Producto());
        return "formulario";
    }

    // Guardar un nuevo producto
    @PostMapping
    public String crearProducto(@ModelAttribute Producto producto) {
        productoRepo.createProducto(producto);
        return "redirect:/productos";
    }
  // Mostrar formulario para editar un producto
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Producto producto = productoRepo.getProductoById(id);
        model.addAttribute("producto", producto);
        return "formulario";
    }
     // Eliminar un producto
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoRepo.deleteProducto(id);
        return "redirect:/productos";
    }
}
