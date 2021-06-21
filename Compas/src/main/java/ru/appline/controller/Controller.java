package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Compas;
import ru.appline.logic.CompasModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {
    private static final CompasModel compasModel = CompasModel.getInstance();
    private static final AtomicInteger newId = new AtomicInteger(1);

    @PostMapping(value = "/createDegree", consumes = "application/json")
    public Map<String,String> createDegree(@RequestBody Map<String,Integer> Degree) {
        return compasModel.setDegree(Degree.get("Degree"));
    }

    @PostMapping(value = "/setDegree", consumes = "application/json")
    public void setDegree(@RequestBody Map<String,String> map) {

        String[] north = map.get("North").split("-");
        String[] east = map.get("East").split("-");
        String[] es = map.get("East-South").split("-");
        String[] south = map.get("South").split("-");
        String[] sw = map.get("South-West").split("-");
        String[] west = map.get("West").split("-");
        String[] wn = map.get("West-North").split("-");

        compasModel.setSides(
                Integer.parseInt(north[0]),
                Integer.parseInt(north[1]),
                Integer.parseInt(east[0]),
                Integer.parseInt(east[1]),
                Integer.parseInt(es[0]),
                Integer.parseInt(es[1]),
                Integer.parseInt(south[0]),
                Integer.parseInt(south[1]),
                Integer.parseInt(sw[0]),
                Integer.parseInt(sw[1]),
                Integer.parseInt(west[0]),
                Integer.parseInt(west[1]),
                Integer.parseInt(wn[0]),
                Integer.parseInt(wn[1])
        );
    }

//    @GetMapping(value = "/getAll", produces = "application/json")
//    public Map<Integer, Compas> getAll(){
//
//        return compasModel.getAll();
//    }

//    @GetMapping(value = "/setDegree", consumes = "application/json", produces = "application/json")
//    public Compas getPet(@RequestBody Map<String,Integer> id){
//
//        return petModel.getFromList(id.get("id"));
//    }

//    @PostMapping(value = "/getSide", consumes = "application/json", produces = "application/json")
//    public Compas getSide(@RequestBody Map<String,Integer> id){
//            return (Compas) compasModel.getFromList(id.get("id"));
//    }

//    @DeleteMapping(value = "/deletePet", consumes = "application/json")
//    public String deletePet(@RequestBody Map<String,Integer> id) {
//        compasModel.delete(id.get("id"));
//
//        return "Питомец удалён";
//    }

//    @PutMapping(value = "/putPet", consumes = "application/json")
//    public String putPet(@RequestBody changePet pet) {
//        petModel.add(pet.getId(), pet);
//        return "Питомец изменён";
//    }
}
