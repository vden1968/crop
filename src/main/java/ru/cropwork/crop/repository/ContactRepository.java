package ru.cropwork.crop.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.cropwork.crop.domain.Contact;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {

}
