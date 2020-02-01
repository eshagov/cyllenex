package eu.shagov.controllers;

import eu.shagov.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("messages")
public class MessageController {

    @GetMapping("/simple")
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
