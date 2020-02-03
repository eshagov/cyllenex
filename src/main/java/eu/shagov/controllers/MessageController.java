package eu.shagov.controllers;

import eu.shagov.exceptions.ResourceNotFoundException;
import io.swagger.annotations.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("messages")
@Secured("ROLE_ADMIN")
@ApiModel(value="Messages models", description="Messages model for the documentation")
public class MessageController {

    @GetMapping("/simple")
    @ApiOperation(value = "Finds Pets by status",
            notes = "Multiple status values can be provided with comma seperated strings",
            response = String.class,
            responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid ID supplied",
                    responseHeaders = @ResponseHeader(name = "X-Rack-Cache", description = "Explains whether or not a cache was used", response = Boolean.class)),
            @ApiResponse(code = 404, message = "Message not found") })
    public ResponseEntity<String> getMessage(
                @RequestParam("name") String fullName) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Company-Header", "cyllenex.com");

        if (fullName.length() < 3) {
            throw new ResourceNotFoundException("Less than 3 symbols");
        }

        String bodyContent = "Response from simple for " + fullName;

        return new ResponseEntity<>(bodyContent, HttpStatus.OK);
    }
}
