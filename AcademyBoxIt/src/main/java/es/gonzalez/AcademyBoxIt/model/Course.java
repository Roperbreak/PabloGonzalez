package es.gonzalez.AcademyBoxIt.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	private Integer idclass;
	private String coursename;

	private Set<User> courselist;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdclass() {
		return idclass;
	}

	public void setIdclass(Integer idclass) {
		this.idclass = idclass;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "course")
	public Set<User> getCourselist() {
		return courselist;
	}

	public void setCourselist(Set<User> courselist) {
		this.courselist = courselist;
	}

	@Override
	public String toString() {

		return coursename;
	}
}
