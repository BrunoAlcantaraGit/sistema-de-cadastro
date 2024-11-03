package com.CRUD.sitema_de_cadastro.service;

import com.CRUD.sitema_de_cadastro.controller.ClienteController;
import com.CRUD.sitema_de_cadastro.entity.Veiculo;
import com.CRUD.sitema_de_cadastro.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Data
public class VeiculoService {

    VeiculoRepository veiculoRepository;
    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    public Veiculo salvarVeiculo(Veiculo veiculo) throws Exception {
        logger.info("Dados recebidos do cliente: {}", veiculo);

        Optional<Veiculo> validarVeículo = veiculoRepository.findByplaca(veiculo.getPlaca());
        if (validarVeículo.isEmpty()) {
            return veiculoRepository.save(veiculo);
        } else {
            throw new RuntimeException("Placa já cadastrada");
        }

    }

    public Veiculo editarVeiculo(Veiculo veiculo, Long id) throws Exception {

        Optional<Veiculo> validarPlaca = veiculoRepository.findByplaca(veiculo.getPlaca());

        if (validarPlaca.equals(veiculo.getPlaca())) {
            return veiculoRepository.save(veiculo);
        } else {
            throw new Exception("Placa não cadastrada");
        }

    }

    public Optional<Veiculo> pesquisarVeiculoPorPlaca(String placa) throws Exception {
        Optional<Veiculo> validarPlaca = veiculoRepository.findByplaca(placa);
        if (validarPlaca.isPresent()) {
            return veiculoRepository.findByplaca(placa);
        } else {
            throw new RuntimeException("Placa não existe");
        }

    }
    public void deletarVeiculoPorId (Long id) throws Exception{
        Optional<Veiculo> validarPlaca = veiculoRepository.findById(id);
        if(validarPlaca.isPresent()){
            veiculoRepository.deleteByid(id);
        }else {
            throw new Exception("Veículo inexitente");
        }
    }
}

