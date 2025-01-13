package techchallenge.fiap.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import techchallenge.fiap.dtos.usuario.*;
import techchallenge.fiap.utils.handlers.GlobalExceptionHandler;

import java.util.List;
import java.util.Map;

public interface IUsuarioController {

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK")
    })
    @Operation(summary = "Lista todos os usuários")
    public ResponseEntity<Page<UsuarioResponseDTO>> listarTudo(Pageable pageable);

    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Created", content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = UsuarioResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = GlobalExceptionHandler.ErrorResponseWithErrorsMapDTO.class))),
    })
    @Operation(summary = "Cria um usuário")
    public ResponseEntity<UsuarioResponseDTO> criar(@RequestBody @Valid UsuarioCreateDTO usuarioDTO);

    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Created"),
        @ApiResponse(responseCode = "204", description = "No Content")
    })
    @Operation(summary = "Atualiza dados de um usuário a partir do ID")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioUpdateDTO updateDTO);

    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Created"),
        @ApiResponse(responseCode = "204", description = "No Content")
    })
    @Operation(summary = "Atualiza senha de um usuário a partir do ID")
    public ResponseEntity atualizarSenha(@PathVariable Long id, @RequestBody @Valid UsuarioTrocaDeSenhaDTO trocaDeSenhaDTO);

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK"),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = GlobalExceptionHandler.ErrorResponseWithErrorsMapDTO.class))),
    })
    @Operation(summary = "Realiza login do usuário")
    public ResponseEntity<Map<String, String>> fazerLogin(@RequestBody @Valid UsuarioLoginDTO usuarioLoginDTO);


}
