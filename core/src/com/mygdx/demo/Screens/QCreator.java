package com.mygdx.demo.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

public class QCreator extends Window {
    TextureAtlas textureAtlas;
    public static int questionNo;
    private static final WindowStyle windowStyle;
    private static final ImageButtonStyle yesButtonStyle, noButtonStyle;
    private static Image question1, question2, question3;
    private static Image close, questionAsk;
    private static boolean firstshown = false;
    private static boolean secondshown = false;
    private static boolean thirdshown = false;


    static {
        TextureAtlas textureAtlas = new TextureAtlas(Gdx.files.internal("questionScreenTiles.pack"));
        windowStyle = new WindowStyle(new BitmapFont(), Color.BLACK,
                new TextureRegionDrawable(textureAtlas.findRegion("questionBackground")));
        yesButtonStyle = new ImageButtonStyle();
        noButtonStyle = new ImageButtonStyle();
        yesButtonStyle.imageUp = new TextureRegionDrawable(textureAtlas.findRegion("yesButton"));
        noButtonStyle.imageUp = new TextureRegionDrawable(textureAtlas.findRegion("noButton"));
    }

    public QCreator() {
        super("", windowStyle);
        TextureAtlas texAtlas = new TextureAtlas(Gdx.files.internal("allGPquestions.pack"));
        TextureAtlas closeAtlas = new TextureAtlas(Gdx.files.internal("closeIconTileset.pack"));
        //TextureAtlas questionAskAtlas = new TextureAtlas(Gdx.files.internal("questionAsk.pack"));
        question1 = new Image(texAtlas.findRegion("question1"));
        question2 = new Image(texAtlas.findRegion("question2"));
        question3 = new Image(texAtlas.findRegion("question3"));
        close = new Image(closeAtlas.findRegion("closeIcon"));
       // questionAsk = new Image(questionAskAtlas.findRegion("questionAsk"));
        final Button yesButton = new ImageButton(yesButtonStyle);
        final Button noButton = new ImageButton(noButtonStyle);
        yesButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                getTitleTable().removeActor(questionAsk);
                getTitleTable().removeActor(yesButton);
                getTitleTable().removeActor(noButton);
                System.out.println("jdnf");

                if (!firstshown) {
                    firstshown = true;
                    getTitleTable().add(question3).size((int) (1031 / 3), (int) (115 / 3)).padTop(200)
                            .padRight(500);
                    question3.addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            setVisible(false);
                            question3.clear();
                        }

                    });

                }
                else if (firstshown && ! secondshown) {
                    secondshown = true;
                    getTitleTable().add(question2).size((int) (754 / 2.5), (int) (145 / 2.5)).padTop(200)
                            .padRight(550);
                    question2.addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            setVisible(false);
                            question2.clear();
                        }
                    });


                } else if (firstshown&&secondshown) {

                    getTitleTable().add(question1).size((int) (1100 / 2.5), (int) (516 / 2.5)).padTop(200)
                            .padRight(450);
                    question1.addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            setVisible(false);
                            question1.clear();
                        }
                    });

                }
                System.out.println("djnfnjmffnddjfjnjfjfdjfdjnfjnfj");

            }
        });
        noButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                setVisible(false);
            }
        });
        //getTitleTable().add(questionAsk).size(700 / 5, 100 / 5).padLeft(400).padTop(100);
        getTitleTable().add(yesButton).size(96 / 2, 64 / 2).padLeft(200).padTop(300);
        getTitleTable().add(noButton).size(96 / 2, 64 / 2).padRight(200).padTop(300);
        // getTitleTable().add(noButton).size(96 / 2, 64 / 2).padLeft(10);

        setClip(false);
        setTransform(true);
    }
}