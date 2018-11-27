package com.lpdm.msuser.config;

import com.lpdm.msuser.beans.AppUser;
import com.lpdm.msuser.beans.enumeration.AccessEnum;
import org.springframework.boot.CommandLineRunner;

public class Init implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {

        AppUser admin1 = new AppUser("vianney.diris@gmail.com", "admin1", AccessEnum.ADMIN);
        AppUser admin2 = new AppUser("rockntrek@gmail.com", "admin2", AccessEnum.ADMIN);
        AppUser admin3 = new AppUser("juliencauwet@yahoo.fr", "admin3", AccessEnum.ADMIN);



    }
}
