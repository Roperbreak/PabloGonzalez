package es.gonzalez.AcademyBoxIt.service;

import java.util.List;

import es.gonzalez.AcademyBoxIt.model.Doubt;
import es.gonzalez.AcademyBoxIt.model.User;
import es.gonzalez.AcademyBoxIt.service.exceptions.DoubtSvcException;

public interface DoubtSvc {

	public void saveDoubt(Doubt d, User user) throws DoubtSvcException;

	public void deleteDoubt(Doubt d) throws DoubtSvcException;

	public List<Doubt> listDoubts(Doubt d) throws DoubtSvcException;

}
