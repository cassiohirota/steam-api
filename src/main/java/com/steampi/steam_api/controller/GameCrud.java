package com.steampi.steam_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.steampi.steam_api.model.Game;
import com.steampi.steam_api.model.Genre;

@RequestMapping("/game")
@Controller
public class GameCrud {

	@PostMapping(produces = "application/json")
	@ResponseBody
    public ResponseEntity<Game> postGame(@RequestBody Game game) {
        System.out.println(game);
        

        // Retorna uma resposta indicando que o jogo foi processado com sucesso
        return ResponseEntity.ok(game);
    }
}
