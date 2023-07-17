package service;

import model.Accident;

import java.math.BigDecimal;
import java.util.Date;

public class AccidentService {

    // Yeni nesne oluşturup, gerekli değerleri set ettikten sonra geri döndürüyoruz.
    public Accident createAccident(Date accidentDate, String description, BigDecimal damagePrice, int failureRate) {
        Accident accident = new Accident();
        accident.setAccidentDate(accidentDate);
        accident.setDescription(description);
        accident.setDamagePrice(damagePrice);
        accident.setFailureRate(failureRate);

        return accident;
    }
}
