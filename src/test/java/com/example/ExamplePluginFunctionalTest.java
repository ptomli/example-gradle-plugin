package com.example;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.gradle.testkit.runner.TaskOutcome;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ExamplePluginFunctionalTest {

    @Rule
    public final TemporaryFolder testProjectDir = new TemporaryFolder();
    private File settingsFile;
    private File buildFile;

    @Before
    public void setup() throws IOException {
        settingsFile = testProjectDir.newFile("settings.gradle");
        buildFile = testProjectDir.newFile("build.gradle");
    }

    @Test
    public void test() throws IOException {

        writeFile(settingsFile, "rootProject.name = 'hello-world'");
        writeFile(buildFile, "plugins { id 'example' }");

        BuildResult result = GradleRunner.create()
                .withProjectDir(testProjectDir.getRoot())
                .withArguments("exampleTask")
                .withPluginClasspath()
                .build();

        assertThat(result.getOutput()).contains("Hello World!");

        assertThat(result.task(":exampleTask"))
                .isNotNull()
                .hasFieldOrPropertyWithValue("outcome", TaskOutcome.SUCCESS);
    }

    private void writeFile(File destination, String content) throws IOException {
        try (BufferedWriter output = new BufferedWriter(new FileWriter(destination))) {
            output.write(content);
        }
    }
}
