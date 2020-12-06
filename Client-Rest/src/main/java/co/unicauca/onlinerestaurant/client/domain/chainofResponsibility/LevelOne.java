package co.unicauca.onlinerestaurant.client.domain.chainofResponsibility;

import co.unicauca.onlinerestaurant.client.infra.Utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Nivel de atención 1 de reclamos
 *
 * @author ximena Gallego
 */
public class LevelOne extends ClaimHandler {

    public LevelOne(String email) {
        super(email);
    }

    @Override
    public boolean attend(Claim claim) {
        if (claim.getType().equals(TypeEnum.BASIC)) {
            Logger logger = LoggerFactory.getLogger(Utilities.class);
            logger.info("El reclamo será atendido en el nivel 1 por " + getEmail());
            Utilities.sendMail(getEmail(), claim.getTitle(), claim.getDescription());

            claim.setAttended(true);
            return true;

        } else {
            return getNextHandler().attend(claim);
        }
    }

}
