package hu.unideb.webdev.controller;

import hu.unideb.webdev.controller.dto.TeamsDto;
import hu.unideb.webdev.exceptions.*;
import hu.unideb.webdev.model.Teams;
import hu.unideb.webdev.service.TeamsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "team")
public class TeamsController {
    private final TeamsService service;

    @GetMapping("/all")
    public Collection<TeamsDto> getAllTeams(){
        return service.getAllTeams().stream()
                .map(model -> new TeamsDto(
                        model.getId(),
                        model.getName()
                ))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void saveTeam(@RequestBody final TeamsDto teamsDto){
        service.recordTeam(new Teams(
                teamsDto.getId(),
                teamsDto.getName()
            ));
    }

    @PutMapping
    public void updateTeam(@RequestBody final TeamsDto teamsDto){
        try {
            service.updateTeam(new Teams(
                    teamsDto.getId(),
                    teamsDto.getName()
            ));
        } catch (UnknownTeamException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable(value = "id") final int id){
        try {
            service.deleteTeam(id);
        } catch (UnknownTeamException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
