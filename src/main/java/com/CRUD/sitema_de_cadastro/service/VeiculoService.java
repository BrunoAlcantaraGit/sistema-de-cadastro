package com.CRUD.sitema_de_cadastro.service;

import com.CRUD.sitema_de_cadastro.controller.ClienteController;
import com.CRUD.sitema_de_cadastro.entity.Veiculo;
import com.CRUD.sitema_de_cadastro.repository.VeiculoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
@Transactional
    public Veiculo editarVeiculo (Long id, Veiculo veiculo) throws Exception {

        Optional<Veiculo> validarPlaca = veiculoRepository.findByplaca(veiculo.getPlaca());

        if (validarPlaca.isPresent()) {
          Veiculo veiculoatualizado = validarPlaca.get();
           veiculoatualizado.setPlaca(veiculo.getPlaca());
           veiculoatualizado.setRenavan(veiculo.getRenavan());
           veiculoatualizado.setTipoRodado(veiculo.getTipoRodado());
           return veiculo;
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

    @Transactional
    public void deletarPorId(Long id) throws Exception{
        Optional<Veiculo> validarPlaca = veiculoRepository.findById(id);
        if(validarPlaca.isPresent()){
            veiculoRepository.deleteByid(id);
        }else {
            throw new Exception("Veículo inexitente");
        }
    }

    public List<Veiculo> listarVeiculos () throws Exception{
        List<Veiculo> veiculos = veiculoRepository.findAll();
        List<Veiculo> listarVeiculos = new ArrayList<>();
        if (!veiculos.isEmpty()) {
            for (Veiculo l : veiculos) {
                listarVeiculos.add(l);
            }
            return listarVeiculos;
        }else {
            throw new Exception("Não existe veículos a serem listados");
        }
    }

    public Optional<Veiculo>busacarVeiculoID(Long id) throws  Exception{
        Optional<Veiculo>VeiricarIdVeiculo = veiculoRepository.findById(id);
        if (VeiricarIdVeiculo.isPresent()){
            return veiculoRepository.findById(id);
        }else {
            throw new Exception("Veiculo não existe");
        }
    }

}

