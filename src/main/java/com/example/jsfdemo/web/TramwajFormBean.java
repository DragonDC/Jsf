package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;


import com.example.jsfdemo.domain.Tramwaj;
import com.example.jsfdemo.service.TramwajManager;

@SessionScoped
@Named("tramwajBean")
public class TramwajFormBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Tramwaj tramwaj = new Tramwaj();

	private ListDataModel<Tramwaj> tramwaje = new ListDataModel<Tramwaj>();

	@Inject
	private TramwajManager tm;

	public Tramwaj getTramwaj() {
		return tramwaj;
	}

	public void setTramwaj(Tramwaj tramwaj) {
		this.tramwaj = tramwaj;
	}

	public ListDataModel<Tramwaj> getAllTramwaje() {
		tramwaje.setWrappedData(tm.getAllTramwaje());
		return tramwaje;
	}

	// Actions
	public String addTramwaj() {
		tm.addTramwaj(tramwaj);
		return "showTramwaje";
		//return null;
	}

	public String deleteTramwaj() {
		Tramwaj tramwajToDelete = tramwaje.getRowData();
		tm.deleteTramwaj(tramwajToDelete);
		return null;
	}
	
	
	
	public void uniqueKodTramwaju(FacesContext context, UIComponent component,
			Object value) {

		String kod = (String) value;

		for (Tramwaj tram : tm.getAllTramwaje()) {
			if (tram.getKodTramwaju().equalsIgnoreCase(kod)) {
				FacesMessage message = new FacesMessage(
						"Tramwaj z takim kodem już istnieje w bazie/Tram with this code already exist in the base");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}

	// Multi field validation with <f:event>
	// Rule: first two digits of PIN must match last two digits of the year of
	// birth
	public void validateKodProducentaZData(ComponentSystemEvent event) {

		UIForm form = (UIForm) event.getComponent();
		UIInput kod = (UIInput) form.findComponent("kodTramwaju");
		UIInput data = (UIInput) form.findComponent("dataProdukcji");

		if (kod.getValue() != null && data.getValue() != null
				&& kod.getValue().toString().length() >= 2) {
			String dwieOstatnieCyfryKodu = kod.getValue().toString().substring(0, 2);
			Calendar cal = Calendar.getInstance();
			cal.setTime(((Date) data.getValue()));

			String dwieOstanieCyfryDaty = ((Integer) cal.get(Calendar.YEAR))
					.toString().substring(2);
			//Pierwsze dwie cyfry z kodu musza pasowac do dwoch ostatnich cyfr roku produkcji
			if (!dwieOstatnieCyfryKodu.equals(dwieOstanieCyfryDaty)) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(form.getClientId(), new FacesMessage(
						"Kod tramwaju nie pasuje do daty produkcji/Tram code does not match the date of manufacture"));
				context.renderResponse();
			}
		}
	}
	
	
	 public String editTramwaj(){
		 Tramwaj tramwaj = tramwaje.getRowData();
		 //tm.deleteTramwaj(tramwajToDelete);
	     tramwaj.setCanEdit(true);
	     return null;
	 }

	 public String saveTramwaje(){
	     
	     /*for (Tramwaj tramwaj : tramwaje){
	        tramwaj.setCanEdit(false);
	     }*/
		 Tramwaj tramwaj = tramwaje.getRowData();
		 tm.addTramwaj(tramwaj);
		 //tramwaj.setCanEdit(false);
		 //Tramwaj nowyTram = tm.edycjaTramwaj(tramwaj);
		 
		 tm.deleteTramwaj(tramwaj);
		 
		 return null;
	 }
	   
	

}
