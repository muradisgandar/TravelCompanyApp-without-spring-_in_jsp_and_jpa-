/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author murad_isgandar
 */
//for admin login config
public class LoginConfig {

    public static Map<String, String> getProperties() {

        Map<String, String> result = new HashMap<>();
        try (InputStream input = LoginConfig.class.getClassLoader().getResourceAsStream("/property/loginConfig.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return null;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
            result.put("username", prop.getProperty("username"));
            result.put("email", prop.getProperty("email"));
            result.put("password", prop.getProperty("password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return result;
    }

}
