package net.mingleup.guide.employee.abstractfactory;

/**
 * @author CodeVillains
 * @description :
 */
public class PayCalculatorFactory {

    static PayCalculator createPayCalculator(String employeeType) {
        switch (employeeType) {
            case "Regular":
                return new RegularPayCalculator();
            case "Contract":
                return new ContractPayCalculator();
            case "Temporary":
                return new TemporaryPayCalculator();
            case "Assist":
                return new AssistPayCalculator();
            default:
                return null;
        }
    }
}
