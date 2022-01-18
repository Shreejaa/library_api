package com.training.libraryservice;

import com.training.libraryservice.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface LibraryRepository extends JpaRepository<Library, Long> {
    public List<Library> findByUserid(Long Userid);
}
