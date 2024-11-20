package br.com.etechoracio.study.controller;

import br.com.etechoracio.study.entity.Monitor;
import br.com.etechoracio.study.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/monitores")
public class MonitorController {

    @Autowired
    private MonitorService service;

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Monitor monitor) {
        try {
            Monitor novoMonitor = service.cadastrarMonitor(monitor);
            return ResponseEntity.status(HttpStatus.CREATED).body("Monitor cadastrado com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
