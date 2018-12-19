package es.gonzalez.AcademyBoxIt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.gonzalez.AcademyBoxIt.model.Doubt;
import es.gonzalez.AcademyBoxIt.model.User;
import es.gonzalez.AcademyBoxIt.model.dao.DoubtDao;
import es.gonzalez.AcademyBoxIt.service.DoubtSvc;
import es.gonzalez.AcademyBoxIt.service.exceptions.DoubtSvcException;

@Service
@Transactional
public class DoubtSvcImpl implements DoubtSvc {

	@Autowired
	private DoubtDao dDao;

	@Override
	public void saveDoubt(Doubt d, User user) throws DoubtSvcException {

		try {

			d.setCourse(user.getCourse().getCoursename());
			d.setEmail(user.getEmail());
			d.setName(user.getName());
			dDao.saveDoubt(d);

		} catch (Exception ex) {
			throw new DoubtSvcException(ex);
		}
	}

	@Override
	public void deleteDoubt(Doubt d) throws DoubtSvcException {
		try {

		} catch (Exception ex) {
			throw new DoubtSvcException(ex);
		}
	}

	@Override
	public List<Doubt> listDoubts(Doubt d) throws DoubtSvcException {
		List<Doubt> doubtlist = null;
		try {

		} catch (Exception ex) {
			throw new DoubtSvcException(ex);
		}
		return doubtlist;
	}

}
