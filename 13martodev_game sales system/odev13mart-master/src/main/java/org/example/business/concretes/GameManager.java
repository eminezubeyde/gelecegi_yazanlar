package org.example.business.concretes;

import org.example.business.abstracts.GameService;
import org.example.data.entity.Game;

public class GameManager implements GameService {

    @Override
    public void add(Game game) {
        System.out.println(game.getName() + " sisteme eklendi.");
    }

    @Override
    public void update(Game game) {
        System.out.println(game.getName() + " güncellendi.");
    }

    @Override
    public void delete(Game game) {
        System.out.println(game.getName() + " sistemden silindi.");
    }
}
