package service;

import java.util.List;

import bean.Asociacion;

public interface IAsociacionService {
	public boolean addAsociacion(Asociacion a);
	public boolean removeAsociacion(Asociacion a);
	public boolean updateAsociacion(Asociacion a);
	public List<Asociacion> listAsociaciones();
	public Asociacion getAsociacion();
}
