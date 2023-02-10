package com.example.library_model.service;

import com.example.library_model.model.Library;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class LibraryService {

    private static List<Library> libraries = new ArrayList<>();

    private static int libraryCount = 0;

    static {
        libraries.add(new Library(++libraryCount,"ABC","Mumbai","956842**45","Due to location"));
        libraries.add(new Library(++libraryCount,"CDE","kolkata","956842**54","Due to environment"));
        libraries.add(new Library(++libraryCount,"EFG","Hyderabad","956842**65","Due to book's quality"));
        libraries.add(new Library(++libraryCount,"GHI","Haryana","956842**65","Due to book's availability"));
        libraries.add(new Library(++libraryCount,"IJK","Bangalore","956842**75","Due to behaviour"));
    }
    @GetMapping("find-all")
    public List<Library> findAllLibrary(){
        return libraries;
    }
    public Library findById(int id){
        Predicate<? super Library> predicate = library -> library.getId()==id;
        Library library = libraries.stream().filter(predicate).findFirst().get();
        return library;
    }
    public void addLibrary(Library library){
        libraries.add(library);
    }
    public void deleteLibrary(int id){
        Predicate<? super Library> predicate = library -> library.getId()==id;
        libraries.removeIf(predicate);
    }
    public void updateLibrary(int id, Library newLibrary){
        Library library = findById(id);
        library.setId(newLibrary.getId());
        library.setName(newLibrary.getName());
        library.setAddress(newLibrary.getAddress());
        library.setNumber(newLibrary.getNumber());
        library.setFacility(newLibrary.getFacility());
    }
}