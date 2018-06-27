package com.br.ufc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Boot
{

   public static void main(String[] args)
   {
      SpringApplication.run(Boot.class, args);
      System.out.println(new BCryptPasswordEncoder().encode("123"));
   }
}
