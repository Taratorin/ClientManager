package ru.unibell.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.unibell.dto.ClientContactDto;
import ru.unibell.dto.ClientDto;
import ru.unibell.dto.ClientFullDto;
import ru.unibell.model.Type;
import ru.unibell.server.ClientServer;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/clients")
@RequiredArgsConstructor
@Slf4j
@Validated
public class Controller {
    private final ClientServer server;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ClientFullDto createClient(@Valid @RequestBody ClientDto clientDto,
                                      HttpServletRequest request) {
        log.info("Получен запрос {} — добавление нового клиента", request.getRequestURI());
        return server.saveClient(clientDto);
    }

    @PatchMapping("/{clientId}")
    public ClientFullDto patchClients(@RequestParam(defaultValue = "0") String phone,
                                      @RequestParam(defaultValue = "0") String email,
                                      @PathVariable long clientId,
                                      HttpServletRequest request) {
        log.info("Получен запрос {} — добавление контактов клиента", request.getRequestURI());
        return server.patchClient(phone, email, clientId);
    }

    @GetMapping()
    public List<ClientFullDto> findClients(HttpServletRequest request) {
        log.info("Получен запрос {} — получение списка клиентов", request.getRequestURI());
        return server.findClients();
    }

    @GetMapping("/{clientId}")
    public ClientFullDto findClient(@PathVariable long clientId, HttpServletRequest request) {
        log.info("Получен запрос {} — получение списка контактов заданного клиента", request.getRequestURI());
        return server.findClient(clientId);
    }

    @GetMapping("/{clientId}/contacts")
    public ClientContactDto findClientByContactType(@PathVariable long clientId, @RequestParam() Type type,
                                                    HttpServletRequest request) {
        log.info("Получен запрос {} — получение списка контактов клиента" +
                " заданного типа (почта или телефон)", request.getRequestURI());
        return server.findClientByContactType(clientId, type);
    }
}