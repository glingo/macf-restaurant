package restaurant.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import restaurant.model.salle.StatutEmplacement;

@Converter(autoApply = true)
public class StatutEmplacementConverter implements AttributeConverter<StatutEmplacement, String> {

    @Override
    public String convertToDatabaseColumn(StatutEmplacement attribute) {
        if(attribute == null) {
            return null;
        }
        
        return attribute.getLibelle();
    }

    @Override
    public StatutEmplacement convertToEntityAttribute(String dbData) {
        return StatutEmplacement.valueOf(dbData);
    }
    
}
