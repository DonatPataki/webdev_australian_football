package hu.unideb.webdev.controller;

import hu.unideb.webdev.controller.dto.PlayersDto;
import hu.unideb.webdev.exceptions.UnknownPlayerException;
import hu.unideb.webdev.model.Players;
import hu.unideb.webdev.service.PlayersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "player")
public class PlayersController {
    private final PlayersService service;

    @GetMapping("/all")
    public Collection<PlayersDto> getAllPlayers(){
        return service.getAllPlayers().stream()
                .map(model -> new PlayersDto(
                        model.getId(),
                        model.getDob().toString(),
                        model.getFirstName(),
                        model.getLastName(),
                        model.getHeight(),
                        model.getWeight()
                ))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void savePlayer(@RequestBody PlayersDto playersDto){
        service.recordPlayer(new Players(
                playersDto.getId(),
                Timestamp.valueOf(playersDto.getDob()),
                playersDto.getFirstName(),
                playersDto.getLastName(),
                playersDto.getHeight(),
                playersDto.getWeight()
            ));
    }

    @PutMapping
    public void updatePlayer(@RequestBody PlayersDto playersDto){
        try {
            service.updatePlayer(new Players(
                    playersDto.getId(),
                    Timestamp.valueOf(playersDto.getDob()),
                    playersDto.getFirstName(),
                    playersDto.getLastName(),
                    playersDto.getHeight(),
                    playersDto.getWeight()
            ));
        } catch (UnknownPlayerException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable(value = "id") final int id){
        try {
            service.deletePlayer(id);
        } catch (UnknownPlayerException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
