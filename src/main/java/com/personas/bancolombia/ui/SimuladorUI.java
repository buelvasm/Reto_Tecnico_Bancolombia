package com.personas.bancolombia.ui;

import net.serenitybdd.screenplay.targets.Target;

public class SimuladorUI {

    public static final Target LST_CREDITO = Target.the("tipo de credito").locatedBy("//select[@name='tipoCredito']");
    public static final Target TXT_VALOR = Target.the("valor solicitado").locatedBy("//input[@name='valorSolicitado']");
    public static final Target LST_PLAZO = Target.the("plazo").locatedBy("//select[@name='plazo']");
    public static final Target BTN_SIMULAR_CREDITO = Target.the("simular credito").locatedBy("//button[@id='btnSubmit']");
    public static final Target TXT_CUOTA_MESUAL = Target.the("cuota mensual").locatedBy("(//*[@class='val-number ng-binding'])[1]");
    public static final Target TXT_SEGURO_VIDA = Target.the("seguro de vida ").locatedBy("(//*[@class='val-number ng-binding'])[2]");
    public static final Target TXT_TOTAL = Target.the("total").locatedBy("(//*[@class='result ng-binding'])[2]");

}
