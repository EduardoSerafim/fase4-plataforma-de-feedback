package br.com.fiap.feedback.api.doc;
import br.com.fiap.feedback.api.dto.FeedbackResponseDTO;
import br.com.fiap.feedback.api.dto.PerfilDTO;
import br.com.fiap.feedback.api.dto.PerfilPermissaoDTO;
import br.com.fiap.feedback.api.dto.PerfilPermissaoInsert;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

@Tag(name = "Feedbacks", description = "Operações relacionadas ao recebimento e gestão das avaliações")
public interface FeedbackDocController {

//    @Operation(description = "Retorna uma lista contendo todos os perfis.")
//    ResponseEntity<List<FeedbackResponseDTO>> buscarTodos();
//
//    @Operation(description = "Buscar um perfil por ID.")
//    ResponseEntity<FeedbackResponseDTO> buscarPorId(Long id);
//
//    @Operation(description = "Cadastrar um novo perfil")
//    ResponseEntity<FeedbackResponseDTO> cadastrar(String novoPerfil);
//
//    @Operation(description = "Atualizar perfil existente.")
//    ResponseEntity<FeedbackResponseDTO> atualizar(Long id, String novaDescricao);
//
//    @Operation(description = "Deletar perfil.")
//    ResponseEntity<String> deletar(Long id);

}
