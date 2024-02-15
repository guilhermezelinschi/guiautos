package br.com.guiautos.controller;


import br.com.guiautos.model.Carro;
import br.com.guiautos.repositories.CarroRepository;
import br.com.guiautos.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carro")
public class CarroController {


    @Autowired
    CarroService carroService;

    @PostMapping("/iniciar")
    public ResponseEntity<String> start(@RequestBody List<Carro> carros) {

        return ResponseEntity.ok(carroService.iniciar(carros));

    }

    @PostMapping("/adicionarcarro")
    public ResponseEntity<String> addCarro(@RequestBody Carro carro) {


        String mensagem = carroService.addCarro(carro);
        return ResponseEntity.ok(mensagem);
    }

    @GetMapping("/buscarcarro/{id}")
    public ResponseEntity<Optional<Carro>> getCarro(@PathVariable Long id) {

        Optional<Carro> carro = carroService.getCarro(id);
        return ResponseEntity.ok(carro);
    }

    @GetMapping("/buscarcarros")
    public List<Carro> getCarros() {
        return carroService.getCarros();
    }

    @GetMapping("/buscarcarropormarca/{marca}")
    public ResponseEntity<List<Carro>> getCarroPorMarca(@PathVariable String marca) {

        return ResponseEntity.ok(carroService.getCarroPorMarca(marca));


    }

    @GetMapping("/buscarcarroporpreco/{param1}/{param2}")
    public ResponseEntity<List<Carro>> getCarroPorPreco(@PathVariable Double param1, @PathVariable Double param2) {


        return ResponseEntity.ok(carroService.getCarroPorPreco(param1, param2));
    }


    @PutMapping("/atualizarcorcarro/{id}")
    public ResponseEntity<String> updateCorCarro(@PathVariable Long id) {
        return ResponseEntity.ok(carroService.atualizaCorCarro(id));
    }

    @PutMapping("/atualizarcarro")
    public ResponseEntity<String> updateCarro(@RequestBody Carro carro) {
        return ResponseEntity.ok(carroService.atualizaCarro(carro));
    }

    @DeleteMapping("/deletarcarro/{id}")
    public ResponseEntity<String> deleteCarro(@PathVariable Long id) {


        return ResponseEntity.ok(carroService.deletaCarro(id));
    }


}
