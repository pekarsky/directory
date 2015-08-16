package com.petproject.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:database-test.properties"})
public class HibernateTestConfiguration extends HibernateConfiguration {

}
