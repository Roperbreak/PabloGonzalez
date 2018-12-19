package es.gonzalez.AcademyBoxIt.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usertype")
public class UserType {

	private Integer idtype;
	private String typename;
	private Set<User> usersbyType;

	@Id
	public Integer getIdtype() {
		return idtype;
	}

	public void setIdtype(Integer idtype) {
		this.idtype = idtype;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "usertype")
	public Set<User> getUsersbyType() {
		return usersbyType;
	}

	public void setUsersbyType(Set<User> usersbyType) {
		this.usersbyType = usersbyType;
	}

	@Override
	public String toString() {
		return "Eres un " + typename;
	}

}
