package br.com.cmosdrake.repository.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "dea")
@NamedQueries({
	@NamedQuery(name="DeaEntity.findLast",query="select t from DeaEntity t order by t.idDea desc")
})
public class DeaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDea;
	private String latitude;
	private String longitude;

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Integer getIdDea() {
		return idDea;
	}

	public void setIdDea(Integer idDea) {
		this.idDea = idDea;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDea == null) ? 0 : idDea.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeaEntity other = (DeaEntity) obj;
		if (idDea == null) {
			if (other.idDea != null)
				return false;
		} else if (!idDea.equals(other.idDea))
			return false;
		return true;
	}

}
