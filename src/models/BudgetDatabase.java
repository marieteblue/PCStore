/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @authors Alicia Monleón and Mario Alameda
 */
public class BudgetDatabase {
    
    private static final ArrayList<Budget> all = new ArrayList<>();
       
    public static void add(Budget b) {
        all.add(b);
    }    
}
