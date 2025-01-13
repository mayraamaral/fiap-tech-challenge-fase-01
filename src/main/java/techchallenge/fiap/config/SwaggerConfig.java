package techchallenge.fiap.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springOpenAPIDocs() {
        return new OpenAPI()
            .info(new Info()
                .title("Tech Challenge API")
                .description("Docs")
                .version("v1.0"));
    }
}