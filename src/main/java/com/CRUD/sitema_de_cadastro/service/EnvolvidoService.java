package com.CRUD.sitema_de_cadastro.service;

import com.CRUD.sitema_de_cadastro.component.FormatarCPF;
import com.CRUD.sitema_de_cadastro.entity.Envolvidos;
import com.CRUD.sitema_de_cadastro.repository.EnvolvidosRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@AllArgsConstructor
@Data
public class EnvolvidoService {
    EnvolvidosRepository envolvidoRepository;
    public Envolvidos salvarEnvolvido(Envolvidos envolvidos) throws Exception {
        FormatarCPF formatarCPF = new FormatarCPF();
        Optional<Envolvidos> verificarCPF = envolvidoRepository.findById(envolvidos.getId());
        if (verificarCPF.isEmpty()){
            envolvidos.setDocumento(formatarCPF.formatarCPF(envolvidos.getDocumento()));
          return   envolvidoRepository.save(envolvidos);
        }else {
            throw new RuntimeException("CPF Já cadastrado");
        }
    }

    public Envolvidos editarEnvolvido(Envolvidos envolvidos, Long id) throws Exception {
        Optional<Envolvidos> atualizarEnvolvido = envolvidoRepository.findById(id);
        if (atualizarEnvolvido.isPresent()){
            envolvidos.setDocumento(atualizarEnvolvido.get().getDocumento());
            envolvidos.setNome(atualizarEnvolvido.get().getNome());
            envolvidos.setEndereco(atualizarEnvolvido.get().getEndereco());
            envolvidos.setContato(atualizarEnvolvido.get().getContato());
            return envolvidos;
        }else {
            throw new RuntimeException("CPF Já cadastrado");
        }
    }
    public List<Envolvidos> listarTudo()throws Exception{
     List<Envolvidos> verificarEnvolvido = envolvidoRepository.findAll();
     if (!verificarEnvolvido.isEmpty()){
         return verificarEnvolvido;
     }else {
         throw new Exception("Não existe clientes a serem listados");
     }

    }

    public Optional <Envolvidos> listar(Long id){

    }


}