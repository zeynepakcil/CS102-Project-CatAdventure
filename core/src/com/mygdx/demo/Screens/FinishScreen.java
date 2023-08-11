package com.mygdx.demo.Screens;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.demo.TuruncsAdventure;
import com.mygdx.demo.Levels.LevelState;

public class FinishScreen extends Window {


    private static WindowStyle windowStyle;
    private TuruncsAdventure game;
    private static Image finish;
    public Music music;


    static {
        windowStyle = new Window.WindowStyle(new BitmapFont(), Color.BLACK,
                new TextureRegionDrawable(new Texture("Empty.png")));
    }

    public FinishScreen(TuruncsAdventure t) {
        super("", windowStyle);
        game = t;
         music = TuruncsAdventure.manager.get("Audio/music/pixel-song-18-72641.mp3", Music.class);
        music.setLooping(true);
        music.play();
        finish = new Image(new Texture("end.png"));
        getTitleTable().add(finish).size((int) (1100 / 3), (int) (516 / 3)).padTop(200).padRight(10);
        ;
        finish.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                setVisible(false);
                LevelState.bookCount =0;
                game.setScreen(new MenuScreen(game));
            

            }
        });
        setClip(false);
        setTransform(true);
    }
}

