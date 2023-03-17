package org.example.business.abstracts;

import org.example.data.entity.Game;

public interface GameService {
    void add(Game game);
    void update(Game game);
    void delete(Game game);
}
