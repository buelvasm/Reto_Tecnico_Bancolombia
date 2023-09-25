package com.personas.bancolombia.tasks;

import com.personas.bancolombia.interactions.SelectOptions;
import com.personas.bancolombia.utils.EscribirExcel;
import com.personas.bancolombia.utils.LeerExcel;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import static com.personas.bancolombia.ui.SimuladorUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SimuladorTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        LeerExcel leerExcel = new LeerExcel();
        EscribirExcel escribirExcel = new EscribirExcel();

        try {
            actor.attemptsTo(
                    WaitUntil.the(LST_CREDITO, isVisible()).forNoMoreThan(5).seconds(),
                    SelectOptions.here(LST_CREDITO, (leerExcel.leerDatosExcel("Data.xlsx", "Datos", 1, 0))),
                    WaitUntil.the(TXT_VALOR, isVisible()).forNoMoreThan(5).seconds(),
                    Enter.keyValues(leerExcel.leerDatosExcel("Data.xlsx", "Datos", 1, 1)).into(TXT_VALOR),
                    SelectOptions.here(LST_PLAZO, (leerExcel.leerDatosExcel("Data.xlsx", "Datos", 1, 2))),
                    Click.on(BTN_SIMULAR_CREDITO)
            );

            String cuotaMensual = TXT_CUOTA_MESUAL.resolveFor(actor).getText();
            String seguroVida = TXT_SEGURO_VIDA.resolveFor(actor).getText();
            String total = TXT_TOTAL.resolveFor(actor).getText();

            Map<String, Object[]> datos = new TreeMap<>();
            Object[] titulos = new Object[]{"Cuota Mensual", "Seguro de Via", "Total"};
            Object[] product = new Object[]{cuotaMensual,seguroVida,total};
            datos.put("1",titulos);
            datos.put("2",product);
            EscribirExcel.EscribirExcel(datos);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SimuladorTask onThesite() {
        return Instrumented.instanceOf(SimuladorTask.class).withProperties();
    }
}
