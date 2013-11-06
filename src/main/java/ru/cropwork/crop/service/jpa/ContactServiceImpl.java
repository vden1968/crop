package ru.cropwork.crop.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import ru.cropwork.crop.domain.Contact;
import ru.cropwork.crop.repository.ContactRepository;
import ru.cropwork.crop.service.ContactService;

@Service
@Repository("contactService")
@Transactional
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactRepository contactRepository;

	@Transactional(readOnly=true)
	public List<Contact> findAll() {
		return Lists.newArrayList(contactRepository.findAll());
	}

	@Transactional(readOnly=true)
	public Contact findById(Long id) {
		return contactRepository.findOne(id);
	}

	
	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}

}
