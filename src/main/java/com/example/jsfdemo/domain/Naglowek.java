package com.example.jsfdemo.domain;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "naglowek", eager = true)
@RequestScoped
public class Naglowek {
	@ManagedProperty(value="#{informacja}")
	   private Informacja informacjaBean;

	   private String informacja;

	   public Naglowek() {
	      System.out.println("Naglowek");   
	   }
	   public String getInformacja() {
	      if(informacjaBean != null){
	         informacja = informacjaBean.getInformacja();
	      }       
	      return informacja;
	   }
	   public void setInformacjaBean(Informacja informacja) {
	      this.informacjaBean = informacja;
	   }
}
