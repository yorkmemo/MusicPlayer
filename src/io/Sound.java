package io;


import java.util.HashMap;
import java.util.Map;

public class Sound {
    private static Map<String, Audio> soundMap = new HashMap<String, Audio>();

    public static Audable file(String filename) {
        if (!soundMap.containsKey(filename)) {
            soundMap.put(filename, new Audio(filename));
        }

        return soundMap.get(filename);
    }

    static void tick() {
        for(Map.Entry<String, Audio> entry : soundMap.entrySet()) {
            Audio audio = entry.getValue();
            audio.tick();
        }
    }

    static void stopAll() {
        for(Map.Entry<String, Audio> entry : soundMap.entrySet()) {
            Audio audio = entry.getValue();
            audio.stop();
        }
    }

    static void pauseAll() {
        for(Map.Entry<String, Audio> entry : soundMap.entrySet()) {
            Audio audio = entry.getValue();
            audio.pause();
        }
    }


    /*public static Audable all() {

    }*/

}
