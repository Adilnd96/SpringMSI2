package ma.ana.gestionuser.presentation.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@ConfigurationProperties(prefix = "swagger.ui")
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Properties {
    String title = "Gestion des utilisateurs";
    String description = "Ajouter et afficher des utilisateurs";
    String version = "0.1";
    String contactName = "Adil NAIT DAOUD";
    String contactUrl = "www.linkedin.com/in/adil-nait-daoud-7a0958172/";
    String contactEmail = "adil.naitdaoud@gmail.com";
}
