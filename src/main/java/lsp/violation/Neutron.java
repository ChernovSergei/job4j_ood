package lsp.violation;

public class Neutron extends Particle {
    /**
    * new arguments; constructor; getters and setters is here
    */
    @Override
    public int strongInteractionMassChange(Particle particle) {
        Particle result = new Particle();
        /**
         * particle will interact with existing particle and create result particle
         * LSP violation - Software engineer forgot to add mass correction.
         * Post conditions couldn't be weakened in a subclass.
         */
        return result.getMass();
    }
}
