package com.personas.bancolombia.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.personas.bancolombia.ui.PersonasUI.BTN_CERRAR_POPUP;
import static com.personas.bancolombia.ui.PersonasUI.BTN_SABER_MAS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PersonasTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(BTN_CERRAR_POPUP, isVisible()).forNoMoreThan(5).seconds(),
                JavaScriptClick.on(BTN_CERRAR_POPUP),
                WaitUntil.the(BTN_SABER_MAS, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(BTN_SABER_MAS)
        );
    }
    public static PersonasTask onThesite(){
        return Instrumented.instanceOf(PersonasTask.class).withProperties();
    }
}
