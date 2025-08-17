//package Desafio.Foro_Hub_G8.util;
//
//public class GeneradorClaves {
//}
package Desafio.Foro_Hub_G8.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneradorClaves {

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("123456");
        System.out.println("Clave encriptada: " + encodedPassword);
    }
}