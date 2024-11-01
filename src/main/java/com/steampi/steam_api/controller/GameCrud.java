package com.steampi.steam_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.steampi.steam_api.service.GameService;
import com.steampi.steam_api.service.GenreService;

import dto.GameDTO;
import dto.GenreDTO;

@RequestMapping("/steamapi")
@Controller
public class GameCrud {
	
	@Autowired
	private GameService gameService;
	@Autowired
	private GenreService GenreService;
	
	@GetMapping(value = "/game/{id}")
	@ResponseBody
    public ResponseEntity<GameDTO> getGame(@PathVariable("id") Integer id) {
		GameDTO gamedto = this.gameService.getGame(id);
        return ResponseEntity.ok(gamedto);
    }
	
	@PostMapping(produces = "application/json", value = "/game")
	@ResponseBody
    public ResponseEntity<GameDTO> postGame(@RequestBody GameDTO game) {
		this.gameService.postGame(game);
        return ResponseEntity.ok(game);
    }

	@PutMapping(produces = "application/json", value = "/game")
	@ResponseBody
	public ResponseEntity<GameDTO> putGame(@RequestBody GameDTO game) {
        System.out.println(game);
        
        return ResponseEntity.ok(game);
    }

	@DeleteMapping(value = "/game/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteGame(@PathVariable("id") Integer code) {
        this.gameService.deleteGame(code);
        
        return ResponseEntity.ok("Game deletado");
    }
	
	@PostMapping(produces = "application/json", value = "/genre")
    public ResponseEntity<String> postGenre(@RequestBody GenreDTO genre) {        
        
		this.GenreService.postGenre(genre.getName());
        return ResponseEntity.ok("genero salvo");
    }
	
	@GetMapping(value = "/genre/{id}")
	@ResponseBody
    public ResponseEntity<GenreDTO> getGenre( @PathVariable("id") String id) {
//		this.gameService.getGame(String.valueOf(game.getId()));

        return ResponseEntity.ok(this.GenreService.getGenre(id));
    }
}
