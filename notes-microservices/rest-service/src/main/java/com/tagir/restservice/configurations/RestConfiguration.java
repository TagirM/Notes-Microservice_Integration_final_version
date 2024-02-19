package com.tagir.restservice.configurations;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RestConfiguration {

    private final MeterRegistry meterRegistry;

    @Bean
    public Counter notesCounter(MeterRegistry meterRegistry){
        return Counter.builder("required_getNotes_counters")
                .description("Counter for method getNotes")
                .register(meterRegistry);
    }
}
