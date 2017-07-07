package service;

import java.util.List;
import java.util.logging.Logger;

import util.Constantes;
import dao.AsociacionDAO;
import dao.DesgloseCuentasDAO;
import bean.DesgloseCuentas;
import bean.DesgloseCuentasAdicional;
import bean.Persona;

public class DesgloseService {
	private static final Logger logger = Logger.getLogger(DesgloseService.class.getName());

	private static final long serialVersionUID = 1L;
	private DesgloseCuentasDAO DesgloseDAO = new DesgloseCuentasDAO();
	
	public List<DesgloseCuentasAdicional> listDesgloseAdicional(int year,int tipo_cuota){
	return DesgloseDAO.listDesgloseAdicional(year,tipo_cuota);
	}
	
	public List<DesgloseCuentasAdicional> listDesgloseAdicional(int year){
		return DesgloseDAO.listDesgloseAdicional(year);
	}
	public List<DesgloseCuentasAdicional> listDesgloseAdicional(int year,Persona p){
		return DesgloseDAO.listDesgloseAdicional(year,p);
	}	
	public List<DesgloseCuentas> listDesgloseCuotas(int year){
	return DesgloseDAO.listDesgloseCuotas(year);
	}
	public List<DesgloseCuentas> listDesgloseCuotas(int year,Persona p){
	return DesgloseDAO.listDesgloseCuotas(year,p);
	}	
}
