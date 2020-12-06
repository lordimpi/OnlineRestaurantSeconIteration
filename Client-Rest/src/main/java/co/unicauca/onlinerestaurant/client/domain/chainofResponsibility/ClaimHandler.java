package co.unicauca.onlinerestaurant.client.domain.chainofResponsibility;

/**
 * Manejador de reclamos
 *
 * @author ximena Gallego
 */
public abstract class ClaimHandler {

    private ClaimHandler nextHandler;
    private String email;

    public ClaimHandler(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public abstract boolean attend(Claim request);

    public ClaimHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(ClaimHandler handler) {
        nextHandler = handler;
    }
}
