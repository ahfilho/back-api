package br.com.api.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.entity.SacModel;
import br.com.api.repository.SacRepository;

@Service
@Transactional
public class SacService {

	@Autowired
	private SacRepository repositorySac;

	public SacModel saveSac(SacModel sacModel) {
		return this.repositorySac.save(sacModel);

	}

	public List<SacModel> sacList() {
		return this.repositorySac.findAll();
	}

	public SacModel sacUpdate(SacModel sacModel) throws Exception {

		Optional<SacModel> smu = this.repositorySac.findById(sacModel.getId());

		if (smu.isPresent()) {
			SacModel sac = smu.get();
			sac.setName(sacModel.getName());
			sac.setEmail(sacModel.getEmail());
			sac.setFone(sacModel.getMessage());
			sac.setFone(sacModel.getFone());
			return sac;
		} else {
			throw new Exception("ERRO AO ATUALIZAR O SAC" + sacModel.getId());
		}
	}

	public void delete(Long sacId) throws Exception {
		{
			Optional<SacModel> smd = this.repositorySac.findById(sacId);
			if (smd.isPresent()) {
				this.repositorySac.delete(smd.get());
			} else {
				throw new Exception("ERRO AO DELETAR O ID" + sacId);
			}

		}
	}

}
