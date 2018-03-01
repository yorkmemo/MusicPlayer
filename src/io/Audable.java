package io;

import java.beans.EventHandler;

public interface Audable {


    Audable play();
    Audable sleep(double seconds);
    Audable loop();
    Audable loop(int times);
    Audable stop();
    Audable pause();
    Audable pause(double seconds);
    Audable onDone(EventHandler event);

}
