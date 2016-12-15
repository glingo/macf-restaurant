package restaurant.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import restaurant.model.commande.StatutCommande;

@Converter(autoApply = false)
public class StatutCommandeConverter implements AttributeConverter<StatutCommande, String> {

    @Override
    public String convertToDatabaseColumn(StatutCommande attribute) {
        if(attribute == null) {
            return null;
        }
        
        return attribute.name();
    }

    @Override
    public StatutCommande convertToEntityAttribute(String dbData) {
        return StatutCommande.valueOf(dbData);
    }
    
}
