package lsp.violation;

public class Proton extends Particle {
    /**
     * new arguments; constructor; getters and setters is here
     */

    @Override
    public Particle weakInteraction(Particle particle) {
        Particle result = new Particle();
        /**
         * LSP violation - precondition cannot be strengthen in a subclass
         */
        if (particle.getMass() < 939) {
            /**
             *Particle will into another particle + emitting electron and antineutrino
             */
            result.setMass(particle.getMass());
        }
        return result;
    }
}
