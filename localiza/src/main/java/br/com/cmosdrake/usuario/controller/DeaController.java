package br.com.cmosdrake.usuario.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import br.com.cmosdrake.model.DeaModel;
import br.com.cmosdrake.repository.DeaRepository;
import br.com.cmosdrake.repository.entity.DeaEntity;

@Named(value = "deaController")
@RequestScoped
public class DeaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MapModel local;
	private Marker marker;

	@Inject
	DeaModel deaModel;

	@Inject
	DeaRepository deaRepository;

	@Inject
	DeaEntity deaEntity;

	String latitudeLongitude;

	@PostConstruct
	public void init() {
		deaModel = getLastDeaEntity();
	}

	private void carregarLocal() {
		deaModel = getLastDeaEntity();
		local = new DefaultMapModel();
		LatLng coord1 = new LatLng(Double.parseDouble(deaModel.getLatitude()), Double.parseDouble(deaModel.getLongitude()));
		local.addOverlay(new Marker(coord1,	"DEA Life 400 Futura","locked.png"));
	}

	public MapModel getLocais() {
		// if (local == null) {
		carregarLocal();
		// }
		return local;
	}

	public MapModel getLocal() {
		return local;
	}

	public void setLocal(MapModel local) {
		this.local = local;
	}

	public DeaModel getDeaModel() {
		return deaModel;
	}

	public void setDeaModel(DeaModel deaModel) {
		this.deaModel = deaModel;
	}

	public String getLatitudeLongitudeString() {
		return deaRepository.GetUltimoRegistroString();
	}

	public DeaModel getLastDeaEntity() {
		return deaRepository.GetUltimoRegistro();
	}

	public String getLatitudeLongitude() {
		return getLatitudeLongitudeString();
	}

	public void setLatitudeLongitude(String latitudeLongitude) {
		this.latitudeLongitude = latitudeLongitude;
	}

	public DeaEntity getDeaEntity() {
		return deaEntity;
	}

	public void setDeaEntity(DeaEntity deaEntity) {
		this.deaEntity = deaEntity;
	}
	
	public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }

	public Marker getMarker() {
		return marker;
	}	

}
