import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class Agent_MLR extends Agent {

    private Agent_GUI testAgent;
    protected void setup() {
        testAgent = new Agent_GUI(this);
        testAgent.showGui();
    }

    public void actionAgent(final double factorX1, final double factorX2, final double valueX){
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                double [] x = {23,26,30,34,43,48,52,57,58};
                double [] y = {651,762,856,1063,1190,1298,1421,1440,1518};

                double [] factor_1 = {41.90,43.40,43.90,44.50,47.30,47.50,47.90,50.20,52.80,53.20,56.70,57.00,63.50,65.30,71.10,77.00,77.80};
                double [] factor_2 = {29.10,29.30,29.50,29.70,29.90,30.30,30.50,30.70,30.80,30.90,31.50,31.70,31.90,32.00,32.10,32.50,32.90};
                double [] yield = {251.30,251.30,248.30,267.50,273.00,276.50,270.30,274.90,285.00,290.00,297.00,302.50,304.50,309.50,321.70,330.70,349.00};

                betaV_calculations testOne = new betaV_calculations(factor_1,factor_2,yield, factorX1, factorX2);
                testOne.func();
                //System.out.println("Agent's action method executed");

                gradient_calculation testTwo = new gradient_calculation(x,y,0.0005,valueX);
                testTwo.func();
            }
        });
    }

}
