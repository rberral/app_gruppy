package service;

import java.util.List;

import bean.Persona;

public interface IPersonaService {
	public boolean addPersona(Persona p);
	public boolean removePersona(Persona p);
	public boolean updatePersona(Persona p);
	public List<Persona> listPersonas();
}
