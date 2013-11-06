package ru.cropwork.crop.service;

import java.util.List;
import ru.cropwork.crop.domain.Contact;

public interface ContactService {
	
	public List<Contact> findAll();
	
	public Contact findById(Long id);
	
	public Contact save(Contact contact);

}
