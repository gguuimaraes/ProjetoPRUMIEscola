package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author gguui
 */
public class Propriedades {

    public static String getProp(String nome) throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(
                "src\\propriedades\\Propriedades.properties");
        props.load(file);
        return props.getProperty(nome);
    }
}
