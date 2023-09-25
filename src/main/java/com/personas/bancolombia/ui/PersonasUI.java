package com.personas.bancolombia.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PersonasUI {

    public static final Target BTN_CERRAR_POPUP = Target.the("cerrar").locatedBy("//*[@id='close-modal-btn']");
    public static final Target BTN_SABER_MAS= Target.the("finanza tus sueños").locatedBy("//*[@href='/personas/creditos/consumo']");

}
