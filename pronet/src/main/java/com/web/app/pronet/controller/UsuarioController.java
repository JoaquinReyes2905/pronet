package com.web.app.pronet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.app.pronet.models.Producto;
import com.web.app.pronet.models.Usuario;
import com.web.app.pronet.services.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService userService;

    @GetMapping
    public String listarUsuarios(Model model) {
        List<Usuario> users = userService.GetAllUsers();
        model.addAttribute("users", users);
        return "lista_usuarios";
    }
}