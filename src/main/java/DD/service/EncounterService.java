package DD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DD.entity.Encounter;
import DD.repository.EncounterRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DD.entity.Encounter;
import DD.repository.EncounterRepository;

@Service
public class EncounterService {
	@Autowired
	private EncounterRepository er;

	public EncounterService() {
	}

	public void setEncounterRepository(EncounterRepository er) {
		this.er = er;
	}

	public List<Encounter> getEncounters() {
		return this.er.findAll();
	}
	
	public String addEncounter(Encounter e) {
		return this.er.saveAndFlush(e).toString();
	}
}
