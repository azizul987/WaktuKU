/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.waktuku.model;

import java.util.Date;

/**
 *
 * @author g
 */
public class Pomodoro_History {
    
    private Date hari;
    private int mulai;
    private int berhenti;
    private String status;
    public Pomodoro_History(Date hari,int mulai,int berhenti,String status) {
        this.hari=hari;
        this.mulai=mulai;
        this.berhenti=berhenti;
        this.status=status;
    }
    
    public Date get_hari(){return hari;}
    public int get_mulai(){return mulai;}
    public int get_berhenti(){return berhenti;}
    public String get_Status() { return status; }
}
