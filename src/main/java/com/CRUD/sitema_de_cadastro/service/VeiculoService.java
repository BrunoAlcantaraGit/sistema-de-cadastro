package com.CRUD.sitema_de_cadastro.service;

import com.CRUD.sitema_de_cadastro.entity.Veiculo;
import com.CRUD.sitema_de_cadastro.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Data
public class VeiculoService {
    private VeiculoRepository veiculoRepository;

    public Veiculo salvarVeiculo(Veiculo veiculo) throws Exception{
        if (veiculo.getPlaca().isEmpty()){
          return veiculoRepository.save(veiculo);
        }else {
        throw new RuntimeException("Veículo já cadastrado");
        }
    }

    public Veiculo editarCliente (Veiculo veiculo, Long id){
        return veiculo;
    }
}
