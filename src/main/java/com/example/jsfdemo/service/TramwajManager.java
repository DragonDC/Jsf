package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.Tramwaj;

@ApplicationScoped
public class TramwajManager {
	
	private List<Tramwaj> tabOb = new ArrayList<Tramwaj>();

	public void addTramwaj(Tramwaj tramwaj) {
		Tramwaj newTramwaj = new Tramwaj();
		
		newTramwaj.setKodTramwaju(tramwaj.getKodTramwaju());
		newTramwaj.setFirma(tramwaj.getFirma());
		newTramwaj.setModel(tramwaj.getModel());
		newTramwaj.setLiczbaMiejsc(tramwaj.getLiczbaMiejsc());
		newTramwaj.setRozstawOsi(tramwaj.getRozstawOsi());
		newTramwaj.setDataProdukcji(tramwaj.getDataProdukcji());
		newTramwaj.setKolor(tramwaj.getKolor());
		newTramwaj.setZdjecie(tramwaj.getZdjecie());
		newTramwaj.setWysPodlogi(tramwaj.getWysPodlogi());
		newTramwaj.setAdresStrony(tramwaj.getAdresStrony());
		newTramwaj.setCanEdit(false);

		tabOb.add(newTramwaj);
	}
	
	// Removes the person with given PIN
		public void deleteTramwaj(Tramwaj tramwaj) {
			Tramwaj tramwajToRemove = null;
			for (Tramwaj tram : tabOb) {
				if ((tramwaj.getKodTramwaju()) == (tram.getKodTramwaju())) {
					tramwajToRemove = tram;
					break;
				}
			}
			if (tramwajToRemove != null)
				tabOb.remove(tramwajToRemove);
		}
		
		public Tramwaj edycjaTramwaj(Tramwaj tramwaj){
			Tramwaj newTramwaj = new Tramwaj();
			
			newTramwaj.setKodTramwaju(tramwaj.getKodTramwaju());
			newTramwaj.setFirma(tramwaj.getFirma());
			newTramwaj.setModel(tramwaj.getModel());
			newTramwaj.setLiczbaMiejsc(tramwaj.getLiczbaMiejsc());
			newTramwaj.setRozstawOsi(tramwaj.getRozstawOsi());
			newTramwaj.setDataProdukcji(tramwaj.getDataProdukcji());
			newTramwaj.setKolor(tramwaj.getKolor());
			newTramwaj.setZdjecie(tramwaj.getZdjecie());
			newTramwaj.setWysPodlogi(tramwaj.getWysPodlogi());
			newTramwaj.setAdresStrony(tramwaj.getAdresStrony());
			newTramwaj.setCanEdit(false);
			
			return newTramwaj;
		}

		public List<Tramwaj> getAllTramwaje() {
			return tabOb;
		}
	
}
