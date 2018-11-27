package com.lpdm.msuser.config;

import com.lpdm.msuser.beans.AppUser;
import com.lpdm.msuser.beans.enumeration.AccessEnum;
import com.lpdm.msuser.dao.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public void run(String... args) throws Exception {

        AppUser admin1 = new AppUser("vianney.diris@gmail.com", "admin1", AccessEnum.ADMIN);
        AppUser admin2 = new AppUser("rockntrek@gmail.com", "admin2", AccessEnum.ADMIN);
        AppUser admin3 = new AppUser("juliencauwet@yahoo.fr", "admin3", AccessEnum.ADMIN);

        appUserRepository.save(admin1);
        appUserRepository.save(admin2);
        appUserRepository.save(admin3);

    }
}
