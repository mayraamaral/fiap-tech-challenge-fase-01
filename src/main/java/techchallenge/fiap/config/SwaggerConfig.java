package techchallenge.fiap.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.*;

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