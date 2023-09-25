package com.personas.bancolombia.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CreditosUI {

    public static final Target LNK_VEICULO = Target.the("veiculo").locatedBy("//a[@id='tab-categoria-vehiculo']");
    public static final Target BTN_SIMULAR= Target.the("finanza tus sueños").locatedBy("(//*[contains(text(),'Crédito para moto de alto cilindraje')]/ancestor::div//a[@href='https://sufi.grupobancolombia.com/sufi/creditos/rotativo/simulador'])[1]");
}
