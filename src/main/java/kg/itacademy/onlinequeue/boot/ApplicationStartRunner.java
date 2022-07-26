package kg.itacademy.onlinequeue.boot;

import kg.itacademy.onlinequeue.entity.RoleEntity;
import kg.itacademy.onlinequeue.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class ApplicationStartRunner implements CommandLineRunner {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {

        RoleEntity roleUser = new RoleEntity();
        roleUser.setNameRole("ROLE_USER");

        RoleEntity roleAdmin = new RoleEntity();
        roleAdmin.setNameRole("ROLE_ADMIN");

       RoleEntity roleCompany = new RoleEntity();
       roleCompany.setNameRole("ROLE_COMPANY");


        roleRepository.save(roleUser);
        roleRepository.save(roleAdmin);
        roleRepository.save(roleCompany);

    }
}

