package hu.nye.progtech.torpedo.configuration;

import java.io.IOException;
import java.sql.SQLException;

import hu.nye.progtech.torpedo.model.GameState;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring handler.
 */

@Configuration
public class ApplicationConfiguration {
    @Bean
    GameState gameState() throws IOException, SQLException {
        return new GameState();
    }
}
