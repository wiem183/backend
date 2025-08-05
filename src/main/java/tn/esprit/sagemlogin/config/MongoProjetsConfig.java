package tn.esprit.sagemlogin.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
        basePackages = "tn.esprit.sagemlogin.repositories.projets",
        mongoTemplateRef = "projetsMongoTemplate"
)
public class MongoProjetsConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Bean(name = "projetsMongoTemplate")
    public MongoTemplate projetsMongoTemplate() {
        MongoClient client = MongoClients.create(mongoUri);
        MongoDatabaseFactory factory = new SimpleMongoClientDatabaseFactory(client, "projets");
        return new MongoTemplate(factory);
    }
}
