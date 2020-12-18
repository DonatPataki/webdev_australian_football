package hu.unideb.webdev.controller;

import hu.unideb.webdev.controller.dto.MatchStatsDeleteDto;
import hu.unideb.webdev.controller.dto.MatchStatsDto;
import hu.unideb.webdev.exceptions.*;
import hu.unideb.webdev.model.MatchStats;
import hu.unideb.webdev.service.MatchStatsService;
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
@RequestMapping(path = "match/stat")
public class MatchStatsController {

    private final MatchStatsService service;

    @GetMapping("/all")
    public Collection<MatchStatsDto> getAllMatchStats(){
        return service.getAllMatchStats().stream()
                .map(model -> MatchStatsDto.builder()
                    .mid(model.getMid())
                    .pid(model.getPid())
                    .tid(model.getTid())
                    .loc(model.getLoc())
                    .KI(model.getKI())
                    .MK(model.getMK())
                    .HB(model.getHB())
                    .DI(model.getDI())
                    .GL(model.getGL())
                    .BH(model.getBH())
                    .HO(model.getHO())
                    .TK(model.getTK())
                    .RB(model.getRB())
                    .IF(model.getIF())
                    .CL(model.getCL())
                    .CG(model.getCG())
                    .FF(model.getFF())
                    .FA(model.getFA())
                    .BR(model.getBR())
                    .CP(model.getCP())
                    .UP(model.getUP())
                    .CM(model.getCM())
                    .MI(model.getMI())
                    .oneP(model.getOneP())
                    .BO(model.getBO())
                    .GA(model.getGA())
                    .PP(model.getPP())
                    .build())
                .collect(Collectors.toList());
    }

    @PostMapping
    public void saveMatchStat(@RequestBody MatchStatsDto matchStatsDto){
        try {
            service.recordMatchStat(new MatchStats(
                    matchStatsDto.getMid(),
                    matchStatsDto.getPid(),
                    matchStatsDto.getTid(),
                    matchStatsDto.getLoc(),
                    matchStatsDto.getKI(),
                    matchStatsDto.getMK(),
                    matchStatsDto.getHB(),
                    matchStatsDto.getDI(),
                    matchStatsDto.getGL(),
                    matchStatsDto.getBH(),
                    matchStatsDto.getHO(),
                    matchStatsDto.getTK(),
                    matchStatsDto.getRB(),
                    matchStatsDto.getIF(),
                    matchStatsDto.getCL(),
                    matchStatsDto.getCG(),
                    matchStatsDto.getFF(),
                    matchStatsDto.getFA(),
                    matchStatsDto.getBR(),
                    matchStatsDto.getCP(),
                    matchStatsDto.getUP(),
                    matchStatsDto.getCM(),
                    matchStatsDto.getMI(),
                    matchStatsDto.getOneP(),
                    matchStatsDto.getBO(),
                    matchStatsDto.getGA(),
                    matchStatsDto.getPP()
            ));
        } catch (UnknownMatchException | UnknownPlayerException | ExistingMatchStatException | UnknownTeamException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping
    public void updateMatchStat(@RequestBody MatchStatsDto matchStatsDto){
        try {
            service.updateMatchStat(new MatchStats(
                            matchStatsDto.getMid(),
                            matchStatsDto.getPid(),
                            matchStatsDto.getTid(),
                            matchStatsDto.getLoc(),
                            matchStatsDto.getKI(),
                            matchStatsDto.getMK(),
                            matchStatsDto.getHB(),
                            matchStatsDto.getDI(),
                            matchStatsDto.getGL(),
                            matchStatsDto.getBH(),
                            matchStatsDto.getHO(),
                            matchStatsDto.getTK(),
                            matchStatsDto.getRB(),
                            matchStatsDto.getIF(),
                            matchStatsDto.getCL(),
                            matchStatsDto.getCG(),
                            matchStatsDto.getFF(),
                            matchStatsDto.getFA(),
                            matchStatsDto.getBR(),
                            matchStatsDto.getCP(),
                            matchStatsDto.getUP(),
                            matchStatsDto.getCM(),
                            matchStatsDto.getMI(),
                            matchStatsDto.getOneP(),
                            matchStatsDto.getBO(),
                            matchStatsDto.getGA(),
                            matchStatsDto.getPP()

            ));
        } catch (UnknownMatchException | UnknownPlayerException | UnknownTeamException | UnknownMatchStatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping
    public void deleteMatchStat(@RequestBody MatchStatsDeleteDto matchStatsDto){
        try {
            service.deleteMatchStat(matchStatsDto.getMid(),matchStatsDto.getPid());
        } catch (UnknownPlayerException | UnknownMatchStatException | UnknownMatchException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
