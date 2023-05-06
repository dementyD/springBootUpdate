package spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@ConfigurationProperties(prefix = "sort")
@Configuration
public class SortSetting {
    private List<String> sortof;

    public List<String> getSortOf() {
        return sortof;
    }

    public void setSortOf(List<String> sortOf) {
        this.sortof = sortOf;
    }

}
