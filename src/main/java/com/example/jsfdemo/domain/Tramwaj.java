package com.example.jsfdemo.domain;

//import java.util.Arrays;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;


import com.example.jsfdemo.web.UrlData;

public class Tramwaj {
	
	private String kodTramwaju;
	private String wysPodlogi;
	private String firma;
	private String model;
	private String rozstawOsi;
	private int liczbaMiejsc=1;
	private String zdjecie;
	private String kolor;
	private Date dataProdukcji = new Date();
	private UrlData adresStrony;
	private boolean canEdit;
	
/*	@Min(7)*/
	public String getKodTramwaju(){
		return kodTramwaju;
	}
		
	public void setKodTramwaju(String kodTramwaju){
		this.kodTramwaju = kodTramwaju;
	}
	
	public String getZdjecie(){
	return zdjecie;
	}
	
	public void setZdjecie(String zdjecie){
	this.zdjecie = zdjecie;
	}
	
	public String getWysPodlogi(){
	return wysPodlogi;
	}
	
	public void setWysPodlogi(String wysPodlogi){
	this.wysPodlogi = wysPodlogi;
	}
	
	
	@Pattern(regexp = "[A-Za-z0-9]{2,}")
	public String getFirma(){
	return firma;
	}
	public void setFirma(String firma){
	this.firma = firma;
	}
	
	
	@Pattern(regexp = "[A-Za-z0-9]{2,}")
	public String getModel(){
	return model;
	}
	
	public void setModel(String model){
	this.model = model;
	}
	
	
	@Min(1)
	public int getLiczbaMiejsc(){
	return liczbaMiejsc;
	}
	
	public void setLiczbaMiejsc(int liczbaMiejsc){
	this.liczbaMiejsc = liczbaMiejsc;
	}
	
	
	
	public String getRozstawOsi(){
	return rozstawOsi;
	}
	
	public void setRozstawOsi(String rozstawOsi){
	this.rozstawOsi = rozstawOsi;
	}
	
	
	public String getKolor(){
		return kolor;
	}
	
	public void setKolor(String kolor){
		this.kolor = kolor;
	}
	
	
	
	@Past
	public Date getDataProdukcji() {
		return dataProdukcji;
	}
	public void setDataProdukcji(Date dataProdukcji) {
		this.dataProdukcji = dataProdukcji;
	}
	
	
	public UrlData getAdresStrony() {
		return adresStrony;
	}	

	public void setAdresStrony(UrlData adresStrony) {
	    this.adresStrony = adresStrony;
	}

	
	public boolean isCanEdit() {
		return canEdit;
	}

	public void setCanEdit(boolean canEdit) {
	    this.canEdit = canEdit;
	}
	
	
}
