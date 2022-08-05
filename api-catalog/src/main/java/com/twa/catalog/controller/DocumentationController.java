package com.twa.catalog.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Hidden
@Controller
@RequestMapping("documentation")
public class DocumentationController {

    @ResponseBody
    @GetMapping
    public void redirectToDocumentation(HttpServletResponse response) {
        try {
            response.sendRedirect("swagger-ui.html");
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder("UNEXPECTED ERROR: ");
            if (e.getMessage() != null) {
                sb.append(e.getMessage());
            }
            //TODO DO SOMETHING
        }
    }
}
