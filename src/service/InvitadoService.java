package service;

import java.util.List;
import java.util.logging.Logger;

import dao.InvitadoDAO;
import bean.Invitado;
import bean.Persona;

public class InvitadoService implements IInvitadoService{
	private static final Logger logger = Logger.getLogger(InvitadoService.class.getName());
	
	private static final long serialVersionUID = 1L;
	private InvitadoDAO dao = new InvitadoDAO();


	@Override
	public boolean addInvitado(Invitado i) {
		// TODO Auto-generated method stub
		return dao.addInvitado(i);
	}

	@Override
	public boolean removeInvitado(Invitado i) {
		// TODO Auto-generated method stub
		return dao.removeInvitado(i);
	}

	@Override
	public boolean updateInvitado(Invitado i) {
		// TODO Auto-generated method stub
		return dao.updateInvitado(i);
	}

	@Override
	public List<Invitado> listInvitados() {
		// TODO Auto-generated method stub
		return dao.listInvitados();
	}

	@Override
	public List<Invitado> listInvitados(Persona p) {
		// TODO Auto-generated method stub
		return dao.listInvitados(p);
	}

	@Override
	public Invitado getInvitado(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
/*	public boolean removeInvitado(int id) {
		// TODO Auto-generated method stub
		return dao.removeInvitado(id);
	}*/

	}
