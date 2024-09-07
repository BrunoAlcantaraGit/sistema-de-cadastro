package com.CRUD.sitema_de_cadastro.service;

import com.CRUD.sitema_de_cadastro.component.FormatarCPF;
import com.CRUD.sitema_de_cadastro.entity.Cliente;
import com.CRUD.sitema_de_cadastro.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Optional;


@Service
@AllArgsConstructor
@Data

public class ClienteService {

 ClienteRepository clienteRepository;


    public Cliente salvarCliente(Cliente cliente) throws Exception{

        FormatarCPF formatarCPF = new FormatarCPF();
        String cpfFormatado = formatarCPF.formatarCPF(cliente.getDocumento());
        if(clienteRepository.findBydocumento(cpfFormatado).isEmpty()){
         cliente.setDocumento(cpfFormatado);
          return  clienteRepository.save(cliente);
        }else {
            throw new RuntimeException("CPF Já cadastrado");
        }

    }

    public Cliente editarCliente (Cliente cliente, Long id) throws Exception{
        Optional<Cliente>verificarID = clienteRepository.findById(id);

        if (clienteRepository.findBydocumento(cliente.getDocumento()).isPresent()&& verificarID.isPresent()){
         return  clienteRepository.save(cliente);
        }else {
            throw new RuntimeException("Cliente não cadastrado ou não existe");
        }
    }
}
