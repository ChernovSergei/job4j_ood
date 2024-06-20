package lsp.violation;

public class Particle {
    private float charge;
    private boolean spin;
    private Color color;
    private int mass;
    private final int minMass = 900;

    public Particle() { }
    /**
     * Constructor
     * Setters and getters are here
     */

    public int getMass() {
        return this.mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public Particle weakInteraction(Particle particle) {
        Particle result = new Particle();
        if (particle.getMass() < 938) {
            /**
             *Particle will decade into result particle + emitting electron and antineutrino
             */
            result.setMass(particle.mass);
        }
        return result;
    }

    public int strongInteractionMassChange(Particle particle) {
        Particle result = new Particle();
        /**
         * particle will interact with existing particle and create result particle
         * COLOR enum is involved into strong interaction calculation
         */
        if (particle.getMass() < minMass) {
            /**
             * do mass correction
             */
             result.setMass(particle.mass);
        }
        return result.getMass();
    }
}
