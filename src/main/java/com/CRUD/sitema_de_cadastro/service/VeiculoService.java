package com.CRUD.sitema_de_cadastro.service;

import com.CRUD.sitema_de_cadastro.entity.Veiculo;
import com.CRUD.sitema_de_cadastro.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Data
public class VeiculoService {
    private VeiculoRepository veiculoRepository;

    public Veiculo salvarVeiculo(Veiculo veiculo) throws Exception{
        Optional<Veiculo> verificarPlaca = veiculoRepository.findByplaca(veiculo.getPlaca());

        if (verificarPlaca.isEmpty()){
          return veiculoRepository.save(veiculo);
        }else {
        throw new RuntimeException("Veículo já cadastrado");
        }
    }

    public Veiculo editarCliente (Veiculo veiculo, Long id) throws Exception{

       if (veiculo.getPlaca().equals(veiculo)){
         return   veiculoRepository.save(veiculo);
       }else {
           throw new Exception("Placa não cadastrada");
       }

    }
    public Optional<Veiculo> pesquisarVeiculoPorPlaca(String placa) throws Exception{
        Veiculo veiculo = new Veiculo();
        String validarPlaca = veiculo.getPlaca();
        if (validarPlaca.equals(placa)){
            return veiculoRepository.findByplaca(placa);
        }else {
            throw new RuntimeException("Placa não existe");
        }

    }
    public void deletarVeiculo(Veiculo veiculo){
        veiculoRepository.delete(veiculo);
    }
}
