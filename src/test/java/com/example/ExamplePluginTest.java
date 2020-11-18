package com.example;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

public class ExamplePluginTest {

    Project project;

    @Before
    public void setup() {
        project = ProjectBuilder.builder().build();
        project.getPluginManager().apply("example");
    }


    @Test
    public void test() {
        assertThat(project.getPluginManager().hasPlugin("example")).isTrue();
    }
}