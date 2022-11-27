package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.sprites.Bird;

public class PlayState extends State{
    private Bird bird;
    private Texture bg;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(50, 100);
        bg = new Texture("bg.png");
        camera.setToOrtho(false, MyGdxGame.WIDTH / 2f, MyGdxGame.HEIGHT / 2f);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            bird.jump();
        }
    }

    @Override
    public void update(float delta) {
        handleInput();
        bird.update(delta);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(bg, camera.position.x - (camera.viewportWidth/2f), 0);
        batch.draw(bird.getBird(), bird.getPosition().x, bird.getPosition().y);
        batch.end();
    }

    @Override
    public void dispose() {
    }
}
