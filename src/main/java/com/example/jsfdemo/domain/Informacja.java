package com.example.jsfdemo.domain;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "informacja", eager = true)
@RequestScoped
public class Informacja {
	
	private String informacja = "Zarządzanie tramwajami :)";
	
	public String getInformacja() {
        return informacja;
    }
    public void setInformacja(String informacja) {
        this.informacja = informacja;
    }
}
