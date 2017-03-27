package service;

import java.util.List;
import java.util.logging.Logger;

import bean.Asociacion;
import service.AsociacionService;
import dao.AsociacionDAO;

public class AsociacionService implements IAsociacionService{
	private static final Logger logger = Logger.getLogger(AsociacionService.class.getName());
	
	private static final long serialVersionUID = 1L;
	private AsociacionDAO AsocDAO = new AsociacionDAO();
	
	@Override
	public boolean addAsociacion(Asociacion a) {
		// TODO Auto-generated method stub
		return AsocDAO.addAsociacion(a);
	}

	@Override
	public boolean removeAsociacion(Asociacion a) {
		// TODO Auto-generated method stub
		return AsocDAO.removeAsociacion(a);
	}

	@Override
	public boolean updateAsociacion(Asociacion a) {
		// TODO Auto-generated method stub
		return AsocDAO.updateAsociacion(a);
	}

	@Override
	public List<Asociacion> listAsociaciones() {
		// TODO Auto-generated method stub
		return AsocDAO.listAsociaciones();
	}

	@Override
	public Asociacion getAsociacion() {
		// TODO Auto-generated method stub
		return AsocDAO.listAsociaciones().get(0);
	}
	
}
