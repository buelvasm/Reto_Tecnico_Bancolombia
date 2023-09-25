package com.personas.bancolombia.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/com.personas.bancolombia.features/bancolombiaPersonas.feature",
        glue = "com.personas.bancolombia.stepDefinitions",
        tags = "@BancolombiaPersonas",
        snippets = SnippetType.CAMELCASE
)
public class BancolombiaPersonasRunner {

}
