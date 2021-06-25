public class BattleOfTrafalgar {
    private double a;
    private double b;
    private int counter;

    public BattleOfTrafalgar(double aEffective, double bEffective) {
        a = aEffective;
        b = bEffective;
        counter = 1;
    }

    public void simulate(double A, double B) {
        if (Math.abs(A) > 0.5 && Math.abs(B) > 0.5) {
            A -= B * a;
            B -= A * b;
            System.out.println(counter + "\tA: " + A + ", B: " + B);
            counter++;
            if (Math.abs(A) > 0.5 && Math.abs(B) > 0.5) {
                simulate(A, B);
            }
            else
                counter = 1;
        }
    }

    public void simulate2(double A, double B) {
        counter = 1;
        while (Math.abs(A) > 0.5 && Math.abs(B) > 0.5) {
            A -= B * a;
            B -= A * b;
            System.out.println(counter+ "\tA: " + A + ", B: " + B);
            counter++;
        }
    }

    public static void main (String[] args) {
        double[] dArgs = new double[4];
        int fill = 0;
        try {
            for (String arg : args) {
                if (fill < 4) {
                    dArgs[fill] = Double.parseDouble(arg);
                }
                fill++;
            }
            int firstArg = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Bad input!");
            System.exit(1);
        }
        System.out.println(dArgs[0] + " " + dArgs[1] + " " + dArgs[2] + " " +  dArgs[3]);
        BattleOfTrafalgar sim = new BattleOfTrafalgar(dArgs[3], dArgs[3]);
        sim.simulate(dArgs[0], dArgs[1]);
    }
}
