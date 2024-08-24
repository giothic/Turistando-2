package turistando.turistandospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import turistando.turistandospring.Exception.Excecao;
import turistando.turistandospring.model.AbastecimentoModel;
import turistando.turistandospring.service.AbastecimentoService;

import java.util.List;

@RestController
@RequestMapping("/abastecimento")
public class AbastecimentoController {

    @Autowired
    private AbastecimentoService abastecimentoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<AbastecimentoModel> cadastrarAbastecimento(@RequestBody AbastecimentoModel abastecimento) {
        AbastecimentoModel savedAbastecimento = abastecimentoService.createAbastecimento(abastecimento);
        return new ResponseEntity<>(savedAbastecimento, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AbastecimentoModel>> listarAbastecimentos() {
        List<AbastecimentoModel> abastecimentos = abastecimentoService.getAllAbastecimentos();
        return new ResponseEntity<>(abastecimentos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbastecimentoModel> obterAbastecimento(@PathVariable Long id) {
        try {
            AbastecimentoModel abastecimento = abastecimentoService.getAbastecimentoById(id);
            return new ResponseEntity<>(abastecimento, HttpStatus.OK);
        } catch (Excecao e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<AbastecimentoModel> modificarAbastecimento(@PathVariable Long id, @RequestBody AbastecimentoModel abastecimento) {
        try {
            AbastecimentoModel updatedAbastecimento = abastecimentoService.updateAbastecimento(id, abastecimento);
            return new ResponseEntity<>(updatedAbastecimento, HttpStatus.OK);
        } catch (Excecao e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<Void> apagarAbastecimento(@PathVariable Long id) {
        boolean deleted = abastecimentoService.deleteAbastecimento(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

