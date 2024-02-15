package br.com.guiautos.services;

import br.com.guiautos.model.Carro;
import br.com.guiautos.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    CarroRepository carroRepository;

    public String iniciar(List<Carro> carros) {
        carroRepository.saveAll(carros);
        return "Iniciado";
    }

    public String addCarro(Carro carro) {
        String mensagemRetorno = "";
        try {
            carroRepository.save(carro);
            mensagemRetorno = "Carro adicionado com sucesso";
        } catch (Exception e) {
            mensagemRetorno = "Ocorreu um erro";
        }

        return mensagemRetorno;
    }

    public Optional<Carro> getCarro(Long id) {

        Optional<Carro> carro = carroRepository.findById(id);

        return carro;
    }

    public List<Carro> getCarroPorPreco(Double param1, Double param2){

        return carroRepository.findByPrecoBetween(param1, param2);
    }

    public List<Carro> getCarroPorMarca(String marca) {

        return carroRepository.findByMarca(marca);
    }


    public List<Carro> getCarros() {
        return carroRepository.findAll();
    }

    public String atualizaCorCarro(Long id) {

        String mensagemRetorno = "";
        Carro carro = carroRepository.findById(id).orElse(new Carro());

        if (carro.getId() > 0) {
            carro.setCor("laranja florescente");
            carroRepository.save(carro);
            mensagemRetorno = "Carro alterado com sucesso";
        } else {
            mensagemRetorno = "Ocorreu um erro o carro não foi alterado";
        }

        return mensagemRetorno;


    }


    public String atualizaCarro(Carro carro) {

        String mensagemRetorno = "";


        if (carro.getId() > 0) {

            carroRepository.save(carro);
            mensagemRetorno = "Carro alterado com sucesso";
        } else {
            mensagemRetorno = "Ocorreu um erro o carro não foi alterado";
        }

        return mensagemRetorno;


    }

    public String deletaCarro(Long id) {

        String mensagemRetorno = "";
        Carro carro = carroRepository.findById(id).orElse(new Carro());

        if (carro.getId() > 0) {
            carroRepository.delete(carro);
            mensagemRetorno = "Carro removido com sucesso";
        } else {
            mensagemRetorno = "Ocorreu um erro o carro não foi removido";
        }

        return mensagemRetorno;


    }
}