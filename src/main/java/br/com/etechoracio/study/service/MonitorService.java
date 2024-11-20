package br.com.etechoracio.study.service;

import br.com.etechoracio.study.entity.Monitor;
import br.com.etechoracio.study.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitorService {

    @Autowired
    private MonitorRepository repository;

    public Monitor cadastrarMonitor(Monitor monitor) {
        var emailExistente = repository.findByEmail(monitor.getEmail());
        if (emailExistente.isPresent() && !emailExistente.get().getId().equals(monitor.getId())) {
            throw new RuntimeException("Já existe um monitor cadastrado com este email");
        }

        var telefoneExistente = repository.findByTelefone(monitor.getTelefone());
        if (telefoneExistente.isPresent() && !telefoneExistente.get().getId().equals(monitor.getId())) {
            throw new RuntimeException("Já existe um monitor cadastrado com este telefone");
        }

        return repository.save(monitor);
    }
}
