package com.example;

import lombok.Data;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.Property;

import javax.inject.Inject;

@Data
public class ExampleExtension {
    private final Property<String> greeting;

    @Inject
    public ExampleExtension(ObjectFactory objects) {
        greeting = objects.property(String.class);
    }
}
