package com.steampi.steam_api.controller;

import java.util.List;

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
	public ResponseEntity<String> putGame(@RequestBody GameDTO game) {
		this.gameService.putGame(game);
        
        return ResponseEntity.ok("Game alterado");
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
	
	@GetMapping(value = "/genre/type/{id}")
	@ResponseBody
    public ResponseEntity<GenreDTO> getGenre(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(this.GenreService.getGenre(id));
    }
	
	@GetMapping(value = "/genre/{code}")
	@ResponseBody
    public ResponseEntity<List<GenreDTO>> getAllGenre(@PathVariable("code") Integer code) {

        return ResponseEntity.ok(this.GenreService.getAllGenre(code));
    }
	
	
	@PutMapping(produces = "application/json", value = "/genre")
	@ResponseBody
	public ResponseEntity<String> putGenre(@RequestBody GenreDTO genreDto){
		GenreService.putGenre(genreDto);
		return ResponseEntity.ok("Genero Alterado");
	}
}
