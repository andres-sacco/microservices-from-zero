package com.twa.catalog.controller.resources;

import com.twa.catalog.dto.CountryDTO;
import com.twa.catalog.dto.ErrorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Country", description = "Operations about the country entity")
@RequestMapping("/country")
public interface CountryResource {

    @Operation(description = "Get the information about one country", responses = {
            @ApiResponse(responseCode = "200", description = "Return the information of one country",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = CountryDTO.class))),

            @ApiResponse(responseCode = "404", description = "Country not found",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorDTO.class))) },
            parameters = {
                    @Parameter(in = ParameterIn.PATH, name = "id", description = "Id of the country to search", example = "1")
            }
    )
    @GetMapping("/{id}")
    ResponseEntity<CountryDTO> get(@PathVariable Long id);

    @Operation(description = "Create one country", responses = {
            @ApiResponse(responseCode = "200", description = "Create one country",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = CountryDTO.class))),

            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorDTO.class))) },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(examples =
            @ExampleObject(name = "Country", summary = "Example country to create", value = "{\"code\": \"Tes\", \"description\": \"Test\" }")))
    )
    @PostMapping
    ResponseEntity<CountryDTO> save(@RequestBody @Validated CountryDTO country);

    @Operation(description = "Update one country", responses = {
            @ApiResponse(responseCode = "200", description = "Update one country",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = CountryDTO.class))),

            @ApiResponse(responseCode = "404", description = "Country not found",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorDTO.class))) },
            parameters = {
                    @Parameter(in = ParameterIn.PATH, name = "id", description = "Id of the country to update", example = "1")
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(examples =
            @ExampleObject(name = "Country", summary = "Example country to update", value = "{\"id\": 1, \"code\": \"Tes\", \"description\": \"Test\" }")))
    )
    @PutMapping("/{id}")
    ResponseEntity<CountryDTO> update(@PathVariable Long id, @RequestBody @Validated CountryDTO country);


    @Operation(description = "Delete one country", responses = {
            @ApiResponse(responseCode = "200", description = "Delete one country",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))),

            @ApiResponse(responseCode = "404", description = "Country not found",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorDTO.class))) },
            parameters = {
                    @Parameter(in = ParameterIn.PATH, name = "id", description = "Id of the country to delete", example = "1")
            }
    )
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
