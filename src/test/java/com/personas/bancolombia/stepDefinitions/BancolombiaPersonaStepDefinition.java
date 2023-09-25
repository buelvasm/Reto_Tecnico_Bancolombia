package com.personas.bancolombia.stepDefinitions;

import com.personas.bancolombia.tasks.CreditosTask;
import com.personas.bancolombia.tasks.PersonasTask;
import com.personas.bancolombia.tasks.SimuladorTask;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BancolombiaPersonaStepDefinition {

    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^Que me encuentro en la pagina de bancolombia personas e ingrese a saber mas$")
    public void queMeEncuentroEnLaPaginaDeBancolombiaPersonasEIngreseASaberMas() {
        theActorCalled("Test").wasAbleTo(Open.url("https://www.bancolombia.com/personas"));
    }

    @Cuando("^Busque el simulador de creditos de moto alto cilindraje$")
    public void busqueElSimuladorDeCreditosDeMotoAltoCilindraje() {
     theActorInTheSpotlight().attemptsTo(PersonasTask.onThesite());
     theActorInTheSpotlight().attemptsTo(CreditosTask.onThesite());
    }

    @Cuando("^Llene la información necesaria$")
    public void lleneLaInformaciónNecesaria() {
        theActorInTheSpotlight().attemptsTo(SimuladorTask.onThesite());
    }

    @Entonces("^Valido la informacion del credito simulado$")
    public void validoLaInformacionDelCreditoSimulado() {

    }

}
