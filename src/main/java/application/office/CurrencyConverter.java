package application.office;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

public class CurrencyConverter {

    public static BigDecimal conver(Currency from, Currency to) {

        try {
            URL url = new URL(
                    "https://free.currconv.com/api/v7/" +
                            "convert" +
                            "?q=" + from.getName() + "_" + to.getName() +
                            "&compact=ultra" +
                            "&apiKey=cd8b88536350a5db7a5e");

            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String lines = reader.readLine();
            System.out.println(lines);
            if(lines.length() > 0) {
                int startIndex = lines.indexOf(":") + 1;
                int endIndex = lines.indexOf("}");
                String value = lines.substring(startIndex, endIndex);
                return new BigDecimal(value);
            }
            reader.close();

        } catch (MalformedURLException e) {
            System.out.println("zly URL");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new BigDecimal(0);
    }

}
