package service;

import java.util.List;
import java.util.logging.Logger;

import dao.AsociacionDAO;
import dao.TablonAnunciosDAO;
import bean.Persona;
import bean.TablonAnuncios;

public class TablonService implements ITablonService{
	private static final Logger logger = Logger.getLogger(TablonAnuncios.class.getName());

	private TablonAnunciosDAO TablonDAO = new TablonAnunciosDAO();


	@Override
	public boolean addAnuncio(TablonAnuncios t) {
		// TODO Auto-generated method stub
		return TablonDAO.addAnuncio(t);
	}

	@Override
	public boolean removeAnuncio(TablonAnuncios t) {
		// TODO Auto-generated method stub
		return TablonDAO.removeAnuncio(t);
	}

	@Override
	public boolean updateAnuncio(TablonAnuncios t) {
		// TODO Auto-generated method stub
		return TablonDAO.updateAnuncio(t);
	}

	@Override
	public List<TablonAnuncios> listAnuncios() {
		// TODO Auto-generated method stub
		return TablonDAO.listAnuncios();
	}

	@Override
	public TablonAnuncios getAnuncio(int id) {
		// TODO Auto-generated method stub
		return TablonDAO.getAnuncio(id);
	}
	
	public List<TablonAnuncios> listAnunciosPersona(Persona p){
		return TablonDAO.listAnunciosPersona(p);
	}
	

}
