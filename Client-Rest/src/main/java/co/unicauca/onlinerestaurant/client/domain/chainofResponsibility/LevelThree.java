package co.unicauca.onlinerestaurant.client.domain.chainofResponsibility;

import co.unicauca.onlinerestaurant.client.infra.Utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Nivel de atención 2 de recamos
 *
 * @author Ximena Gallego
 */
public class LevelThree extends ClaimHandler {

    public LevelThree(String email) {
        super(email);
    }

    @Override
    public boolean attend(Claim claim) {
        if (claim.getType().equals(TypeEnum.HIGH)) {
            Logger logger = LoggerFactory.getLogger(Utilities.class);
            logger.info("El reclamo será atendido en el nivel 3 por " + getEmail());
            Utilities.sendMail(getEmail(), claim.getTitle(), claim.getDescription());
            claim.setAttended(true);
            return true;

        } else {
//            System.out.println("No se puede atender. El reclamo está sin clasificar");
//            return false;
            return getNextHandler().attend(claim);
        }
    }

}
