/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dal;

import model.Rectangle;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class test {
    
    public static void main(String[] args) {
        
    RectDBContext rectdb = new RectDBContext();
    Rectangle rect = rectdb.get(5);
        System.out.println(rect);
    }
    
}
