package com.personas.bancolombia.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.personas.bancolombia.ui.CreditosUI.BTN_SIMULAR;
import static com.personas.bancolombia.ui.CreditosUI.LNK_VEICULO;
import static com.personas.bancolombia.ui.PersonasUI.BTN_CERRAR_POPUP;
import static com.personas.bancolombia.ui.PersonasUI.BTN_SABER_MAS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CreditosTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(LNK_VEICULO, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(LNK_VEICULO),
                WaitUntil.the(BTN_SIMULAR, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(BTN_SIMULAR)
        );
    }
    public static CreditosTask onThesite(){
        return Instrumented.instanceOf(CreditosTask.class).withProperties();
    }
}
