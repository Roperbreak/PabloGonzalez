package es.gonzalez.AcademyBoxIt.model.dao;

import java.util.List;

import es.gonzalez.AcademyBoxIt.model.Doubt;
import es.gonzalez.AcademyBoxIt.model.dao.exceptions.DoubtDaoException;

public interface DoubtDao {

	public void saveDoubt(Doubt d) throws DoubtDaoException;

	public void deleteDoubt(Doubt d) throws DoubtDaoException;

	public List<Doubt> listDoubts() throws DoubtDaoException;

}
