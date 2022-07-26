package kg.itacademy.onlinequeue.controller;

import kg.itacademy.onlinequeue.entity.RoleEntity;
import kg.itacademy.onlinequeue.model.RoleModel;
import kg.itacademy.onlinequeue.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600, origins = "*")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleController {
    final RoleRepository roleRepository;

    @PostMapping("/create")
    public String createRole(@RequestBody RoleModel roleModel) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setNameRole(roleModel.getName());
        return roleRepository.save(roleEntity).getNameRole();
    }
}
