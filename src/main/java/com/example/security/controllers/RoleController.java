package com.example.security.controllers;

import com.example.security.models.dtos.RoleDto;
import com.example.security.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/save")
    public RoleDto save(@RequestBody RoleDto roleDto){
        return roleService.save(roleDto);
    }
}
