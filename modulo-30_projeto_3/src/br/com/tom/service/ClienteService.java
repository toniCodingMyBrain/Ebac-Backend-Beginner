package br.com.tom.service;

import br.com.tom.dao.ClienteDAO;
import br.com.tom.dao.IClienteDAO;
import br.com.tom.domain.Cliente;
import br.com.tom.exceptions.TipoChaveNaoEncontradaException;

public class ClienteService implements IClienteService {
    private IClienteDAO clienteDao;

    public ClienteService(IClienteDAO clienteDao){
        this.clienteDao = clienteDao;
    }

    @Override
    public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
       return clienteDao.cadastrar(cliente);
    }

    @Override
    public Cliente buscarPorCpf(Long cpf) {
        return clienteDao.consultar(cpf);
    }

    @Override
    public void excluir(Long cpf) {
        clienteDao.excluir(cpf);
    }

    @Override
    public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        clienteDao.alterar(cliente);
    }
}
