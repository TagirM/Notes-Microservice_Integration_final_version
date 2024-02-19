package com.tagir.notes.configurations;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class NoteConfiguration {

    private final MeterRegistry meterRegistry;

    @Bean
    public Counter notesCounter(MeterRegistry meterRegistry){
        return Counter.builder("required_noteAll_counters")
                .description("Counter for method noteAll")
                .register(meterRegistry);
    }
}
