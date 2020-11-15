package co.unicauca.menu.presentation.rest;

import co.unicauca.common.domain.entity.User;
import co.unicauca.menu.domain.service.MenuService;
import co.unicauca.menu.infra.DomainErrors;
import co.unicauca.menu.infra.JsonResponse;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * API REST
 *
 * @author Camilo Otaya
 */
@Stateless
@Path("/menus")
public class MenuController {

}
