package com.CRUD.sitema_de_cadastro.service;

import com.CRUD.sitema_de_cadastro.component.FormatarCPF;
import com.CRUD.sitema_de_cadastro.entity.Cliente;
import com.CRUD.sitema_de_cadastro.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
@Data

public class ClienteService {

 ClienteRepository clienteRepository;
 @Autowired
 FormatarCPF formatarCPF;

    public Cliente salvarCliente(Cliente cliente) throws Exception{
        if(cliente.getDocumento().isEmpty()){
          return  clienteRepository.save(cliente);
        }else {
            throw new RuntimeException("CPF Já cadastrado");
        }

    }

    public Cliente editarCliente (Cliente cliente, Long id) throws Exception{
        Optional<Cliente>VerificarCPF = clienteRepository.findById(id);
        String cpfFormatado = formatarCPF.formatarCPF(cliente.getDocumento());
        if (VerificarCPF.isPresent()){
            cliente.setDocumento(cpfFormatado);
            return  clienteRepository.save(cliente);
        }else {
            throw new RuntimeException("Cliente não cadastrado ou não existe");
        }
    }

    public Optional<Cliente> buscarCliente(Long id)throws Exception{
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
            return  cliente;
        }else {
            throw new Exception("Cliente informado não existe");
        }
    }

    public List<Cliente>listarCliente() throws Exception{
        List<Cliente> listClientesretorno = clienteRepository.findAll();
        List<Cliente>clienteList = new ArrayList<>();
        if(!listClientesretorno.isEmpty()){
           for(Cliente clientes:listClientesretorno){
               clienteList.add(clientes);
           }
            return clienteList;
        }else {
            throw new Exception("não existe clientes Cadastrados");
        }
    }

    public void deletarId(Long id) throws Exception{
        Optional<Cliente> validarCliente = clienteRepository.findById(id);
        if(validarCliente.isPresent()){
         clienteRepository.deleteById(id);
      }else{
            throw new RuntimeException("Cliente não existe");
        }

    }

}
