package io;

import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.beans.EventHandler;
import java.util.LinkedList;
import java.util.Queue;

public class Audio implements Audable {
    private MediaPlayer mediaPlayer;
    private Queue<Runnable> queue;
    private boolean ready;
    private int waiting = 0;


    public Audio(String fileName) {
        System.out.println(Audio.class.getClassLoader().getResource(fileName));
        mediaPlayer = new MediaPlayer(new Media(Audio.class.getClassLoader().getResource(fileName).toString()));
        ready = false;
        queue = new LinkedList<>();
        mediaPlayer.setOnReady(()->{
            System.out.println("Ready");
            ready = true;
        });
    }

    void tick() {
        if (ready) {
            waiting--;

            while (waiting <= 0 && queue.size() > 0) {
                Platform.runLater(queue.remove());
            }
        }

    }

    @Override
    public Audable play() {
        if (!ready || waiting > 0) {
            queue.add(this::play);
        } else {

            System.out.println("Playing: " + mediaPlayer.getMedia().getDuration().toSeconds());

            mediaPlayer.play();
        }
        mediaPlayer.setOnEndOfMedia(() -> System.out.println("done"));
        return this;
    }

    @Override
    public Audable sleep(double seconds) {
        if (!ready || waiting > 0) {
            queue.add(()->sleep(seconds));
        } else {
            waiting = (int) Math.round(seconds * Win.FPS);
        }

        return this;
    }

    @Override
    public Audable loop() {
        if (!ready || waiting > 0) {
            queue.add(this::loop);
        } else {
            mediaPlayer.setCycleCount(-1);
        }

        return this;
    }

    @Override
    public Audable loop(int times) {
        if (!ready || waiting > 0) {
            queue.add(()->loop(times));
        } else {
            mediaPlayer.setCycleCount(times > 0 ? times : -1);
        }
        return this;
    }

    @Override
    public Audable stop() {
        if (!ready || waiting > 0) {
            queue.add(this::stop);
        } else {
            mediaPlayer.stop();
        }

        return this;
    }

    @Override
    public Audable pause() {
        if (!ready || waiting > 0) {
            queue.add(this::pause);
        } else {
            mediaPlayer.pause();
        }

        return this;
    }

    @Override
    public Audable pause(double seconds) {
        if (!ready || waiting > 0) {
            queue.add(()->pause(seconds));
        } else {
            mediaPlayer.pause();
            sleep(seconds);
            play();
        }
        return this;
    }

    @Override
    public Audable onDone(EventHandler event) {
        return null;
    }
}
