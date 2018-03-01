package io;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.LinkedList;

class ItemGroup implements Itemable {
    private LinkedList<Item> items;
    private String type;

    ItemGroup() {
        this.type = null;
        items = new LinkedList<>();
    }

    ItemGroup(String type) {
        this.type = type;
        items = new LinkedList<>();
    }

    boolean add(Item item) {
        // System.out.println(type+"|"+item.getClass().getName());
        return (type != null && item.getType().equals(type) && items.add(item)) || (type == null && items.add(item));
    }

    int size() {
        return items.size();
    }

    @Override
    public Itemable stroke(Color color) {
        for (Item item : items) {
            item.stroke(color);
        }

        return this;
    }

    @Override
    public Itemable fill(Color color) {
        for (Item item : items) {
            item.fill(color);
        }

        return this;
    }

    @Override
    public Itemable onOver(EventHandler<MouseEvent> handler) {
        for (Item item : items) {
            item.onOver(handler);
        }

        return this;
    }

    @Override
    public Itemable onOut(EventHandler<MouseEvent> handler) {
        for (Item item : items) {
            item.onOut(handler);
        }

        return this;
    }

    @Override
    public Itemable onClick(EventHandler<MouseEvent> handler) {
        for (Item item : items) {
            item.onClick(handler);
        }

        return this;
    }

    @Override
    public Itemable onEdge(EventHandler<Event> handler) {
        for (Item item : items) {
            item.onEdge(handler);
        }

        return this;
    }

    @Override
    public Itemable direction(double angle, double pps) {
        for (Item item : items) {
            item.direction(angle, pps);
        }

        return this;
    }

    @Override
    public Itemable direction(double angle) {
        for (Item item : items) {
            item.direction(angle);
        }

        return this;
    }

    @Override
    public Itemable randomDirection() {
        for (Item item : items) {
            item.randomDirection();
        }

        return this;
    }

    @Override
    public Itemable randomDirection(double min_angle, double max_angle) {
        for (Item item : items) {
            item.randomDirection(min_angle, max_angle);
        }

        return this;
    }

    @Override
    public Itemable speed(double pps) {
        for (Item item : items) {
            item.speed(pps);
        }

        return this;
    }

    @Override
    public Itemable randomSpeed(double min_pps, double max_pps) {
        for (Item item : items) {
            item.randomSpeed(min_pps, max_pps);
        }

        return this;
    }

    @Override
    public Itemable left(double pps) {
        for (Item item : items) {
            item.left(pps);
        }

        return this;
    }

    @Override
    public Itemable left() {
        for (Item item : items) {
            item.left();
        }

        return this;
    }

    @Override
    public Itemable right(double pps) {
        for (Item item : items) {
            item.right(pps);
        }

        return this;
    }

    @Override
    public Itemable right() {
        for (Item item : items) {
            item.right();
        }

        return this;
    }

    @Override
    public Itemable up(double pps) {
        for (Item item : items) {
            item.up(pps);
        }

        return this;
    }

    @Override
    public Itemable up() {
        for (Item item : items) {
            item.up();
        }

        return this;

    }

    @Override
    public Itemable down(double pps) {
        for (Item item : items) {
            item.down(pps);
        }

        return this;
    }

    @Override
    public Itemable down() {
        for (Item item : items) {
            item.down();
        }

        return this;
    }

    @Override
    public Itemable hide() {
        for (Item item : items) {
            item.hide();
        }

        return this;
    }

    @Override
    public Itemable show() {
        for (Item item : items) {
            item.show();
        }

        return this;
    }

    @Override
    public Itemable stop() {
        for (Item item : items) {
            item.stop();
        }

        return this;

    }

    @Override
    public Itemable bounceHorizontal() {
        for (Item item : items) {
            item.bounceHorizontal();
        }

        return this;
    }

    @Override
    public Itemable bounceVertical() {
        for (Item item : items) {
            item.bounceVertical();
        }

        return this;
    }

    @Override
    public Itemable rotate(double degrees) {
        for (Item item : items) {
            item.rotate(degrees);
        }

        return this;
    }

    @Override
    public Itemable fadeIn() {
        for (Item item : items) {
            item.fadeIn();
        }

        return this;
    }

    @Override
    public Itemable fadeOut() {
        for (Item item : items) {
            item.fadeOut();
        }

        return this;
    }

    @Override
    public Itemable fadeIn(double seconds) {
        for (Item item : items) {
            item.fadeIn(seconds);
        }

        return this;
    }

    @Override
    public Itemable fadeOut(double seconds) {
        for (Item item : items) {
            item.fadeOut(seconds);
        }

        return this;
    }

    @Override
    public Itemable sleep(double seconds) {
        for (Item item : items) {
            item.sleep(seconds);
        }

        return this;
    }

    @Override
    public Itemable flipHorizontally() {
        for (Item item : items) {
            item.flipHorizontally();
        }

        return this;
    }

    @Override
    public Itemable flipVertically() {
        for (Item item : items) {
            item.flipVertically();
        }

        return this;
    }

    @Override
    public Itemable id(String id) {
        if (items.size() > 0) {
           items.get(0).id(id);
        }

        return this;
    }

    @Override
    public Itemable rotateTo(double degrees) {
        for (Item item : items) {
            item.rotateTo(degrees);
        }

        return this;
    }

    @Override
    public void remove() {
        for (Item item : items) {
            item.remove();
        }
    }

    @Override
    public Itemable edgeBounce() {
        for (Item item : items) {
            item.edgeBounce();
        }

        return this;
    }

    @Override
    public Itemable edgeBounceFlip() {
        for (Item item : items) {
            item.edgeBounceFlip();
        }

        return this;
    }

    @Override
    public Itemable edgeStop() {
        for (Item item : items) {
            item.edgeStop();
        }

        return this;
    }

    @Override
    public Itemable edgeRemove() {
        for (Item item : items) {
            item.edgeRemove();
        }

        return this;
    }

    @Override
    public Itemable edgeIgnore() {
        for (Item item : items) {
            item.edgeIgnore();
        }

        return this;
    }
}
