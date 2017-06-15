package com.example.patientrecordsservice;

import com.example.patientrecordsservice.model.Observation;
import com.example.patientrecordsservice.model.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.stream.Stream;

@SpringBootApplication
public class PatientRecordsServiceApplication implements CommandLineRunner {

    @Autowired
    PatientRestResource patientRestResource;

    public static void main(String[] args) {
        SpringApplication.run(PatientRecordsServiceApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        Stream.of(new Patient("ABC-001", "Mario", "Romano", 33),
                new Patient("ABC-123", "Mauricio", "Salatino", 34)).forEach(patient -> {
            patientRestResource.save(patient);
        });
    }
}

@RepositoryRestResource(collectionResourceRel = "patient", path = "patient")
interface PatientRestResource extends PagingAndSortingRepository<Patient, Long> {
    //@TODO: Need query by SSN
}


@RepositoryRestResource(collectionResourceRel = "observation", path = "observation")
interface ObservationRestResource extends PagingAndSortingRepository<Observation, Long> {
    //@TODO: Need query by SSN
}




