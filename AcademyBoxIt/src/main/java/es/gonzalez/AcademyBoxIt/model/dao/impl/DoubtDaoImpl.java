package es.gonzalez.AcademyBoxIt.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.gonzalez.AcademyBoxIt.model.Doubt;
import es.gonzalez.AcademyBoxIt.model.dao.DoubtDao;
import es.gonzalez.AcademyBoxIt.model.dao.exceptions.DoubtDaoException;

@Repository
public class DoubtDaoImpl implements DoubtDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveDoubt(Doubt d) throws DoubtDaoException {
		try {
			sessionFactory.getCurrentSession().save(d);
		} catch (Exception ex) {
			throw new DoubtDaoException(ex);
		}

	}

	@Override
	public void deleteDoubt(Doubt d) throws DoubtDaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Doubt> listDoubts() throws DoubtDaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
