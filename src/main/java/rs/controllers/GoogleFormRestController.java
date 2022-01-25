package rs.controllers;

import domain.models.GoogleForm;
import domain.services.GoogleFormService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import rs.mappers.GoogleFormMapper;
import rs.models.GoogleFormCreateDTO;
import rs.models.GoogleFormDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/form")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Form REST")
public class GoogleFormRestController {
    @Inject
    GoogleFormService googleFormService;

    @Inject
    GoogleFormMapper googleFormMapper;

    @GET
    @Path("/{id}")
    @Operation(
            operationId = "getFormById",
            description = "Get form by id."
    )
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The corresponding form resource",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = GoogleFormDTO.class))
            ),
            @APIResponse(
                    responseCode = "404",
                    description = "Form was not found"
            )
    })
    public Response getFormById(@PathParam("id") Long id) {
        if( id == null ){
            // send a 400
            throw new BadRequestException();
        }
        try {
            GoogleForm googleForm = googleFormService.findById(id);
            return Response
                    .status(Response.Status.OK)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .entity(googleFormMapper.mapToDTO(googleForm))
                    .build();
        }
        catch (Exception e){
            throw new NotFoundException("Form with given id doesn't exist");
        }
    }

    @GET
    @Path("/")
    @Operation(
            operationId = "getAllForms",
            description = "Get all forms."
    )
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "All forms.",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(type = SchemaType.ARRAY, implementation = GoogleFormDTO.class))
            ),
            @APIResponse(
                    responseCode = "404",
                    description = "Forms were not found"
            )
    })
    public Response getAllForms() {
        try {
            List <GoogleFormDTO> googleFormList = new ArrayList<>();
            for(GoogleForm form : googleFormService.findAll()){
                googleFormList.add(googleFormMapper.mapToDTO(form));
            }

            return Response
                    .status(Response.Status.OK)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .entity(googleFormList)
                    .build();
        }
        catch (Exception e){
            throw new NotFoundException("Forms were not found");
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Operation(
        operationId = "saveForm",
        description = "Create a form."
    )
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The created form resource",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = GoogleFormDTO.class))
            ),
            @APIResponse(
                    responseCode = "400",
                    description = "Bad request"
            )
    })
    public Response saveForm(@Valid GoogleFormCreateDTO googleFormCreateDTO) {
        try {
            GoogleForm googleForm = googleFormMapper.mapToEntity(googleFormCreateDTO);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(googleFormMapper.mapToDTO(googleFormService.create(googleForm)))
                    .build();
        }
        catch (Exception e){
            throw  new BadRequestException();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Operation(
            operationId = "deleteForm",
            description = "Delete form."
    )
    @APIResponses({
            @APIResponse(
                    responseCode = "404",
                    description = "Form was not found"
            )
    })
    public Response deleteForm(@PathParam("id") Long id) {
        if( id == null ){
            // send a 400
            throw new BadRequestException();
        }
        try {
            googleFormService.delete(id);
            return Response
                    .status(Response.Status.OK)
                    .build();
        }
        catch (Exception e){
            throw new NotFoundException("Form with given id doesn't exist");
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Operation(
            operationId = "updateForm",
            description = "Update form."
    )
    @APIResponses({
            @APIResponse(
                    responseCode = "404",
                    description = "Form was not found"
            )
    })
    public Response updateForm(@PathParam("id") Long id, @Valid GoogleFormCreateDTO googleFormCreateDTO){
        if( id == null ){
            // send a 400
            throw new BadRequestException();
        }
        try {
            GoogleForm googleForm = googleFormMapper.mapToEntity(googleFormCreateDTO);
            googleForm.setId(id);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(googleFormMapper.mapToDTO(googleFormService.update(googleForm)))
                    .build();
        }
        catch (Exception e){
            throw new NotFoundException("Form with given id doesn't exist");
        }
    }
}
