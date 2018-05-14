package br.com.cmosdrake.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.cmosdrake.model.DeaModel;
import br.com.cmosdrake.repository.entity.DeaEntity;
import br.com.cmosdrake.uteis.Uteis;

public class DeaRepository implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	DeaEntity deaEntity;
	
	EntityManager entityManager;
	
	public DeaModel GetUltimoRegistro() {	
		DeaModel deaModel = new DeaModel();
		entityManager = Uteis.JpaEntityManager();
		//Query query = entityManager.createNamedQuery("DeaEntity.findLast");
		TypedQuery<DeaEntity> query = entityManager.createQuery("SELECT u FROM DeaEntity u ORDER BY u.idDea DESC", DeaEntity.class);    		
		List<DeaEntity> resultList= query.setMaxResults(1).getResultList();
		DeaEntity deaEntity = resultList.get(0);
		deaModel.setLatitude(deaEntity.getLatitude());
		deaModel.setLongitude(deaEntity.getLongitude());
		return deaModel;
	}
	
	public String GetUltimoRegistroString() {	
		String toReturn = null;
		entityManager = Uteis.JpaEntityManager();
		TypedQuery<DeaEntity> query = entityManager.createQuery("SELECT u FROM DeaEntity u ORDER BY u.idDea DESC", DeaEntity.class);    		
		List<DeaEntity> resultList= query.setMaxResults(1).getResultList();
		DeaEntity deaEntity = resultList.get(0);
		toReturn = deaEntity.getLatitude()+", "+deaEntity.getLongitude();		
		return toReturn;
	}

}
