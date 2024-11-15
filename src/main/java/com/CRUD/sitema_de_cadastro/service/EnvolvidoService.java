package com.CRUD.sitema_de_cadastro.service;

import com.CRUD.sitema_de_cadastro.component.FormatarCPF;
import com.CRUD.sitema_de_cadastro.controller.ClienteController;
import com.CRUD.sitema_de_cadastro.entity.Envolvidos;
import com.CRUD.sitema_de_cadastro.repository.EnvolvidosRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@AllArgsConstructor
@Data
public class EnvolvidoService {
    EnvolvidosRepository envolvidoRepository;
    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);
    FormatarCPF formatarCPF = new FormatarCPF();

    public Envolvidos salvarEnvolvido(Envolvidos envolvidos) throws Exception {
        logger.info("Dados recebidos do envolvidos: {}", envolvidos);
        Optional<Envolvidos> verificarCPF = envolvidoRepository.findBydocumento(envolvidos.getDocumento());
        if (verificarCPF.isEmpty() ){
            envolvidos.setDocumento(formatarCPF.formatarCPF(envolvidos.getDocumento()));
          return   envolvidoRepository.save(envolvidos);
        }else {
            throw new RuntimeException("CPF Já cadastrado");
        }
    }

    @Transactional
    public Envolvidos editarEnvolvido(Envolvidos envolvido, Long id) throws Exception {
        Optional<Envolvidos> atualizarEnvolvido = envolvidoRepository.findById(id);

        if (atualizarEnvolvido.isPresent()){
            Envolvidos envolvidos = atualizarEnvolvido.get();

            envolvidos.setDocumento(envolvido.getDocumento());
            envolvidos.setNome(envolvido.getNome());
            envolvidos.setEndereco(envolvido.getEndereco());
            envolvidos.setContato(envolvido.getContato());
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

    public Optional <Envolvidos> listarPorId(Long id) throws Exception{
        Optional<Envolvidos>verificarID = envolvidoRepository.findById(id);
        if(verificarID.isPresent()){
            return verificarID;
        }else {
            throw new Exception("Envolvido não existe");
        }

    }
    public List<Envolvidos> ListarTudo() throws  Exception{
       List<Envolvidos> envolvidos = envolvidoRepository.findAll();
       List<Envolvidos>envolvidosList = new ArrayList<>();

        if (!envolvidos.isEmpty()){
            for (Envolvidos e: envolvidos){
                envolvidosList.add(e);
            }
        return envolvidos;
        }else {
            throw new Exception("não existe cliente a serem listado");
        }
    }
    @Transactional
    public void deletarPorId(Long id) throws Exception{
        Optional<Envolvidos>verificarID = envolvidoRepository.findById(id);
        if (verificarID.isPresent()){
            envolvidoRepository.deleteById(id);
        }else {
            throw new Exception("Cliente inexitente");
        }
    }
}