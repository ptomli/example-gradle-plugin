package com.example;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class ExamplePlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        ExampleExtension extension = project.getExtensions().create("example", ExampleExtension.class);

        project.task("exampleTask")
                .doLast(task -> {
                    System.out.println(extension.getGreeting().getOrElse("Hello World!"));
                });
    }
}
