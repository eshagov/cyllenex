package eu.shagov.controllers.global;

import java.util.Date;
import eu.shagov.controllers.global.entities.ErrorDetails;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<?> handleError() {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Incorrect request", "Incorrect request");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
