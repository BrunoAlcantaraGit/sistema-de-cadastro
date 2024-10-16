package com.CRUD.sitema_de_cadastro.service;

import com.CRUD.sitema_de_cadastro.entity.Veiculo;
import com.CRUD.sitema_de_cadastro.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Data
public class VeiculoService {

    VeiculoRepository veiculoRepository;

    public Veiculo salvarVeiculo(Veiculo veiculo) throws Exception {
Optional<Veiculo> validarVeículo = veiculoRepository.findByplaca(veiculo.getPlaca());
           if (validarVeículo.isEmpty()){
               return veiculoRepository.save(veiculo);
           }else {
               throw new RuntimeException("Placa já cadastrada");
           }

        }

    public Veiculo editarVeiculo (Veiculo veiculo, Long id) throws Exception{

        Optional<Veiculo> validarPlaca = veiculoRepository.findByplaca(veiculo.getPlaca());

       if (validarPlaca.equals(veiculo.getPlaca())){
         return veiculoRepository.save(veiculo);
       }else {
           throw new Exception("Placa não cadastrada");
       }

    }
    public Optional<Veiculo> pesquisarVeiculoPorPlaca(String placa) throws Exception{
        Optional<Veiculo>validarPlaca = veiculoRepository.findByplaca(placa);
        if (validarPlaca.isPresent()){
            return veiculoRepository.findByplaca(placa);
        }else {
            throw new RuntimeException("Placa não existe");
        }

    }
   /* public void deletarVeiculo(String placa){
        veiculoRepository.findByplaca(placa);
    }*/
    }

