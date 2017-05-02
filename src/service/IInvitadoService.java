package service;

import java.util.List;

import bean.Invitado;
import bean.Persona;


public interface IInvitadoService {
	public boolean addInvitado(Invitado i);
	public boolean removeInvitado(Invitado i);
	public boolean updateInvitado(Invitado i);
	public List<Invitado> listInvitados();
	public List<Invitado> listInvitados(Persona p);
	public Invitado getInvitado(int id);
}
