package co.unicauca.onlinerestaurant.client.domain.chainofResponsibility;

import co.unicauca.onlinerestaurant.client.infra.Utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Nivel de atención 4 de reclamos
 *
 * @author Ximena
 */
public class LevelFour extends ClaimHandler {

    public LevelFour(String email) {
        super(email);
    }

    @Override
    public boolean attend(Claim claim) {
        if (claim.getType().equals(TypeEnum.HIGHER)) {
            Logger logger = LoggerFactory.getLogger(Utilities.class);
            logger.info("El reclamo será atendido en el nivel 4 por " + getEmail());
            Utilities.sendMail(getEmail(), claim.getTitle(), claim.getDescription());
            claim.setAttended(true);
            return true;

        } else {
            System.out.println("No se puede atender. El reclamo está sin clasificar");
            return false;
        }

    }

}
