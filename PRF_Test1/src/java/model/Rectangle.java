/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author fpt
 */
public class Rectangle {
    private int width, height, coordiX, coordiY;

    public Rectangle(int width, int height, int coordiX, int coordiY) {
        this.width = width;
        this.height = height;
        this.coordiX = coordiX;
        this.coordiY = coordiY;
    }

    public Rectangle() {
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getCoordiX() {
        return coordiX;
    }

    public int getCoordiY() {
        return coordiY;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setCoordiX(int coordiX) {
        this.coordiX = coordiX;
    }

    public void setCoordiY(int coordiY) {
        this.coordiY = coordiY;
    }

    @Override
    public String toString() {
        return coordiX + "," + coordiY + ", " + width + ", " + height;
    }
    
    
}
