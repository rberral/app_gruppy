package service;

import java.util.List;

import bean.TablonAnuncios;

public interface ITablonService {
	public boolean addAnuncio(TablonAnuncios t);
	public boolean removeAnuncio(TablonAnuncios t);
	public boolean updateAnuncio(TablonAnuncios t);
	public List<TablonAnuncios> listAnuncios();
	public TablonAnuncios getAnuncio(int id);
}
