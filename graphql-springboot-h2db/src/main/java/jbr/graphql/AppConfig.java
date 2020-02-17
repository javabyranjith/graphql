package jbr.graphql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jbr.graphql.resolver.Mutation;
import jbr.graphql.resolver.Query;

@Configuration
public class AppConfig {
  @Bean
  public Query query() {
    return new Query();
  }

  @Bean
  public Mutation mutation() {
    return new Mutation();
  }

}
