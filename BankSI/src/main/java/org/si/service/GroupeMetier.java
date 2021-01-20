package org.si.service;

import java.util.List;

import org.si.entities.Groupe;

public interface GroupeMetier {
	
	public Groupe addGroupe(Groupe groupe);

	public boolean removeGroupe(Groupe groupe);

	public List<Groupe> getAllGroupes();

	public List<Groupe> getGroupeByMc(String mc);

}
