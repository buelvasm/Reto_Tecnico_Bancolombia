package com.personas.bancolombia.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectOptions implements Interaction {
    Target element;
    String text;

    public SelectOptions(Target element, String text) {
        this.element = element;
        this.text = text;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElement listlocation = element.resolveFor(actor);
        Select select = new Select(listlocation);
        select.selectByVisibleText(text);

    }

    public static SelectOptions here(Target element, String text) {
        return Instrumented.instanceOf(SelectOptions.class).withProperties(element, text);

    }
}
