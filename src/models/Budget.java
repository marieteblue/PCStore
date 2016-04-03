/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @authors Alicia Monleón and Mario Alameda
 */
public class Budget {
    private static final double VAT = 21/100;
    private final DoubleProperty total;
    private final DoubleProperty amountBeforeTax;
    private final PC pc;
    
    /**
     * Calculates the total amount before taxes and the total amount of the budget
     * @param pc which budget has to be shown
     */
    public Budget(PC pc) {
        this.pc = pc;
        this.amountBeforeTax = new SimpleDoubleProperty();
        this.amountBeforeTax.set(pcPrice(pc));
        this.total = new SimpleDoubleProperty();
        this.total.set(amountBeforeTax.getValue() * VAT);
    }
    
    /**
     * @param pc which price has to be calculated
     * @return pc's price
     */
    private static double pcPrice(PC pc) {
        double othersTotal = 0;
        for(Component c : pc.getOthers()) {
            othersTotal += c.getQuantity() * c.getProduct().getPrice();
        }
        return pc.getMotherboard().getProduct().getPrice()*
               pc.getMotherboard().getQuantity() + 
               pc.getCpu().getProduct().getPrice()*
               pc.getCpu().getQuantity() + 
               pc.getRam().getProduct().getPrice()*
               pc.getRam().getQuantity() + 
               pc.getGpu().getProduct().getPrice()*
               pc.getGpu().getQuantity() + 
               pc.getHardDisk().getProduct().getPrice()*
               pc.getHardDisk().getQuantity() + 
               pc.getBox().getProduct().getPrice()*
               pc.getBox().getQuantity() + othersTotal;
    }
}