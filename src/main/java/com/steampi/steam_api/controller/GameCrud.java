package com.steampi.steam_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.steampi.steam_api.model.Game;
import com.steampi.steam_api.model.Genre;

@RequestMapping("/game")
@Controller
public class GameCrud {

	@GetMapping(value = "/{id}")
	@ResponseBody
    public ResponseEntity<Game> getGame(@RequestBody Game game) {
        System.out.println(game);
        
        return ResponseEntity.ok(game);
    }
	
	@PostMapping(produces = "application/json")
	@ResponseBody
    public ResponseEntity<Game> postGame(@RequestBody Game game) {
        System.out.println(game);
        
        return ResponseEntity.ok(game);
    }

	@PutMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<Game> putGame(@RequestBody Game game) {
        System.out.println(game);
        
        return ResponseEntity.ok(game);
    }

	@DeleteMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<Game> deleteGame(@RequestBody Game game) {
        System.out.println(game);
        
        return ResponseEntity.ok(game);
    }
}
