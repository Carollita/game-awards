package me.dio.gameawards.controller.games;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.dio.gameawards.controller.BaseRestController;
import me.dio.gameawards.domain.model.Game;
import me.dio.gameawards.service.GameService;

@RestController
public class GameRestController extends BaseRestController {
    @Autowired
    private GameService businessLayer;

    /*without AutoWired
    private final GameService businessLayer;
    public GameRestController(GameService businessLayer) {
        this.businessLayer = businessLayer;
    }
    */

    @GetMapping("games")
    // @RequestMapping(method = RequestMethod.GET, path = "games")
    // http://localhost:8080/api/games
    public ResponseEntity<List<Game>> findAll() {
        List<Game> games = businessLayer.findAll();
        return ResponseEntity.ok(games);
    }

    @GetMapping("games/{id}")
    // http://localhost:8080/api/games/{id}
    public ResponseEntity<Game> findById(@PathVariable Long id) {
        Game game = businessLayer.findId(id);
        return ResponseEntity.ok(game);
    }

    @PostMapping("games")
    // http://localhost:8080/api/games
    public ResponseEntity<Game> insert(@RequestBody Game game) {
        businessLayer.insert(game);
        return ResponseEntity.ok(game);
    }

    @PutMapping("games/{id}")
    // http://localhost:8080/api/games/{id}
    public ResponseEntity<Game> update(@PathVariable Long id, @RequestBody Game game) {
        businessLayer.update(id, game);
        return ResponseEntity.ok(game);
    }

    @DeleteMapping("games/{id}")
    // http://localhost:8080/api/games/{id}
    public ResponseEntity<Game> delete(@PathVariable Long id) {
        businessLayer.delete(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("games/{id}/vote")
    // http://localhost:8080/api/games/{id}/vote
    public ResponseEntity<Game> update(@PathVariable Long id) {
        businessLayer.vote(id);
        return ResponseEntity.ok().build();
    }
}
