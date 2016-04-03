/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @authors Alicia Monleón and Mario Alameda
 */
public class PC {
    private StringProperty name;
    private ObjectProperty<Component> motherboard;
    private ObjectProperty<Component> cpu;
    private ObjectProperty<Component> ram;
    private ObjectProperty<Component> gpu;
    private ObjectProperty<Component> hardDisk;
    private ObjectProperty<Component> box;
    private ObservableList<Component> others;
    
    /**
     * 
     */
    public PC(){
        this.name = new SimpleStringProperty();
        this.motherboard = new SimpleObjectProperty<>();
        this.cpu = new SimpleObjectProperty<>();
        this.ram = new SimpleObjectProperty<>();
        this.gpu = new SimpleObjectProperty<>();
        this.hardDisk = new SimpleObjectProperty<>();
        this.box = new SimpleObjectProperty<>();
        this.others = FXCollections.observableList(new ArrayList<Component>());
    }

    /**
     * @return the observable name
     */
    public StringProperty getNameProperty() {
        return name;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name.get();
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name.set(name);
    }

    /**
     * @return the observable motherboard
     */
    public ObjectProperty<Component> getMotherboardProperty() {
        return motherboard;
    }
    
    /**
     * @return the motherboard
     */
    public Component getMotherboard() {
        return motherboard.get();
    }

    /**
     * @param motherboard the motherboard to set
     */
    public void setMotherboard(Component motherboard) {
        this.motherboard.set(motherboard);
    }

    /**
     * @return the observable cpu
     */
    public ObjectProperty<Component> getCpuProperty() {
        return cpu;
    }

    /**
     * @return the cpu
     */
    public Component getCpu() {
        return cpu.get();
    }
    
    /**
     * @param cpu the cpu to set
     */
    public void setCpu(Component cpu) {
        this.cpu.set(cpu);
    }

    /**
     * @return the observable ram
     */
    public ObjectProperty<Component> getRamProperty() {
        return ram;
    }

    /**
     * @return the ram
     */
    public Component getRam() {
        return ram.get();
    }

    /**
     * @param ram the ram to set
     */
    public void setRam(Component ram) {
        this.ram.set(ram);
    }

    /**
     * @return the observable gpu
     */
    public ObjectProperty<Component> getGpuProperty() {
        return gpu;
    }
    
    /**
     * @return the gpu
     */
    public Component getGpu() {
        return gpu.get();
    }

    /**
     * @param gpu the gpu to set
     */
    public void setGpu(Component gpu) {
        this.gpu.set(gpu);
    }

    /**
     * @return the observable hardDisk
     */
    public ObjectProperty<Component> getHardDiskProperty() {
        return hardDisk;
    }

    /**
     * @return the hardDisk
     */
    public Component getHardDisk() {
        return hardDisk.get();
    }
    
    /**
     * @param hardDisk the hardDisk to set
     */
    public void setHardDisk(Component hardDisk) {
        this.hardDisk.set(hardDisk);
    }

    /**
     * @return the observable box
     */
    public ObjectProperty<Component> getBoxProperty() {
        return box;
    }
    
    /**
     * @return the box
     */
    public Component getBox() {
        return box.get();
    }

    /**
     * @param box the box to set
     */
    public void setBox(Component box) {
        this.box.set(box);
    }

    /**
     * @return the others
     */
    public ObservableList<Component> getOthers() {
        return others;
    }
  
    /**
     * Adds a new component attending at its category
     * @param c as new component that must be added to the PC
     */
    public void addComponent(Component c){        
        switch(c.getProduct().getCategory()){
            case MOTHERBOARD:
                this.setMotherboard(c);
                break;

            case CPU:
                this.setCpu(c);
                break;

            case RAM:
                this.setRam(c);
                break;

            case GPU:
                this.setGpu(c);
                break;

            case HDD: case HDD_SSD:
                this.setHardDisk(c);

            case CASE:
                this.setBox(c);
                break;

            default:
            getOthers().add(c);        
        }
    }
    
    /**
     * Removes a given component from the PC configuration
     * @param c as the component that must be removed
     */
    public void removeComponent(Component c){
        switch(c.getProduct().getCategory()){
            case MOTHERBOARD:
                this.setMotherboard(null);
                break;

            case CPU:
                this.setCpu(null);
                break;

            case RAM:
                this.setRam(null);
                break;

            case GPU:
                this.setGpu(null);
                break;

            case HDD: case HDD_SSD:
                this.setHardDisk(null);

            case CASE:
                this.setBox(null);
                break;

            default:
            getOthers().remove(c);        
        }    
    } 
    
    /**
     * Removes all components of the current configuration
     */
    public void removeAll(){
        this.setMotherboard(null);
        this.setCpu(null);
        this.setRam(null);
        this.setGpu(null);
        this.setHardDisk(null);
        this.setBox(null);
        getOthers().clear();
    }
    
    /**
     * Checks if the PC's configuration requierments are correct
     * @param pc as the configuration that must be validated
     * @return true if the configuration is valid
     */
    public boolean isValid(PC pc) {
        return !(name == null || motherboard == null || cpu == null ||
        ram == null || gpu == null || hardDisk == null || box == null);     
    }
}