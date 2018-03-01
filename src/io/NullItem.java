package io;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class NullItem implements Itemable {
    Item item = new Item(new Text(""));
    @Override

    public Itemable stroke(Color color) {
        return this;
    }

    @Override
    public Itemable fill(Color color) {
        return this;
    }

    @Override
    public Itemable onOver(EventHandler<MouseEvent> handler) {
        return this;
    }

    @Override
    public Itemable onOut(EventHandler<MouseEvent> handler) {
        return this;
    }

    @Override
    public Itemable onClick(EventHandler<MouseEvent> handler) {
        return this;
    }

    @Override
    public Itemable onEdge(EventHandler<Event> handler) {
        return this;
    }

    @Override
    public Itemable direction(double angle, double pps) {
        return this;
    }

    @Override
    public Itemable direction(double angle) {
        return this;
    }

    @Override
    public Itemable randomDirection() {
        return this;
    }

    @Override
    public Itemable randomDirection(double min_angle, double max_angle) {
        return this;
    }

    @Override
    public Itemable speed(double pps) {
        return this;
    }

    @Override
    public Itemable randomSpeed(double min_pps, double max_pps) {
        return this;
    }

    @Override
    public Itemable left(double pps) {
        return this;
    }

    @Override
    public Itemable left() {
        return this;
    }

    @Override
    public Itemable right(double pps) {
        return this;
    }

    @Override
    public Itemable right() {
        return this;
    }

    @Override
    public Itemable up(double pps) {
        return this;
    }

    @Override
    public Itemable up() {
        return this;
    }

    @Override
    public Itemable down(double pps) {
        return this;
    }

    @Override
    public Itemable down() {
        return this;
    }

    @Override
    public Itemable hide() {
        return this;
    }

    @Override
    public Itemable show() {
        return this;
    }

    @Override
    public Itemable stop() {
        return this;
    }

    @Override
    public Itemable bounceHorizontal() {
        return this;
    }

    @Override
    public Itemable bounceVertical() {
        return this;
    }

    @Override
    public Itemable rotate(double degrees) {
        return this;
    }

    @Override
    public Itemable fadeIn() {
        return this;
    }

    @Override
    public Itemable fadeOut() {
        return this;
    }

    @Override
    public Itemable fadeIn(double seconds) {
        return this;
    }

    @Override
    public Itemable fadeOut(double seconds) {
        return this;
    }

    @Override
    public Itemable sleep(double seconds) {
        return this;
    }

    @Override
    public Itemable flipHorizontally() {
        return this;
    }

    @Override
    public Itemable flipVertically() {
        return this;
    }

    @Override
    public Itemable id(String name) {
        return this;
    }

    @Override
    public Itemable rotateTo(double degrees) {
        return this;
    }

    @Override
    public void remove() {

    }

    @Override
    public Itemable edgeBounce() {
        return this;
    }

    @Override
    public Itemable edgeBounceFlip() {
        return this;
    }

    @Override
    public Itemable edgeStop() {
        return this;
    }

    @Override
    public Itemable edgeRemove() {
        return this;
    }

    @Override
    public Itemable edgeIgnore() {
        return this;
    }
}
